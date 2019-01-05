/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;


public class CartItemData
{
    protected Long id;

    protected Product product;

    protected int quantity;


    public Long getId()
    {
        return id;
    }


    protected void setId(Long id)
    {
        this.id = id;
    }


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
}
