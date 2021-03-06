/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.product.Product;
import com.mecosoft.poc.ddd.second.domain.product.ProductRepository;
import com.mecosoft.poc.ddd.second.help.annotation.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


@Transactional
@ApplicationService
public class DefaultProductAppService implements ProductAppService
{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product defineNewProduct(final String code, final String name)
    {
        Product product = new Product(code, name);
        productRepository.save(product);

        return product;
    }
}
