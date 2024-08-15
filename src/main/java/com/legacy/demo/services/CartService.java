package com.legacy.demo.services;

import com.legacy.demo.repos.CartRepo;
import com.legacy.demo.entities.Cart;
import com.legacy.demo.dtos.CartDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CartService {
    private final CartRepo repo;

    public CartService(CartRepo repo) {this.repo = repo;}

    public List<CartDto> getAll() {
        List<CartDto> dtos = new ArrayList<>();
        List<Cart> found = this.repo.findAll();
        for (Cart cart : found) {
            dtos.add(new CartDto(cart));
        }
        return dtos;
    }

    public ResponseEntity<?> getCart(Integer id){
        Optional<Cart> found = this.repo.findById(id);
        if(found.isEmpty()){
            return new ResponseEntity<>("no Cart found with cart id " + id, HttpStatus.NOT_FOUND);
        }
            return ResponseEntity.ok(new CartDto(found.get()));
    }

    public ResponseEntity<?> addCart(Cart newCart){
        Cart created = this.repo.save(newCart);
        return new ResponseEntity<>(new CartDto(created), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCart(Integer id, Double cartTotal, Double serviceCharge, String orderStatus){
        Optional<Cart> found = this.repo.findById(id);
        if(found.isEmpty()) {
            return new ResponseEntity<>("No Cart found with id "+ id, HttpStatus.NOT_FOUND);
        }
        Cart toUpdate = found.get();
        if(cartTotal != null) toUpdate.setCartTotal(cartTotal);
        if(serviceCharge != null) toUpdate.setServiceCharge(serviceCharge);
        if(orderStatus != null) toUpdate.setOrderStatus(orderStatus);
        Cart updated = this.repo.save(toUpdate);
        return ResponseEntity.ok(new CartDto(updated));
    }

}
