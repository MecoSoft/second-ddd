/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.product;


import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ProductModel
{
    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String code;


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getCode()
    {
        return code;
    }


    public void setCode(String code)
    {
        this.code = code;
    }


    @Override
    public String toString()
    {
        return "ProductModel{" +
            "name='" + name + '\'' +
            ", code='" + code + '\'' +
            '}';
    }
}
