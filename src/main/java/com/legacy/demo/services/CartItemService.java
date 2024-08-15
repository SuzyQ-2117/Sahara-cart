package com.legacy.demo.services;

import com.legacy.demo.entities.Cart;
import com.legacy.demo.repos.CartItemRepo;
import com.legacy.demo.entities.CartItem;
import com.legacy.demo.dtos.CartItemDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CartItemService {

    private final CartItemRepo repo;

    public CartItemService(CartItemRepo repo) {
        this.repo = repo;
    }

    public List<CartItemDto> getAll() {
        List<CartItemDto> dtos = new ArrayList<>();
        List<CartItem> found = this.repo.findAll();
        for (CartItem cartItem : found) {
            dtos.add(new CartItemDto(cartItem));
        }
        return dtos;
    }

    public ResponseEntity<?> getCartItem(Integer id) {
        Optional<CartItem> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No CartItem found with id " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new CartItemDto(found.get()));
    }

    public ResponseEntity<CartItemDto> addCartItem(CartItem newCartItem) {
        CartItem created = this.repo.save(newCartItem);

        return new ResponseEntity<>(new CartItemDto(created), HttpStatus.CREATED);
    }

    public ResponseEntity<?> removeCartItem(Integer id) {
        Optional<CartItem> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No CartItem found with id " + id, HttpStatus.NOT_FOUND);
        }
        this.repo.deleteById(id);
        return ResponseEntity.ok("CartItem with id " + id + " has been deleted.");

    }

    public ResponseEntity<?> cartItemUpdate(Integer id,
                                            String name,
                                            Double price,
                                            Integer quantity, Cart cart){

        Optional<CartItem> found = this.repo.findById(id);
        if (found.isEmpty()) {
            return new ResponseEntity<>("No CartItem found with ID " + id, HttpStatus.NOT_FOUND);
        }

        CartItem toUpdate = found.get();

        if (name != null) toUpdate.setName(name);
        if (price != null) toUpdate.setPrice(price);
        if (quantity != null) toUpdate.setQuantity(quantity);

        if(cart != null) toUpdate.setCart(cart);


        CartItem updated = this.repo.save(toUpdate);
        return ResponseEntity.ok(new CartItemDto(updated));
    }
}