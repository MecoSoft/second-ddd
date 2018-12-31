package com.mecosoft.poc.ddd.second.domain.cart;


import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Long>
{
}
