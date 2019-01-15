/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.model.cart.Cart;
import com.mecosoft.poc.ddd.second.domain.model.cart.CartRepository;
import com.mecosoft.poc.ddd.second.domain.model.product.Product;
import com.mecosoft.poc.ddd.second.domain.model.product.ProductRepository;
import com.mecosoft.poc.ddd.second.help.annotation.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@ApplicationService
public class CartAppServiceImpl implements CartAppService
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;


    @Override
    public CartDTO defineNewCart(final String code)
    {
        Cart cart = new Cart(code);
        CartModel cartModel = cartRepository.save(cart).generateModelSnapshot();

        return new CartDTO(cartModel);
    }


    @Override
    public void addProductToCart(String cartCode, String productCode, int quantity)
    {
        List<Product> products = productRepository.findByCode(productCode);
        if (products.isEmpty()) {
            return;
        }

        Product product = products.get(0);

        List<Cart> carts = cartRepository.findByCode(cartCode);
        if (carts.isEmpty())
        {
            return;
        }

        Cart cart = carts.get(0);
        cart.add(product, quantity);
        cartRepository.save(cart);
    }


    @Override
    public void removeProductFromCart(String cartCode, String productCode)
    {
        List<Product> products = productRepository.findByCode(productCode);
        if (products.isEmpty()) {
            return;
        }

        Product product = products.get(0);

        List<Cart> carts = cartRepository.findByCode(cartCode);
        if (carts.isEmpty())
        {
            return;
        }

        Cart cart = carts.get(0);
        cart.remove(product);
        cartRepository.save(cart);
    }


    @Override
    public CartDTO getCartDate(String code)
    {
        List<Cart> carts = cartRepository.findByCode(code);
        if (carts.size() == 0) {
            return null;
        }

        CartModel cartModel = carts.get(0).generateModelSnapshot();

        return new CartDTO(cartModel);
    }


    @Override
    public void updateCartDate(String code, CartModel model)
    {
        Cart cart = cartRepository.findByCode(code).get(0);
        cart.updateModel(model);
    }
}
