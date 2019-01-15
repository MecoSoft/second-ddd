/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.cart;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.help.Identifiable;

import javax.persistence.*;


@Entity
public class CartItemEntity implements Identifiable<Long>
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
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
