/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import java.util.List;


public class CartData
{
    protected Long id;

    protected String code;

    protected List<CartItem> items;


    public Long getId()
    {
        return id;
    }


    protected void setId(Long id)
    {
        this.id = id;
    }


    public String getCode()
    {
        return code;
    }


    public void setCode(String code)
    {
        this.code = code;
    }


    public List<CartItem> getItems()
    {
        return items;
    }


    public void setItems(List<CartItem> items)
    {
        this.items = items;
    }
}
