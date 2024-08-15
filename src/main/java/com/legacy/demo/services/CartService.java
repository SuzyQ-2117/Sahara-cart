package com.legacy.demo.services;

import com.legacy.demo.entities.Cart;
import com.legacy.demo.classes.CartItemData;
import com.legacy.demo.repos.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    private static final int ID_LENGTH = 6;
    private static final Set<String> generatedIds = new HashSet<>(); // Track generated IDs to ensure uniqueness
    private static final Random random = new Random();


    @Transactional
    public String createCartWithItems(List<CartItemData> items) {

        String cartId = generateOrderId();

        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setItems(items);
        cart.setStatus("in progress");

        cartRepository.save(cart);
        return cartId;
    }


    public List<CartItemData> getCart(String cartId) {
        return cartRepository.findById(cartId)
                .map(Cart::getItems)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    private String generateOrderId() {
        String orderId;
        do {
            orderId = String.format("%06d", random.nextInt(1000000)); // Generates a 6-digit number
        } while (generatedIds.contains(orderId)); // Ensure uniqueness
        generatedIds.add(orderId); // Add the new ID to the set
        return orderId;
    }
}
