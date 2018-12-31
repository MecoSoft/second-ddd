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
import com.mecosoft.poc.ddd.second.domain.product.Product;
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


    @RequestMapping("/")
    String home()
    {
        Product product = productAppService.defineNewProduct("code-123", "name-123");
        product.setName("dupaJeza");

        cartAppService.defineNewCart("code-123");

        cartAppService.addProductToCart("code-123", "code-123", 2);
        //productAppService.addNewProduct("cos");

        return "Hello World!";

    }
}
