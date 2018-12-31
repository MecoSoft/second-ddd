/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.cart;


import com.mecosoft.poc.ddd.second.domain.product.Product;

import javax.persistence.*;


@Entity
public class Cart
{
    @Id
    @GeneratedValue
    private Long id;

    private CartData data;


    public Cart()
    {}


    public Cart(final String code)
    {
        data = new CartData();

        data.setCode(code);
    }


    public void add(Product product, int quantity)
    {
        CartItem cartItem = new CartItem(product, quantity);
        data.getItems().add(cartItem);
    }
}
