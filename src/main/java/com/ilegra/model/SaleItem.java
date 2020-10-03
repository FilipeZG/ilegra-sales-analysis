package com.ilegra.model;

import java.math.BigDecimal;

public class SaleItem {

    private Integer id;
    private Integer quantity;
    private BigDecimal price;

    public SaleItem(Integer id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(quantity));
    }

}
