package swf.d1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FreshMart {

    private ArrayList<String> cart;

    public FreshMart() {
        cart = new ArrayList<String>();
    }

    public boolean addToCart(String item) {

        boolean addedToCart = true;

        for (int i = 0; i < cartSize(); i++) {
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

    public int cartSize() {
        return cart.size();
    }

    public String greeting() {
        String greeting = "Welcome to Fresh Mart!\n\n";

        greeting += "List \t\t\t| List the contents of your cart.\n";
        greeting += "Add <item1>, <item2> \t| Add item(s) to your cart.\n";
        greeting += "Delete <index> \t\t| Remove an item from your cart.\n";
        greeting += "Help \t\t\t| Show this menu.\n";
        greeting += "Exit \t\t\t| Exit this program.\n\n";

        return greeting;
    }

    public String goodbye() {
        String goodbye = "See you again!\n\n";
        return goodbye;
    }

    public String listCart() {
        String contents = "";

        if (cartSize() > 0) {
            contents += "\nThese items are currently in your cart:\n\n";
            for (int i = 0; i < cartSize(); i++) {
                contents += ((i + 1) + ". " + cart.get(i) + "\n");
            }
        } else {
            contents += "Your cart is empty.\n";
        }
        return contents;
    }

    public void print(String text) {
        System.out.println(text);
    }

    public boolean removeFromCart(int index) {
        boolean removed = false;
        if (index <= cartSize() && index > 0) {
            removed = true;
            index--;
            cart.remove(index);
        }
        return removed;
    }

    public static void main(String[] args) {

        boolean martIsOpen = true;

        String input, command;
        Console cons = System.console();
        FreshMart fm = new FreshMart();
        fm.addToCart("Apple");
        fm.addToCart("Orange");
        fm.addToCart("Banana");
        fm.addToCart("Pear");
        fm.addToCart("Kiwi");

        fm.print(fm.greeting());

        while (martIsOpen) {
            input = cons.readLine();
            Scanner sc = new Scanner(input);
            command = sc.next().toLowerCase();

            switch (command) {
                case "list":
                    fm.print(fm.listCart());
                    break;
                case "add":
                    sc.useDelimiter(Pattern.compile("[\\p{Punct}*]"));
                    while (sc.hasNext()) {
                        String newItem = sc.next().trim().toLowerCase();
                        if (fm.addToCart(newItem)) {
                            fm.print(newItem + " has been added to your cart.");
                        } else {
                            fm.print(newItem + " already exists in cart.");
                        }
                    }
                    break;
                case "delete":
                    if (sc.hasNextInt()) {
                        int index = sc.nextInt();
                        if (fm.removeFromCart(index)) {
                            fm.print("Item has been removed.");
                        } else {
                            fm.print("Index is out of bounds, please key in a valid index.");
                            fm.print("Use the [list] command to see a list of current indices.");
                        }
                    } else {
                        fm.print("Please key in the index of the item to remove after [delete].");
                        fm.print("Use the [list] command to see a list of current indices.");
                    }
                    break;
                case "help":
                    fm.print(fm.greeting());
                    break;
                case "exit":
                    fm.print(fm.goodbye());
                    martIsOpen = false;
                    break;
                default:
                    fm.print(command + " is not a valid command.");
            }
            sc.close();
        }
    }
}