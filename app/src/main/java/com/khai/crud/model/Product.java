package com.khai.crud.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @SerializedName("id")
    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private Double price;

}
