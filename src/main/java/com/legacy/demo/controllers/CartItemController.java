package com.legacy.demo.controllers;

import com.legacy.demo.entities.CartItem;
import com.legacy.demo.dtos.CartItemDto;
import com.legacy.demo.services.CartItemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartItemController {

    private CartItemService service;

    public CartItemController(CartItemService service) { this.service = service;}

    @GetMapping("/cartitems/getAll")
    public List<CartItemDto> getAll() {return this.service.getAll();}

    @GetMapping("/cartitems/get/{id}")
    public ResponseEntity<?> getItem(@PathVariable Integer id) {return this.service.getCartItem(id);}

    @PostMapping("/cartitems/add")
    public ResponseEntity<?> addItem(@RequestBody CartItem cartItem){
        return this.service.addCartItem(cartItem);
    }
    @DeleteMapping("/cartitems/remove/{id}")
    public ResponseEntity<?> removeItem(@PathVariable Integer id){
        return this.service.removeCartItem(id);
    }

    @PatchMapping ("/cartitems/update/{id}")
    public ResponseEntity<?> updateCartItem(@PathVariable Integer id,
                                        @RequestBody CartItem updateCartItem){

        return this.service.cartItemUpdate(id,
                updateCartItem.getName(),
                updateCartItem.getPrice(),
                updateCartItem.getQuantity(),
                updateCartItem.getCart());
    }

}
