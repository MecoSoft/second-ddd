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
import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart implements EntityBase<CartData>
{
    @Id
    @GeneratedValue
    protected Long id;

    @Column(nullable = false)
    protected String code;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<CartItem> items = new ArrayList<>();


    public Cart()
    {}


    public Cart(final String code)
    {
        this.code = code;
    }


    public void add(Product product, int quantity)
    {
        CartItem cartItem = new CartItem(product, quantity);
        items.add(cartItem);
    }


    @Override
    public CartData generateSnapshot()
    {
        CartData data = new CartData();
        data.setId(id);
        data.setCode(code);
        data.setItems(items);

        return data;
    }


    @Override
    public void updateAttributes(CartData data)
    {
        code = data.getCode();
        items = data.getItems();
    }
}
