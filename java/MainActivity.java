package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadDataToDB(); //Initialize database with values for when running the application for the first time
        clearSummary();
        FragmentManager frag = getSupportFragmentManager();
        SpecialMenuItemFragment special_menu_item_Fragment = (SpecialMenuItemFragment) frag.findFragmentById(R.id.fragment_container);
        if(special_menu_item_Fragment == null)
        {
            special_menu_item_Fragment = new SpecialMenuItemFragment();
            frag.beginTransaction().add(R.id.fragment_container, special_menu_item_Fragment).commit();
        }
    }

    private void loadDataToDB()
    {
        DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
        deliverAppDBModel.load(getApplicationContext());

        //Load Data in to AppDBModel
        ArrayList<Restaurant> restaurants = deliverAppDBModel.getAllRestaurants();
        if(restaurants.isEmpty()){
            DBData.restaurantList(deliverAppDBModel);
            DBData.cakeShopMenu(deliverAppDBModel);
            DBData.streetBurgerMenu(deliverAppDBModel);
            DBData.joPizzaMenu(deliverAppDBModel);
            DBData.breakfastClubMenu(deliverAppDBModel);
            DBData.bubbleMeMenu(deliverAppDBModel);
            DBData.cafeBloomMenu(deliverAppDBModel);
            DBData.bubbleMeMenu(deliverAppDBModel);
            DBData.gelatoIsleMenu(deliverAppDBModel);
            DBData.cupcakeCornerMenu(deliverAppDBModel);
            DBData.chineseDragonMenu(deliverAppDBModel);
            DBData.specialItemList(deliverAppDBModel);
            DBData.houseItalian(deliverAppDBModel);
        }
    }

    private void clearSummary(){
        DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
        deliverAppDBModel.load(getApplicationContext());
        deliverAppDBModel.deleteAllSummary();
    }
}

