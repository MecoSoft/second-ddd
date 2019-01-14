/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.help.EntityBase;

import javax.persistence.*;


@Entity
public class CartItem extends EntityBase<Long, CartItemModel>
{
    public CartItem()
    {}


    public CartItem(final Product product, int quantity)
    {
        model = new CartItemModel();
        model.setProduct(product);
        model.setQuantity(quantity);
    }
}
