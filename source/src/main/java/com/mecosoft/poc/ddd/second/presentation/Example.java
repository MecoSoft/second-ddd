/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.presentation;

import com.mecosoft.poc.ddd.second.application.CartAppService;
import com.mecosoft.poc.ddd.second.application.ProductAppService;
import com.mecosoft.poc.ddd.second.domain.model.cart.Cart;
import com.mecosoft.poc.ddd.second.domain.model.cart.CartData;
import com.mecosoft.poc.ddd.second.domain.model.cart.CartItem;
import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


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

        ProductData productData = productAppService.defineNewProduct(PRODUCT_CODE + suffix, PRODUCT_NAME);

        return "New product defined: " + productData;
    }


    @RequestMapping("/addNewCart")
    String addNewCart()
    {
        int suffix = 0;
        do {
            suffix++;
        } while (cartAppService.getCartDate(CART_CODE + suffix) != null);

        CartData cartDataNew = cartAppService.defineNewCart(CART_CODE + suffix);

        return "New cart defined: " + cartDataNew;
    }


    /*
     * Display cart details.
     */
    @RequestMapping("/displayCart/{cartCode}")
    String displayCart(@PathVariable("cartCode") String cartCode)
    {
        List<CartItem> items = cartAppService.getCartDate(cartCode).getItems();

        String cartContent = "Cart contains '" + items.size() + "' items: ";
        for (CartItem item : items)
        {
            String code = item.generateSnapshot().getProduct().generateSnapshot().getCode();
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
        CartData cartData = cartAppService.getCartDate(cartCode);
        CartItem item = cartData.getItems().stream()
            .filter(p -> p.generateSnapshot().getProduct().generateSnapshot().getCode().equalsIgnoreCase(prodCode))
            .findFirst()
            .get();

        List<CartItem> items = cartData.getItems();
        items.remove(item);
        cartAppService.updateCartDate(cartCode, cartData);

        return "Ok";
    }


    @RequestMapping("/addProdToCart/{cartCode}/{prodCode}")
    String addProdToCart(@PathVariable("cartCode") String cartCode, @PathVariable("prodCode") String prodCode)
    {
        cartAppService.addProductToCart(cartCode, prodCode, PRODUCT_QTY);

        return "Ok";
    }


    @RequestMapping("/renameProdCode/{oldProdCode}/{newProdCode}")
    String changeProdCode(@PathVariable("oldProdCode") String oldProdCode, @PathVariable("newProdCode") String newProdCode)
    {
        ProductData data = productAppService.getProductDate(oldProdCode);
        data.setCode(newProdCode);

        productAppService.updateProductDate(oldProdCode, data);
        return "Ok";
    }
}
