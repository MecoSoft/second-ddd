/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.product;


import javax.persistence.*;


@Entity
public class Product
{
    @Id
    @GeneratedValue
    private Long id;

    private ProductData data;


    public Product()
    {}


    public Product(final String code, final String name)
    {
        data = new ProductData();

        data.setName(name);
        data.setCode(code);
    }

    public void setName(final String name)
    {
        data.setName(name);
    }
}
