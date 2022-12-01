package com.example.mad_assignment;

public class SpecialMenuItem {
    private final String img_link;
    private final String foodItemName;
    private final String foodItemPrice;
    private final String restaurant_Name;
    private final String description;

    public SpecialMenuItem(String img_link, String foodItemName, String foodItemPrice, String restaurant_Name, String description)
    {
        this.img_link = img_link;
        this.foodItemName = foodItemName;
        this.foodItemPrice = foodItemPrice;
        this.restaurant_Name = restaurant_Name;
        this.description = description;
    }

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

    public String getDescription(){ return description; }
}
