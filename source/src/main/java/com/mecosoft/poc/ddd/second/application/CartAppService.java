package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.cart.Cart;


/**
 * Service responsible for handling carts.
 */
public interface CartAppService
{
    Cart defineNewCart(final String code);

    void addProductToCart(String cartCode, String productCode, int quantity);
}
