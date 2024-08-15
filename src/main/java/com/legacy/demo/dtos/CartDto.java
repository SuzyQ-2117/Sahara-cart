package com.legacy.demo.dtos;

import com.legacy.demo.entities.Cart;
import com.legacy.demo.entities.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

    private Integer id;

    private List<CartItemDto> cartItemList = new ArrayList<>();

    private Double cartTotal;
    private Double serviceCharge;
    private String orderStatus;

    public CartDto(Cart cart) {
        this.id = cart.getId();
        this.cartTotal = cart.getCartTotal();
        this.serviceCharge = cart.getServiceCharge();
        this.orderStatus = cart.getOrderStatus();
        if (cart.getCartItemList() != null) {
            for (CartItem cartItem : cart.getCartItemList()) {
                this.cartItemList.add(new CartItemDto(cartItem));
            }
        }
    }
    public CartDto(List<CartItemDto> cartItems) {
        super();
            }

    public CartDto() {super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItemDto> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItemDto> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
