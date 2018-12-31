package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.product.Product;


/**
 * Service responsible for handling products.
 */
public interface ProductAppService
{
    Product defineNewProduct(final String code, final String name);
}
