package com.mecosoft.poc.ddd.second.application;


// TODO: Warstwa aplikacji musi zwrocic DTO

/**
 * Service responsible for handling products.
 */
public interface ProductAppService
{
    ProductDTO defineNewProduct(final String code, final String name);

    ProductDTO getProductDate(final String code);

    void updateProductModel(final String code, final ProductModel model);
}
