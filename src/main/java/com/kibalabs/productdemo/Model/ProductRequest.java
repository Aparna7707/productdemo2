package com.kibalabs.productdemo.Model;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


public class ProductRequest {
    @Column(name = "name",unique = true)
    @NotBlank
    private String name;
    @Positive
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductRequest(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ProductRequest() {

    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
