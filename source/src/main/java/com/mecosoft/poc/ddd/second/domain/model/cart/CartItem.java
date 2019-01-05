/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.help.annotation.EntityBase;

import javax.persistence.*;


@Entity
public class CartItem implements EntityBase<CartItemData>
{
    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne(optional = false)
    protected Product product;

    @Column(nullable = false)
    protected int quantity;


    public CartItem()
    {}


    public CartItem(final Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }


    @Override
    public CartItemData generateSnapshot()
    {
        CartItemData data = new CartItemData();
        data.setId(id);
        data.setQuantity(quantity);
        data.setProduct(product);

        return data;
    }


    @Override
    public void updateAttributes(CartItemData data)
    {
        product = data.getProduct();
        quantity = data.getQuantity();
    }
}
