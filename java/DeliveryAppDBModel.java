package com.example.mad_assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.mad_assignment.DeliveryAppDBSchema.RestaurantItemList;
import com.example.mad_assignment.DeliveryAppDBSchema.SpecialItemList;
import com.example.mad_assignment.DeliveryAppDBSchema.RestaurantList;
import com.example.mad_assignment.DeliveryAppDBSchema.CustomerList;
import com.example.mad_assignment.DeliveryAppDBSchema.CustomerOrder;
import com.example.mad_assignment.DeliveryAppDBSchema.OrderSummary;


import java.util.ArrayList;

public class DeliveryAppDBModel {

    ArrayList<Restaurant> restaurantList = new ArrayList<>();
    ArrayList<SpecialMenuItem> itemsList = new ArrayList<>();
    SQLiteDatabase db;
    Context context;

    public void load(Context context){
        this.db = new DeliveryAppDBHelper(context).getWritableDatabase();
        this.context = context;
    }

    public void addRestaurantItem(RestaurantItem restaurantItem) {
        ContentValues cv = new ContentValues();
        cv.put(RestaurantItemList.Cols.LINK, restaurantItem.getImageLink());
        cv.put(RestaurantItemList.Cols.NAME, restaurantItem.getFoodItemName());
        cv.put(RestaurantItemList.Cols.PRICE, restaurantItem.getFoodItemPrice());
        cv.put(RestaurantItemList.Cols.R_NAME, restaurantItem.getRestaurantName());
        db.insert(RestaurantItemList.NAME, null, cv);
    }

    public void addSpecialItem(SpecialMenuItem specialMenuItem) {
        ContentValues cv = new ContentValues();
        cv.put(SpecialItemList.Cols.LINK, specialMenuItem.getImageLink());
        cv.put(SpecialItemList.Cols.NAME, specialMenuItem.getFoodItemName());
        cv.put(SpecialItemList.Cols.PRICE, specialMenuItem.getFoodItemPrice());
        cv.put(SpecialItemList.Cols.R_NAME, specialMenuItem.getRestaurantName());
        cv.put(SpecialItemList.Cols.DESCRIPTION, specialMenuItem.getDescription());
        db.insert(SpecialItemList.NAME, null, cv);
    }

    public void addRestaurant(Restaurant restaurant) {
        ContentValues cv = new ContentValues();
        cv.put(RestaurantList.Cols.LINK, restaurant.getImageLink());
        cv.put(RestaurantList.Cols.NAME, restaurant.getLabel());
        cv.put(RestaurantList.Cols.LOCATION, restaurant.getLocation());
        db.insert(RestaurantList.NAME,null, cv);
    }

    public void addCustomer(Customer customer) {
        ContentValues cv = new ContentValues();
        cv.put(CustomerList.Cols.NAME, customer.getCustomerName());
        cv.put(CustomerList.Cols.EMAIL, customer.getCustomerEmail());
        cv.put(CustomerList.Cols.PASSWORD, customer.getCustomerPassword());
        db.insert(CustomerList.NAME, null, cv);
    }

    public void addCustomerOrder(Order order) {
        ContentValues cv = new ContentValues();
        cv.put(CustomerOrder.Cols.NAME, order.getCus_Name());
        cv.put(CustomerOrder.Cols.TIME, order.getTime());
        cv.put(CustomerOrder.Cols.FOODITEM, order.getFoodItem());
        cv.put(CustomerOrder.Cols.RESTAURANTNAME, order.getRestaurantName());
        cv.put(CustomerOrder.Cols.PRICE, order.getPrice());
        cv.put(CustomerOrder.Cols.QUANTITY, order.getQuantity());
        db.insert(CustomerOrder.NAME, null, cv);
    }

