package com.legacy.demo.controllers;

import com.legacy.demo.entities.Cart;
import com.legacy.demo.dtos.CartDto;
import com.legacy.demo.services.CartItemService;
import com.legacy.demo.services.CartService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {

    private CartService service;

    public CartController(CartService service){this.service = service;}

    @GetMapping("cart/getAll")
    public List<CartDto> getAll() {return this.service.getAll();}

    @GetMapping("cart/{id}")
    public ResponseEntity<?> getCart(@PathVariable Integer id) { return this.service.getCart(id);}

    @PostMapping("cart/add")
    public ResponseEntity<?> addCart(@RequestBody Cart cart) { return this.service.addCart(cart);}

    @PatchMapping("cart/update/{id}")
    public ResponseEntity<?> updateCart(@PathVariable Integer id, @RequestBody Cart updateCart) {
        return this.service.updateCart(id,
                updateCart.getCartTotal(),
                updateCart.getServiceCharge(),
                updateCart.getOrderStatus()
    );
    }

}
