package com.example.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static List<Item_model> cartItems = new ArrayList<>();

    public static void addToCart(Item_model item) {
        cartItems.add(item);
    }

    public static List<Item_model> getCartItems() {
        return cartItems;
    }

    // Update the removeFromCart method to accept an Item_model
    public static void removeFromCart(Item_model item) {
        cartItems.remove(item);
    }
}