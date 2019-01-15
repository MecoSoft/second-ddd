/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.domain.model.product;


import com.mecosoft.poc.ddd.second.help.BusinessObject;


public class Product extends BusinessObject<ProductEntity, Long, ProductRepository>
{
    public Product(ProductEntity entity)
    {
        super(entity);
    }
}
