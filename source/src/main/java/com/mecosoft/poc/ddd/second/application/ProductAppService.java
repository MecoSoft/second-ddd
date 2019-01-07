package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.product.ProductData;


/**
 * Service responsible for handling products.
 */
public interface ProductAppService
{
    ProductData defineNewProduct(final String code, final String name);

    ProductData getProductDate(final String code);

    void updateProductDate(final String code, final ProductData data);
}
