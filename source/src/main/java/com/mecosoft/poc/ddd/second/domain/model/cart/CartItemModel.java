/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class CartItemModel
{
    @ManyToOne(optional = false)
    protected Product product;

    @Column(nullable = false)
    protected int quantity;


    public Product getProduct()
    {
        return product;
    }


    public void setProduct(Product product)
    {
        this.product = product;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


    @Override
    public String toString()
    {
        return "CartItemModel{" +
            "product=" + product +
            ", quantity=" + quantity +
            '}';
    }
}
