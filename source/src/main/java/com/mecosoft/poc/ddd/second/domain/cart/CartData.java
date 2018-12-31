/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.cart;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Embeddable
public class CartData
{
    @Column(nullable = false)
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>();


    public String getCode()
    {
        return code;
    }


    public void setCode(String name)
    {
        this.code = name;
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