    public void addSummary(SummaryStruct summary) {
        ContentValues cv = new ContentValues();
        cv.put(OrderSummary.Cols.RESNAME, summary.getRestaurantName());
        cv.put(OrderSummary.Cols.ITEMNAME,summary.getFoodItemName());
        cv.put(OrderSummary.Cols.QUANTITY,summary.getFoodItemQuantity());
        cv.put(OrderSummary.Cols.PRICE,summary.getFoodItemPrice());
        db.insert(OrderSummary.NAME,null, cv);
    }

    public ArrayList<SummaryStruct> getAllSummaryItems() {
        ArrayList<SummaryStruct> summaryList = new ArrayList<>();
        Cursor cursor = db.query(OrderSummary.NAME,null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try{
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()){
                summaryList.add(deliveryAppDBCursor.getSummary());
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return summaryList;
    }

    public ArrayList<RestaurantItem> getAllRestaurantItems(String rest_Name) {
        ArrayList<RestaurantItem> restaurantItems = new ArrayList<>();
        String name = rest_Name.replaceAll("\\s", "");
        Cursor cursor = db.query(RestaurantItemList.NAME + " WHERE " + RestaurantItemList.Cols.R_NAME + "='" + name + "'" + ";",null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try {
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()) {
                restaurantItems.add(deliveryAppDBCursor.getRestaurantItem());
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return restaurantItems;
    }

    public ArrayList<Restaurant> getAllRestaurants() {
        Cursor cursor = db.query(RestaurantList.NAME,null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try{
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()){
                restaurantList.add(deliveryAppDBCursor.getRestaurant());
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return restaurantList;
    }
    
    public Restaurant getRestaurant(String link) {
        Restaurant restaurant = null;
        ArrayList<Restaurant> restaurantlist = new ArrayList<>();
        Cursor cursor = db.query(RestaurantList.NAME,null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try{
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()){
                restaurantlist.add(deliveryAppDBCursor.getRestaurant());
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        for (Restaurant r:restaurantlist) {
            if(r.getImageLink().equals(link)){
                restaurant = r;
            }
        }
        return restaurant;
    }

    public ArrayList<SpecialMenuItem> getAllSpecialItems() {
        Cursor cursor = db.query(SpecialItemList.NAME,null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try{
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()){
                itemsList.add(deliveryAppDBCursor.getSpecialItem());
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return itemsList;
    }

    public ArrayList<Order> getOrderHistory(String username) {
        ArrayList<Order> orders = new ArrayList<>();
        Cursor cursor = db.query(CustomerOrder.NAME + " WHERE " + CustomerOrder.Cols.NAME + "='" + username + "'" + ";",null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try {
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()) {
                orders.add(deliveryAppDBCursor.getOrder());
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return orders;
    }

    public boolean validateCustomerLogInDetails(String name, String password) {
        boolean isValid = false; //Initially Invalid
        Cursor cursor = db.query(CustomerList.NAME,null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try{
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()){
                if(deliveryAppDBCursor.getCustomer().getCustomerName().equals(name) && deliveryAppDBCursor.getCustomer().getCustomerPassword().equals(password)){
                    isValid = true;
                }
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return isValid;
    }

    public void deleteSummary(SummaryStruct summaryItem) {
        /* REF : https://stackoverflow.com/questions/7510219/deleting-row-in-sqlite-in-android */
       String[] whereVale = {(summaryItem.getFoodItemName())};
       db.delete(OrderSummary.NAME, OrderSummary.Cols.ITEMNAME + "=? ", whereVale);
    }

    public void deleteAllSummary(){
        Cursor cursor = db.query(OrderSummary.NAME,null,null,null,null,null,null);
        DeliveryAppDBCursor deliveryAppDBCursor = new DeliveryAppDBCursor(cursor);

        try{
            deliveryAppDBCursor.moveToFirst();
            while(!deliveryAppDBCursor.isAfterLast()){
                String[] whereVale = {(deliveryAppDBCursor.getSummary().getFoodItemName())};
                db.delete(OrderSummary.NAME, OrderSummary.Cols.ITEMNAME + "=? ", whereVale);
                deliveryAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
    }
}