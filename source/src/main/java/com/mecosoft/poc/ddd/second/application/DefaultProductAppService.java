/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductData;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductRepository;
import com.mecosoft.poc.ddd.second.help.annotation.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@ApplicationService
public class DefaultProductAppService implements ProductAppService
{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductData defineNewProduct(final String code, final String name)
    {
        Product product = new Product(code, name);
        productRepository.save(product);

        return product.generateSnapshot();
    }


    @Override
    public ProductData getProductDate(String code)
    {
        List<Product> products = productRepository.findByCode(code);
        if (products.size() == 0) {
            return null;
        }

        return products.get(0).generateSnapshot();
    }


    @Override
    public void updateProductDate(String code, ProductData data)
    {
        Product product = productRepository.findByCode(code).get(0);
        product.updateAttributes(data);
    }
}
