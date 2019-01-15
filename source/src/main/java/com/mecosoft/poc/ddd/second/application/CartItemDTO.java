/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.cart.CartItemModel;


public class CartItemDTO
{
    protected ProductDTO product;

    protected int quantity;


    public CartItemDTO()
    {}


    public CartItemDTO(CartItemModel model)
    {
        this.product = new ProductDTO(model.getProduct().generateModelSnapshot());
        this.quantity = model.getQuantity();
    }

    public ProductDTO getProduct()
    {
        return product;
    }


    public void setProduct(ProductDTO product)
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
