package com.mecosoft.poc.ddd.second.domain.model.cart;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long>
{
    @Query("SELECT c FROM Cart c WHERE c.model.code = :code")
    List<Cart> findByCode(String code);
}
