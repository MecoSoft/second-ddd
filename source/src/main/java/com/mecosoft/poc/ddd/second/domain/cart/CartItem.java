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
public class CartItem
{
    @Id
    @GeneratedValue
    private Long id;

    private CartItemData data;


    public CartItem()
    {}


    public CartItem(final Product product, int quantity)
    {
        data = new CartItemData();

        data.setProduct(product);
        data.setQuantity(quantity);
    }
}
