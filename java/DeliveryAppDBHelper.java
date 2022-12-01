package com.example.mad_assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mad_assignment.DeliveryAppDBSchema.SpecialItemList;
import com.example.mad_assignment.DeliveryAppDBSchema.RestaurantItemList;
import com.example.mad_assignment.DeliveryAppDBSchema.RestaurantList;
import com.example.mad_assignment.DeliveryAppDBSchema.CustomerList;
import com.example.mad_assignment.DeliveryAppDBSchema.CustomerOrder;
import com.example.mad_assignment.DeliveryAppDBSchema.OrderSummary;
import com.example.mad_assignment.DeliveryAppDBSchema.Users;

public class DeliveryAppDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "deliveryApp.db";

    public DeliveryAppDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + RestaurantList.NAME + "(" + RestaurantList.Cols.LINK + " Text, " + RestaurantList.Cols.NAME + " Text, " + RestaurantList.Cols.LOCATION + " Text " + ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + RestaurantItemList.NAME + "(" + RestaurantItemList.Cols.LINK + " Text, " + RestaurantItemList.Cols.NAME + " Text, " + RestaurantItemList.Cols.PRICE + " Text, " + RestaurantItemList.Cols.R_NAME + " Text " + ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + SpecialItemList.NAME + "(" + SpecialItemList.Cols.LINK + " Text, " + SpecialItemList.Cols.NAME + " Text, " + SpecialItemList.Cols.PRICE + " Text, " + SpecialItemList.Cols.R_NAME + " Text, " + SpecialItemList.Cols.DESCRIPTION + " Text " + ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + CustomerList.NAME + "(" + CustomerList.Cols.NAME + " Text, " + CustomerList.Cols.EMAIL + " Text, " + CustomerList.Cols.PASSWORD + " Text " + ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + CustomerOrder.NAME + "(" + CustomerOrder.Cols.NAME + " Text, " + CustomerOrder.Cols.QUANTITY + " Text, " + CustomerOrder.Cols.TIME + " Text, " + CustomerOrder.Cols.FOODITEM + " Text, " + CustomerOrder.Cols.RESTAURANTNAME + " Text, " + CustomerOrder.Cols.PRICE + " Real " + ");");
        sqLiteDatabase.execSQL("CREATE TABLE " + OrderSummary.NAME+"(" + OrderSummary.Cols.ITEMNAME + " Text, " + OrderSummary.Cols.RESNAME + " Text, " + OrderSummary.Cols.QUANTITY + " Text, " + OrderSummary.Cols.PRICE+ " Text "+" );");
        sqLiteDatabase.execSQL("CREATE TABLE " + Users.NAME+ "("+Users.Cols.Username + "Text," + Users.Cols.Password+"Text"+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + RestaurantList.NAME + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + RestaurantItemList.NAME + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + SpecialItemList.NAME + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + CustomerList.NAME + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + CustomerOrder.NAME + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + OrderSummary.NAME + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + Users.NAME + "'");

        onCreate(sqLiteDatabase);
    }

    /*public Boolean insertDataCustomer(String username,String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDB.insert("users",null,contentValues);
        if(result == -1)
        {
            return false;
        }else
        {
            return true;
        }

    }

    public Boolean checkUsernameandPassword(String username,String password)
    {
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("Select * from users where username =? and password = ?",new String[]{username,password});
        if(cursor.getCount()> 0)
        {
            return true;
        }else
        {
            return false;
        }
    }*/


}