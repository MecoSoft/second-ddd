/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.presentation;

import com.mecosoft.poc.ddd.second.application.*;
import com.mecosoft.poc.ddd.second.domain.model.cart.CartItem;
import com.mecosoft.poc.ddd.second.domain.model.cart.CartModel;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Example
{
    @Autowired
    private ProductAppService productAppService;

    @Autowired
    private CartAppService cartAppService;


    private static final String PRODUCT_CODE = "code-123-";
    private static final String PRODUCT_NAME = "name-123";
    private static final String CART_CODE = "code-098-";
    private static final int PRODUCT_QTY = 2;


    @RequestMapping("/")
    String home()
    {
        return null;
    }


    @RequestMapping("/addNewProduct")
    String addNewProduct()
    {
        int suffix = 0;
        do {
            suffix++;
        } while (productAppService.getProductDate(PRODUCT_CODE + suffix) != null);

        ProductDTO productDto = productAppService.defineNewProduct(PRODUCT_CODE + suffix, PRODUCT_NAME);

        return "New product defined: " + productDto;
    }


    @RequestMapping("/addNewCart")
    String addNewCart()
    {
        int suffix = 0;
        do {
            suffix++;
        } while (cartAppService.getCartDate(CART_CODE + suffix) != null);

        CartDTO cartDataNew = cartAppService.defineNewCart(CART_CODE + suffix);

        return "New cart defined: " + cartDataNew;
    }


    /*
     * Display cart details.
     */
    @RequestMapping("/displayCart/{cartCode}")
    String displayCart(@PathVariable("cartCode") String cartCode)
    {
        List<CartItemDTO> items = cartAppService.getCartDate(cartCode).getItems();

        String cartContent = "Cart contains '" + items.size() + "' items: ";
        for (CartItemDTO item : items)
        {
            String code = item.getProduct().getCode();
            cartContent += "'" + code + "', ";
        }

        cartContent += ";";

        return cartContent;
    }


    /*
     * Remove product from a cart by use CartData, not by command for testing purpose.
     */
    @RequestMapping("/removeProdFromCart/{cartCode}/{prodCode}")
    String removeProdFromCart(@PathVariable("cartCode") String cartCode, @PathVariable("prodCode") String prodCode)
    {
        /*
         * Remove product from a cart by use CartData, not by command for testing purpose.
         */
        // cartAppService.removeProductFromCart(cartCode, prodCode);



        return "Ok";
    }


    @RequestMapping("/addProdToCart/{cartCode}/{prodCode}")
    String addProdToCart(@PathVariable("cartCode") String cartCode, @PathVariable("prodCode") String prodCode)
    {
        cartAppService.addProductToCart(cartCode, prodCode, PRODUCT_QTY);

        return "Ok";
    }


    /*
     * Update product by use model access, not by command for testing purpose.
     */
    @RequestMapping("/renameProdCode/{oldProdCode}/{newProdCode}")
    String changeProdCode(@PathVariable("oldProdCode") String oldProdCode, @PathVariable("newProdCode") String newProdCode)
    {
        ProductDTO productDto = productAppService.getProductDate(oldProdCode);
        productDto.setCode(newProdCode);

        //productAppService.updateProductModel(oldProdCode, model);
        return "Ok";
    }
}
