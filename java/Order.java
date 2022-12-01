package com.example.mad_assignment;

public class Order {
    private String cus_Name;
    private String time;
    private String foodItem;
    private String price;
    private String quantity;
    private String restaurantName;

    public Order(String cus_Name, String time, String foodItem, String price, String quantity, String restaurantName) {
        this.cus_Name = cus_Name;
        this.time = time;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.restaurantName = restaurantName;
        this.price = price;
    }

    public String getCus_Name() {
        return cus_Name;
    }

    public String getTime() {
        return time;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public String getQuantity() {return quantity; }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getPrice() {
        return price;
    }
}
