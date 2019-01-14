/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Embeddable
public class CartModel
{
    @Column(nullable = false)
    protected String code;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<CartItem> items = new ArrayList<>();


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


    @Override
    public String toString()
    {
        return "CartModel{" +
            "code='" + code + '\'' +
            ", items=" + items +
            '}';
    }
}
