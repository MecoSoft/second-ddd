/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


public class ProductDTO
{
    protected String name;

    protected String code;


    public ProductDTO()
    {}


    public ProductDTO(ProductModel model)
    {
        this.name = model.getName();
        this.code = model.getCode();
    }


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
