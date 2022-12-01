package com.example.mad_assignment;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.mad_assignment.DeliveryAppDBSchema.RestaurantItemList;
import com.example.mad_assignment.DeliveryAppDBSchema.SpecialItemList;
import com.example.mad_assignment.DeliveryAppDBSchema.RestaurantList;
import com.example.mad_assignment.DeliveryAppDBSchema.CustomerList;
import com.example.mad_assignment.DeliveryAppDBSchema.CustomerOrder;
import com.example.mad_assignment.DeliveryAppDBSchema.OrderSummary;

public class DeliveryAppDBCursor extends CursorWrapper {

    public DeliveryAppDBCursor(Cursor cursor) { super(cursor); }

    public Restaurant getRestaurant(){
        String img_link = getString(getColumnIndex(RestaurantList.Cols.LINK));
        String name = getString(getColumnIndex(RestaurantList.Cols.NAME));
        String location = getString(getColumnIndex(RestaurantList.Cols.LOCATION));
        return new Restaurant(img_link, name, location);
    }

    public RestaurantItem getRestaurantItem(){
        String img_link = getString(getColumnIndex(RestaurantItemList.Cols.LINK));
        String name = getString(getColumnIndex(RestaurantItemList.Cols.NAME));
        String price = getString(getColumnIndex(RestaurantItemList.Cols.PRICE));
        String r_Name = getString(getColumnIndex(RestaurantItemList.Cols.R_NAME));
        return new RestaurantItem(img_link, name, price, r_Name);
    }

    public SpecialMenuItem getSpecialItem(){
        String img_link = getString(getColumnIndex(SpecialItemList.Cols.LINK));
        String name = getString(getColumnIndex(SpecialItemList.Cols.NAME));
        String price = getString(getColumnIndex(SpecialItemList.Cols.PRICE));
        String r_Name = getString(getColumnIndex(SpecialItemList.Cols.R_NAME));
        String description = getString(getColumnIndex(SpecialItemList.Cols.DESCRIPTION));
        return new SpecialMenuItem(img_link, name, price, r_Name, description);
    }

    public Customer getCustomer(){
        String name = getString(getColumnIndex(CustomerList.Cols.NAME));
        String email = getString(getColumnIndex(CustomerList.Cols.EMAIL));
        String password = getString(getColumnIndex(CustomerList.Cols.PASSWORD));
        return new Customer(name, email, password);
    }

    public Order getOrder(){
        String name = getString(getColumnIndex(CustomerOrder.Cols.NAME));
        String time = getString(getColumnIndex(CustomerOrder.Cols.TIME));
        String item = getString(getColumnIndex(CustomerOrder.Cols.FOODITEM));
        String quantity = getString(getColumnIndex(CustomerOrder.Cols.QUANTITY));
        String restaurant = getString(getColumnIndex(CustomerOrder.Cols.RESTAURANTNAME));
        String price = getString(getColumnIndex(CustomerOrder.Cols.PRICE));
        return new Order(name, time, item, price, quantity, restaurant);
    }

    public SummaryStruct getSummary() {
        String resName = getString(getColumnIndex(OrderSummary.Cols.RESNAME));
        String name = getString(getColumnIndex(OrderSummary.Cols.ITEMNAME));
        String price = getString(getColumnIndex(OrderSummary.Cols.PRICE));
        String quantity = getString(getColumnIndex(OrderSummary.Cols.QUANTITY));
        return new SummaryStruct(name,price,quantity,resName);
    }
}