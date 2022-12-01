package com.example.mad_assignment;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAppDBSchema {

    public static class RestaurantList {
        public static final String NAME = "RestaurantList";
        public static class Cols {
            public static final String LINK = "RestaurantImageDId";
            public static final String NAME = "RestaurantName";
            public static final String LOCATION = "RestaurantLocation";
        }
    }

    public static class RestaurantItemList {
        public static final String NAME = "RestaurantItemList";
        public static class Cols {
            public static final String LINK = "RestaurantItemImageDId";
            public static final String NAME = "ItemName";
            public static final String PRICE = "ItemPrice";
            public static final String R_NAME = "RestaurantName";
        }
    }

    public static class SpecialItemList {
        public static final String NAME = "SpecialItemList";
        public static class Cols {
            public static final String LINK = "RestaurantItemImageDId";
            public static final String NAME = "ItemName";
            public static final String PRICE = "ItemPrice";
            public static final String R_NAME = "RestaurantName";
            public static final String DESCRIPTION = "ItemDescription";
        }
    }

    public static class CustomerList {
        public static final String NAME = "CustomerList";
        public static class Cols {
            public static final String NAME = "CustomerName";
            public static final String EMAIL = "CustomerEmail";
            public static final String PASSWORD = "CustomerPassword";
        }
    }

    public static class CustomerOrder {
        public static final String NAME = "OrderList";
        public static class Cols {
            public static final String NAME = "CustomerName";
            public static final String TIME = "OrderTime";
            public static final String RESTAURANTNAME = "RestaurantName";
            public static final String QUANTITY ="Quantity";
            public static final String FOODITEM = "FoodItem";
            public static final String PRICE = "ItemPrice";
        }
    }

    public static class OrderSummary{
        public static final String NAME = "OrderSummary";
        public static final class Cols{
            public static final String RESNAME = "RestaurantName";
            public static final String ITEMNAME ="ItemName";
            public static final String QUANTITY ="Quantity";
            public static final String PRICE = "ItemPrice";

        }
    }

    public static class Users{
        public static final String NAME = "Users";
        public static final class Cols{
            public static final String Username ="Username";
            public static final String Password ="Password";


        }
    }
}