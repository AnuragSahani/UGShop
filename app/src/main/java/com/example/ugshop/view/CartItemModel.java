package com.example.ugshop.view;

public class CartItemModel {
    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ////////Cart Item
    private int product_image;
    private String product_title;
    private int free_coupons;
    private String product_price;
    private String cutted_price;
    private int product_quantity;
    private int offers_applied;
    private int coupons_applied;


    //Constructor
    public CartItemModel(int type, int product_image,
                         String product_title, int free_coupons, String product_price, String cutted_price,
                         int product_quantity, int offers_applied, int coupons_applied) {
        this.type = type;
        this.product_image = product_image;
        this.product_title = product_title;
        this.free_coupons = free_coupons;
        this.product_price = product_price;
        this.cutted_price = cutted_price;
        this.product_quantity = product_quantity;
        this.offers_applied = offers_applied;
        this.coupons_applied = coupons_applied;
    }


    //Getter Setter
    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public int getFree_coupons() {
        return free_coupons;
    }

    public void setFree_coupons(int free_coupons) {
        this.free_coupons = free_coupons;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getCutted_price() {
        return cutted_price;
    }

    public void setCutted_price(String cutted_price) {
        this.cutted_price = cutted_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public int getOffers_applied() {
        return offers_applied;
    }

    public void setOffers_applied(int offers_applied) {
        this.offers_applied = offers_applied;
    }

    public int getCoupons_applied() {
        return coupons_applied;
    }

    public void setCoupons_applied(int coupons_applied) {
        this.coupons_applied = coupons_applied;
    }
    ////////Cart Item


    ///////Cart total
    private int Total_items;
    private String Total_Amount;
    private String Delivery_price;
    private String Saved_Amount;

    // Constructor
    public CartItemModel(int type, int total_items, String total_Amount, String delivery_price, String saved_Amount) {
        this.type = type;
        Total_items = total_items;
        Total_Amount = total_Amount;
        Delivery_price = delivery_price;
        Saved_Amount = saved_Amount;
    }

    // getter and setter
    public int getTotal_items() {
        return Total_items;
    }

    public void setTotal_items(int total_items) {
        Total_items = total_items;
    }

    public String getTotal_Amount() {
        return Total_Amount;
    }

    public void setTotal_Amount(String total_Amount) {
        Total_Amount = total_Amount;
    }

    public String getDelivery_price() {
        return Delivery_price;
    }

    public void setDelivery_price(String delivery_price) {
        Delivery_price = delivery_price;
    }

    public String getSaved_Amount() {
        return Saved_Amount;
    }

    public void setSaved_Amount(String saved_Amount) {
        Saved_Amount = saved_Amount;
    }
    ///////Cart total


}
