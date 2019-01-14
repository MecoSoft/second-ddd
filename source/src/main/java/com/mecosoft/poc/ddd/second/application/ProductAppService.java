package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.product.ProductModel;


/**
 * Service responsible for handling products.
 */
public interface ProductAppService
{
    ProductModel defineNewProduct(final String code, final String name);

    ProductModel getProductDate(final String code);

    void updateProductModel(final String code, final ProductModel model);
}
