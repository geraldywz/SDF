package swf.d3;

import java.util.ArrayList;

public class ShoppingCart {

    private String userName;
    private ArrayList<String> cart;

    public ShoppingCart() {
        cart = new ArrayList<String>();
    }

    public ShoppingCart(String userName) {
        cart = new ArrayList<String>();
        this.userName = userName;
    }

    public boolean addToCart(String item) {

        boolean addedToCart = true;

        for (int i = 0; i < size(); i++) {
            if (cart.get(i).equals(item)) {
                addedToCart = false;
                break;
            }
        }
        if (addedToCart) {
            cart.add(item);
        }
        return addedToCart;
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

    public void populateSampleData() {
        addToCart("apple");
        addToCart("orange");
        addToCart("banana");
        addToCart("pear");
        addToCart("kiwi");
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