/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.help.Identifiable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class CartEntity implements Identifiable<Long>
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItemEntity> items = new ArrayList<>();


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
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


    public List<CartItemEntity> getItems()
    {
        return items;
    }


    public void setItems(List<CartItemEntity> items)
    {
        this.items = items;
    }


    public void addItem(CartItemEntity item)
    {
        items.add(item);
    }


    public void removeItem(CartItemEntity item)
    {
        items.remove(item);
    }
}
