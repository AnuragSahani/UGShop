package com.example.ugshop.model.common;

public class ProductModel {
    /*{
        "productId": 1,
            "subCatId": 1,
            "name": "T_shirt_1",
            "price": 1299,
            "description": "ETC ETC",
            "quantity": 10,
            "catId": 1
    }*/
    private int productId;
    private int subCatId;
    private String name;
    private int price;
    private String description;
    private int quantity;
    private int catId;

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId=" + productId +
                ", subCatId=" + subCatId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", catId=" + catId +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
