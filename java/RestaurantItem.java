package com.example.mad_assignment;


public class RestaurantItem {
    private final String img_link;
    private final String foodItemName;
    private final String foodItemPrice;
    private final String restaurant_Name;

    public RestaurantItem(String img_link, String foodItemName, String foodItemPrice, String restaurant_Name)
    {
        this.img_link = img_link;
        this.foodItemName = foodItemName;
        this.foodItemPrice = foodItemPrice;
        this.restaurant_Name = restaurant_Name;
    }

    //public int getQuantity(){return quantity;}

    public String getFoodItemName(){return foodItemName;}

    public String getImageLink()
    {
        return img_link;
    }

    public String getFoodItemPrice()
    {
        return foodItemPrice;
    }

    public String getRestaurantName() { return  restaurant_Name; }

    //public void setQuantity(int quantity){ this.quantity = quantity; }
}
