package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.cart.CartData;


/**
 * Service responsible for handling carts.
 */
public interface CartAppService
{
    CartData defineNewCart(final String code);

    void addProductToCart(String cartCode, String productCode, int quantity);

    CartData getCartDate(final String code);

    void updateCartDate(final String code, final CartData data);
}
