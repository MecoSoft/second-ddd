/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductModel;
import com.mecosoft.poc.ddd.second.help.EntityBase;
import org.apache.commons.collections.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.awt.*;
import java.util.*;
import java.util.List;


@Entity
public class Cart extends EntityBase<Long, CartModel>
{
    public Cart()
    {}


    public Cart(final String code)
    {
        model = new CartModel();
        model.setCode(code);
    }


    public void add(Product product, int quantity)
    {
        CartItem cartItem = new CartItem(product, quantity);
        model.getItems().add(cartItem);
    }


    public void remove(Product product)
    {
        CartModel model = super.generateModelSnapshot();

        for (CartItem item : model.getItems())
        {
            String itemProdCode = item.generateModelSnapshot().getProduct().generateModelSnapshot().getCode();
            String prodCode = product.generateModelSnapshot().getCode();
            if (itemProdCode.equalsIgnoreCase(prodCode))
            {
                model.getItems().remove(item);
            }
        }
    }


    @Override
    public CartModel generateModelSnapshot()
    {
        CartModel model = super.generateModelSnapshot();

        List<CartItem> items = new ArrayList<>();
        CollectionUtils.addAll(items, model.getItems().iterator());
        model.setItems(items);

        return model;
    }
}
