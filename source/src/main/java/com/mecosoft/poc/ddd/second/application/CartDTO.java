/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.cart.CartItem;
import com.mecosoft.poc.ddd.second.domain.model.cart.CartModel;

import java.util.ArrayList;
import java.util.List;


public class CartDTO
{
    protected String code;

    protected List<CartItemDTO> items = new ArrayList<>();


    public CartDTO()
    {}


    public CartDTO(CartModel model)
    {
        this.code = model.getCode();

        for (CartItem item : model.getItems())
        {
            this.items.add(new CartItemDTO(item.generateModelSnapshot()));
        }
    }


    public String getCode()
    {
        return code;
    }


    public void setCode(String code)
    {
        this.code = code;
    }


    public List<CartItemDTO> getItems()
    {
        return items;
    }


    public void setItems(List<CartItemDTO> items)
    {
        this.items = items;
    }


    @Override
    public String toString()
    {
        return "CartModel{" +
            "code='" + code + '\'' +
            ", items=" + items +
            '}';
    }
}
