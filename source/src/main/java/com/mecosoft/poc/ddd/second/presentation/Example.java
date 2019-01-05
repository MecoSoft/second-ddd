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
import com.mecosoft.poc.ddd.second.domain.model.cart.CartData;
import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Example
{
    @Autowired
    private ProductAppService productAppService;

    @Autowired
    private CartAppService cartAppService;


    private static final String PRODUCT_CODE = "code-123";
    private static final String PRODUCT_NAME = "name-123";
    private static final String CART_CODE = "code-098";
    private static final int PRODUCT_QTY = 2;


    @RequestMapping("/")
    String home()
    {
        // Define a new c art
        cartAppService.defineNewCart(CART_CODE);

        // Define a new product
        productAppService.defineNewProduct(PRODUCT_CODE, PRODUCT_NAME);

        // Add product to cart
        cartAppService.addProductToCart(CART_CODE, PRODUCT_CODE, PRODUCT_QTY);

        // Change product name
        ProductData productDate = productAppService.getProductDate(PRODUCT_CODE);
        productDate.setName("dupa");
        productAppService.updateProductDate(PRODUCT_CODE, productDate);

        // Display name of first product from cart
        String name = cartAppService.getCartDate(CART_CODE).getItems().get(0).generateSnapshot().getProduct().generateSnapshot().getName();
        return "Cart contains product '" + name + "'.";
    }
}
