package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.cart.CartModel;


/**
 * Service responsible for handling carts.
 */
public interface CartAppService
{
    CartModel defineNewCart(final String code);

    void addProductToCart(String cartCode, String productCode, int quantity);

    void removeProductFromCart(String cartCode, String productCode);

    CartModel getCartDate(final String code);

    void updateCartDate(final String code, final CartModel model);
}
