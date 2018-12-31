/*
 * MecoSoft 2017
 * The copyright to the computer program(s) herein is the property of MecoSoft.
 * The programs may be used and/or copied only with written permission from
 * MecoSoft or in accordance with the terms and  conditions stipulated in the
 * agreement under which the programs have  been supplied.
 */

package com.mecosoft.poc.ddd.second.application;


import com.mecosoft.poc.ddd.second.domain.cart.Cart;
import com.mecosoft.poc.ddd.second.domain.cart.CartRepository;
import com.mecosoft.poc.ddd.second.domain.product.Product;
import com.mecosoft.poc.ddd.second.domain.product.ProductRepository;
import com.mecosoft.poc.ddd.second.help.annotation.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@ApplicationService
public class DefaultCartAppService implements CartAppService
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;


    @Override
    public Cart defineNewCart(final String code)
    {
        Cart cart = new Cart(code);
        cartRepository.save(cart);

        return cart;
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
}
