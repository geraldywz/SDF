package sdf.d3;

import java.util.ArrayList;
import java.util.Collections;

public class ShoppingCart {

    private String userName;
    private ArrayList<String> cart;

    public ShoppingCart() {
        cart = new ArrayList<String>();
        userName = null;
    }

    public ShoppingCart(String userName) {
        cart = new ArrayList<String>();
        this.userName = userName;
    }

    public boolean addToCart(String item) {
        boolean noDupesFound = true;

        noDupesFound = cart.contains(item) ? false : true;

        if (noDupesFound) {
            cart.add(item);
            Collections.sort(cart);
        }

        return noDupesFound;
    }

    public int size() {
        return cart.size();
    }

    public String get(int index) {
        return cart.get(index);
    }

    public String getUsername() {
        return userName;
    }

    public String removeFromCart(int index) {
        String removed = null;
        if (index <= size() && index > 0) {
            index--;
            removed = cart.get(index);
            cart.remove(index);
        }
        return removed;
    }

    public void setUsername(String name) {
        this.userName = name;
    }

    public static void main(String[] args) {

    }
}