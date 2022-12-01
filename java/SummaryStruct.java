package com.example.mad_assignment;

public class SummaryStruct
{
    private final String foodItemName;
    private final String foodItemPrice;
    private final String foodItemCount;
    private final String reName;

    public SummaryStruct(String foodItemName, String foodItemPrice, String foodItemCount, String resName)
    {
        this.reName = resName;
        this.foodItemName = foodItemName;
        this.foodItemPrice = foodItemPrice;
        this.foodItemCount = foodItemCount;
    }

    public String getRestaurantName() { return reName; }

    public String getFoodItemName(){ return foodItemName; }

    public String getFoodItemPrice() { return foodItemPrice; }

    public String getFoodItemQuantity() { return foodItemCount; }

}
