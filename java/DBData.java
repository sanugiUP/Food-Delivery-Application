package com.example.mad_assignment;

public class DBData
{
    public static void restaurantList(DeliveryAppDBModel deliverAppDBModel) {
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/4e/d6/0e/4ed60e23918225ad95d6b57a0cfe1882.jpg","Cafe Bloom", "7514 Glenridge Street Plymouth, MA 02360"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/d6/5f/a7/d65fa79aaf4f3fa50e3163c45efea478.jpg","Bubble Me", "9549 County St.Linden, NJ 07036"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/90/6c/36/906c3687c113e5662f540fe2bca1e9d5.jpg", "The Cake Shop", "8885 Indian Spring St.Villa Rica, GA 30180"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/0f/57/ad/0f57ade2fda85d0c7a7d4ad07597aa11.jpg", "Street Burger", "910 Edgewood Rd.Mahwah, NJ 07430"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/f9/32/15/f93215138eb2ee4307ea8d4d26d26dbd.jpg", "Breakfast Club", "9658 Franklin St.Massillon, OH 44646"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/0d/2b/1c/0d2b1c935049848484d6cfd2b33804f7.jpg", "Chinese Dragon", "2586 Romines Mill Road, TX75209"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/c3/ab/a9/c3aba9d71b73d882d932c93497645725.jpg", "Cupcake Corner", "54 East York Drive Columbus, GA 31904"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/c6/9d/ca/c69dca020ffea4aed69f15f12b6573c8.jpg", "Jo Pizza", "8 1st Road Piedmont, SC 29673"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/d1/21/62/d1216290062465c54c9586438551d263.jpg", "House Italian", "9827 Santa Clara St.Caldwell, NJ 07006"));
        deliverAppDBModel.addRestaurant(new Restaurant("https://i.pinimg.com/564x/41/84/d6/4184d62806cb206a2cb1026f2040d8dc.jpg", "Gelato Isle", "264 South Bowman Dr.Nashua, NH 03060"));
    }

