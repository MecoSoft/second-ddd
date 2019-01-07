/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.product;


import com.mecosoft.poc.ddd.second.help.annotation.EntityBase;

import javax.persistence.*;


@Entity
public class Product implements EntityBase<ProductData>
{
    @Id
    @GeneratedValue
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String code;


    public Product()
    {}


    public Product(final String code, final String name)
    {
        this.code = code;
        this.name = name;
    }


    @Override
    public ProductData generateSnapshot()
    {
        ProductData data = new ProductData();
        data.setId(id);
        data.setCode(code);
        data.setName(name);

        return data;
    }


    @Override
    public void updateAttributes(ProductData data)
    {
        name = data.getName();
        code = data.getCode();
    }
}
