package com.legacy.demo.entities;


import jakarta.persistence.*;
import java.util.List;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany (mappedBy="cart")
    private List<CartItem> cartItemList;

    private Double cartTotal;
    private Double serviceCharge;
    private String orderStatus;

    public Cart(Integer id, List<CartItem> cartItemList, Double cartTotal, Double serviceCharge, String orderStatus) {
        this.id = id;
        this.cartItemList = cartItemList;
        this.cartTotal = cartTotal;
        this.serviceCharge = serviceCharge;
        this.orderStatus = orderStatus;
    }

    public Cart() {
    }

    public Cart(Integer id, Double cartTotal, Double serviceCharge, String orderStatus) {
        this.id = id;
        this.cartTotal = cartTotal;
        this.serviceCharge = serviceCharge;
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
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
