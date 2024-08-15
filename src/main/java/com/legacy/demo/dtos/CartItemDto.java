package com.legacy.demo.dtos;


import com.legacy.demo.entities.CartItem;



public class CartItemDto {

    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private Double itemTotal;

    public CartItemDto(Integer id, String name, Double price, Integer quantity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.itemTotal = price*quantity;

    }
    public CartItemDto() {
        super();
    }

    public CartItemDto(CartItem cartItem){
         super();
        this.id = cartItem.getId();
        this.name = cartItem.getName();
        this.price = cartItem.getPrice();
        this.quantity = cartItem.getQuantity();
        this.itemTotal = cartItem.getPrice()* cartItem.getQuantity();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Double itemTotal) {
        this.itemTotal = itemTotal;
    }
}