    public static void cafeBloomMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/f8/ad/b1/f8adb1dffd0c001f8627afc9c2d043d3.jpg", "White Russian Frothy", "10.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/e2/16/d9/e216d9e3180afdd57d170ef1d99aa244.jpg", "Iced BrownSugar OatMilk Espresso", "38.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0a/3e/8c/0a3e8cbcaba42afa9ab247f80ddaf558.jpg", "Iced Americano", "15.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/3e/a5/50/3ea550607f70ea4add11cc3715507808.jpg", "Caramel Machiatto", "10.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/da/77/59/da77594e727a9c55b1e176003d184f62.jpg", "Flat White", "14.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/9d/bb/53/9dbb533a1db576f2c86740be711e2080.jpg", "Maple BrownSugar Latte", "21.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/64/06/d6/6406d6ea581d7e87f22bff8f10a92944.jpg", "Iced Mochar", "17.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/33/fc/08/33fc088294e1011cdfc3afe6564a6daa.jpg", "Cappuccino", "12.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0e/ab/a6/0eaba6e707d146f4aa63e1fb0c7ea534.jpg", "Cookie Cream Milkshake", "16.00", "CafeBloom"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/28/97/d4/2897d4662cd5f89d6f7f49b61f5849c0.jpg", "Caramel Coconut Cold Brew", "25.00", "CafeBloom"));
    }

    public static void bubbleMeMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/d5/83/77/d58377114cabf2575fbd796eb24dd339.jpg", "Ube Milk Tea", "15.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/af/ba/7a/afba7a924785276b8432967780897505.jpg", "Coconut Pea Bubble Tea", "38.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0e/86/86/0e8686ab820369e1d507117560e745e3.jpg", "Matcha Bubble Tea", "15.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/cf/c1/b0/cfc1b0d057cc455234bc755105303b93.jpg", "Mango Bubble Tea", "10.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/3b/46/a1/3b46a18bc6a0069c424b7e1461e515d5.jpg", "Lychee Bubble Tea", "14.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/1a/d3/1d/1ad31d628acc338c8ca621c169983c08.jpg", "Caramel Bubble Tea", "21.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/70/7f/1b/707f1b51d47b13825bbc667089fec9b3.jpg", "Vegan Bubble Tea", "17.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/3f/6d/39/3f6d39da3ea34d3bf20216d3debf3efc.jpg", "Strawberry Rose Bubble Tea", "12.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/05/b3/5b/05b35b46c096f6d0c1a100a23777af87.jpg", "Brown Suagr Bubble Tea", "16.00", "BubbleMe"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/24/f3/0d/24f30d0b41b64f9137d14eb2c5265fa4.jpg", "Vanilla Bubble Tea", "25.00", "BubbleMe"));
    }

    public static void streetBurgerMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0f/57/ad/0f57ade2fda85d0c7a7d4ad07597aa11.jpg", "Square-Side-Up Breakfast Burger", "10.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/31/35/cf/3135cf1fc8aa16f3858da877d912e3f4.jpg", "Nacho & Combo Salsa Dip", "38.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/59/88/08/5988088329cc5572c22b06f67d62e962.jpg", "Fries Mania Burger Meal", "15.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/44/59/b7/4459b79c67e29a51b38b89f8241156d4.jpg", "Big Burger Meal", "10.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/03/c4/b7/03c4b7d4308a145418a24d994666f4f5.jpg", "Burger Combo & Fries", "14.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/e1/ed/ad/e1edadc2b72055a11a9687c8b4c46bb5.jpg", "Double Meat Combo Burgers", "21.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/4d/5d/98/4d5d981b39836c44755b4f9414ab8de1.jpg", "Double Cheese Beef Burger", "17.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/11/14/d3/1114d39e4411d7444c75f082c56e8a63.jpg", "Crispy Chicken Burger", "12.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/da/e7/6b/dae76b56a6d388a63d4d947b9e5b80c1.jpg", "Cheese Burger", "16.00", "StreetBurger"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/b3/86/ff/b386ffadceb361a0fe0c88a99b7f7d81.jpg", "Vegetarian Burger", "25.00", "StreetBurger"));
    }

    public static void cakeShopMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/90/6c/36/906c3687c113e5662f540fe2bca1e9d5.jpg", "Christmas Cake", "35.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0a/55/fa/0a55fae904e3a72a97c3e2b7071939b3.jpg", "Blueberry Cake", "35.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/8e/12/d5/8e12d5a36fbacedce67471ba4a6f084a.jpg", "Macron & Vanilla Cake", "38.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/23/a7/f5/23a7f58ef72794f2ef9b2fb2ad227f5d.jpg", "Red Velvet Cake", "35.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/92/b6/26/92b62616ef317b0432830a4762eb13c5.jpg", "Caramel Cake", "30.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/b4/e7/87/b4e7870cde08f4021f63d58f83845ddb.jpg", "Pink Layer Cake", "24.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/b6/e1/10/b6e110d8a99f6d0e256184fadfca72ec.jpg", "Orange Cake", "28.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/c0/da/83/c0da838d95203fffc764a3842d639128.jpg", "Strawberry Cake", "27.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/e9/16/06/e91606e6809805d2e1f95b7fb09d07f5.jpg", "Oreo Cake", "22.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/7d/5b/54/7d5b543808031dbee0ef263c735f2476.jpg", "Chocolate Cake", "26.00", "TheCakeShop"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/e6/ef/49/e6ef49b97af7b85076f804945f476385.jpg", "Berry-Coconut Cheese Cake", "35.00", "TheCakeShop"));
    }

    public static void breakfastClubMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/5c/45/64/5c4564e10cea85aa2c89bc10b268418a.jpg", "Chocolate Chip Pancake", "20.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/a1/89/93/a189935abbf8e0b75f151a57f3f0f4a5.jpg", "Chocolate Greek Yogurt Pancake", "35.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/33/9e/43/339e43ac1b532d05d94a26a331a3bbe5.jpg", "Buckwheat & Berry Pancake", "38.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/d0/bd/dc/d0bddce4efb65033c4422ac3e92c1edf.jpg", "Vanilla Pancake", "35.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/4c/d0/87/4cd087f13498f5b2cb7cd93d4ba4c9a5.jpg", "Fried Chicken & Waffle", "30.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/48/2a/57/482a5709b40093d1d5ffc035a5386f5e.jpg", "Vanilla Waffle & Berries", "24.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/29/fd/a9/29fda9caa35f7990f4405be7ebe16e76.jpg", "Cheddar Cornbread Waffle", "28.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/a7/8f/46/a78f46278c18491e19a69eee64817ae9.jpg", "Dutch Egg Sandwich", "27.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/94/dd/02/94dd02d1008018ced7485f15a22c21c7.jpg", "Grilled Mozzarella Sandwich", "22.00", "BreakfastClub"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/c9/93/01/c99301f8d71468116cc10d8eada4bb5d.jpg", "Spicy Chickpea Avacado Toast", "26.00", "BreakfastClub"));
    }

    public static void chineseDragonMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/c9/df/a5/c9dfa5132a385d2c644b47cc3b119e96.jpg", "Steamed BBQ Pork Buns", "38.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/4d/b4/2e/4db42e88147110ceebe53df58746aaab.jpg", "Beef Onion Stir-fry", "35.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/93/47/0b/93470b98bbf4cc7557d19bcc8454725d.jpg", "Beef Lo Mein", "38.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/36/f9/ad/36f9adc544ed169ac5d85f57d2f47e9e.jpg", "Chinese Mushroom Dumplings", "35.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0a/68/a1/0a68a1486d6f0da6725c2d093aea7556.jpg", "Chinese Spring Rolls", "30.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/a2/74/be/a274be9a9000f6739fea71cb39c3e489.jpg", "Chinese Jelly Noodles", "24.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/34/9a/2c/349a2c6ce98adc62886cf19b497a1b63.jpg", "Chinese Fried Rice", "28.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/c7/19/30/c71930a2b6ac5604a0949c75121e5bf6.jpg", "Dan Dan Noodles", "27.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/bb/39/c8/bb39c8741654b6f02434b8ad5eb4544f.jpg", "Chinese Steamed Egg", "22.00", "ChineseDragon"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/b2/d9/ef/b2d9ef6172575e31e0ed0a50e39b4963.jpg", "Mapo Tofu", "26.00", "ChineseDragon"));
    }

    public static void cupcakeCornerMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/54/f6/a0/54f6a05bac6703f1bb2dba8d7c0fbe51.jpg", "Black Forest Cupcake", "15.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/ef/41/f0/ef41f0b5c0ac0824fd86afcc57e3ff42.jpg", "Vanilla & Berries Cupcake", "35.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/da/20/4d/da204d5c16cdd792d81e0e1e216481a9.jpg", "Strawbeery Biscuit Cupcake", "38.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/58/37/61/583761582b475e5c32544ecac7a4e7e4.jpg", "Vanilla Cupcake", "35.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/60/83/67/6083674721bb7e4f7c70a6aa1424b666.jpg", "Chocolate Chip Cupcake", "30.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/42/f6/a9/42f6a91cce4586890b7d897aa5664552.jpg", "Blueberry Cupcake", "24.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/a2/6d/33/a26d33b7f948bc5e9145c3efee5f8e7e.jpg", "Peach Bourbon Cupcake", "28.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/c4/2b/ef/c42bef9dde6050717532071b4845f202.jpg", "S'mores Cupcake", "27.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/ca/2e/24/ca2e249c27c463a8de1a2aecfcd930e1.jpg", "Nutella Cupcake", "22.00", "CupcakeCorner"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/3c/9a/50/3c9a509102a105917129c893605f69e3.jpg", "Banana Caramel Cupcake", "26.00", "CupcakeCorner"));
    }

    public static void joPizzaMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/18/cd/3b/18cd3b028f0770c47658ea748738292a.jpg", "Pesto Potato Pizza", "24.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/4d/8b/ce/4d8bce02999b38314e48ea984f015fe0.jpg", "Peperoni Pizza", "35.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/b3/89/66/b389669018aa08bff1f1658670afab7e.jpg", "French Oninon Soup Pizza", "38.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/6a/a7/23/6aa723ed51d2f8aa7a92608789fbe1c7.jpg", "Vegan Cauliflower Pizza", "35.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/ab/cd/3a/abcd3a9a83630742cd2e9dc90e81f207.jpg", "Paneer Naan Pizza", "30.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/98/b4/cd/98b4cd3a30230e3aab25617a1c1f613e.jpg", "Bruschetta Pizza", "24.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/d3/cc/a3/d3cca363c91ce3d578816cb353283880.jpg", "Berry Brownie Pizza", "28.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/ce/53/2f/ce532f42fcc5f7c8bf71e452c593c4f3.jpg", "Chocolate Chip Pizza", "27.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/9c/d0/bb/9cd0bb2ce731f734d4f0477031a5de72.jpg", "Raspberry Pizza", "22.00", "JoPizza"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/70/c9/c9/70c9c91494304a1e580494f2fe00dcb5.jpg", "Cookie Cream Pizza", "26.00", "JoPizza"));
    }

    public static void gelatoIsleMenu(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/d2/c1/9f/d2c19fa2c8852fa7d4ba69d8528ce119.jpg", "Blueberry Butter Cookie", "24.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/a8/0e/9c/a80e9c6a69b2613f9fad860150758f30.jpg", "Earl Grey Chocolate", "35.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/36/bc/48/36bc48b93c478e25123d6a71f7b8ae04.jpg", "Pistachio", "38.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/0d/2b/11/0d2b11452d4d4e4fd3fd1f7d56a95772.jpg", "Chocolate Cherry", "35.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/ba/be/e1/babee11871429cbe4b5f2c43604b7f2d.jpg", "Cappuccino", "30.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/b7/63/26/b76326f070b118efb5dad6158233297b.jpg", "Chocolate", "24.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/2c/0c/1e/2c0c1e8b1dcead413842060deb965e89.jpg", "Strawberry Chocolate Chip", "28.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/a6/83/3e/a6833edfcfc729f17287c37fa63648fd.jpg", "Coffee", "27.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/fd/28/0f/fd280fcfbb0ce974c8e23d36ffb78ae4.jpg", "Lemon", "22.00", "GelatoIsle"));
        deliverAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/10/02/a4/1002a4a1810609d41f483c17ec89d828.jpg", "Lemon Poppyseed", "26.00", "GelatoIsle"));
    }

    public static void houseItalian(DeliveryAppDBModel deliveryAppDBModel){
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/05/f8/cc/05f8cc68f2e1325661d4dc2aba21ce3b.jpg", "Tomato Spaghetti", "15.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/81/de/1e/81de1ef075619fe8b99c60bc1b622a7c.jpg", "Beef Spaghetti", "10.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/7f/dd/bd/7fddbd17378b1f60901bd2bf2b4fd609.jpg", "Spicy Italian Pesto", "22.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/6b/31/0a/6b310a4f3051e5df3b156909ba765f6d.jpg", "Zucchini Pasta", "30.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/59/84/b8/5984b88e5a0f6106dfc5ec80c8c6d228.jpg", "Italian Beef Sandwich", "18.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/39/b0/58/39b0587320e6f7f9bf3bedc1a11bb9d5.jpg", "Italian Vegetable Medley", "14.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/05/47/87/0547877bd05265e3501b7c963305b300.jpg", "Italian Spinach Ravioli", "19.50", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/8d/64/e8/8d64e8fbbb8e2bcffde5b3a7f5dbee5b.jpg", "Baked Cheese Pasta", "15.50", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/8a/25/a2/8a25a274a0e6629fa1b70c096e782fe5.jpg", "Roasted Lemon & Brown Butter Pasta", "25.00", "HouseItalian"));
        deliveryAppDBModel.addRestaurantItem(new RestaurantItem("https://i.pinimg.com/564x/8c/fe/6d/8cfe6d9c06891c1761b2821b46c38282.jpg", "Italian Braised Beef", "35.00", "HouseItalian"));
    }

    public static void specialItemList(DeliveryAppDBModel deliverAppDBModel){
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/90/6c/36/906c3687c113e5662f540fe2bca1e9d5.jpg", "Christmas Special Choco Cake", "35.00", "The Cake Shop", "Season special choco buttercream christmas cake with a nutty twist..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/0f/57/ad/0f57ade2fda85d0c7a7d4ad07597aa11.jpg", "Square-Side-Up Breakfast Burger", "10.00", "Street Burger", "Introducing first time ever, our very own square burger with spinach and hot sauce..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/f8/ad/b1/f8adb1dffd0c001f8627afc9c2d043d3.jpg", "White Russian Frothy", "10.00", "Cafe Bloom", "Introducing brand new flavour - taste of White Russian cold brew coffee..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/d5/83/77/d58377114cabf2575fbd796eb24dd339.jpg", "Ube Milk Tea", "15.00", "Bubble Me", "Making a comeback, is our beloved Ube flavoured Bubble Tea with extra punch and colour..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/5c/45/64/5c4564e10cea85aa2c89bc10b268418a.jpg", "Chocolate Chip Pancake", "20.00", "Breakfast Club", "Classic flavour of chocolate and vanilla pancake with a chocolate chippy crunch..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/c9/df/a5/c9dfa5132a385d2c644b47cc3b119e96.jpg", "Steamed BBQ Pork Buns", "38.00", "Chinese Dragon", "It's Mighty Meaty Season with steamed pork buns, wrapped in BBQ sauce..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/54/f6/a0/54f6a05bac6703f1bb2dba8d7c0fbe51.jpg", "Black Forest Cupcake", "15.00", "Cupcake Corner", "Chocolate fudge flavour combined with a twist of cherry comes the black forest"));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/18/cd/3b/18cd3b028f0770c47658ea748738292a.jpg", "Pesto Potato Pizza", "24.00", "JoPizza", "Intorducing brand new potato flavoured pesto with a hint of lime and spinash"));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/d2/c1/9f/d2c19fa2c8852fa7d4ba69d8528ce119.jpg", "Blueberry Butter Cookie", "24.00", "Gelato Isle", "Butter Cream Cookie mixed with rich blueberry sauce and chocolate chips..."));
        deliverAppDBModel.addSpecialItem(new SpecialMenuItem("https://i.pinimg.com/564x/05/f8/cc/05f8cc68f2e1325661d4dc2aba21ce3b.jpg", "Tomato Spaghetti", "15.00", "House Italian", "Currently the most demanded classic tomato flavoured spaghetti with a hint of basil, olive oil and black olives..."));
    }
}
