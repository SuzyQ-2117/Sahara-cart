package com.legacy.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.legacy.demo.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository <Cart, Integer> {

}