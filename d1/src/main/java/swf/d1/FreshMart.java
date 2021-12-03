package swf.d1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class FreshMart {

    private ArrayList<String> cart;

    public FreshMart() {
        cart = new ArrayList<String>();
    }

    public boolean addToCart(String item) {
        boolean addedToCart = false;

        return addedToCart;
    }

    private String greeting() {
        String greeting = "Welcome to your shopping cart!\n\n";

        greeting += "1. List | List the contents of your cart.\n";
        greeting += "2. Add <item1>, <item2> | Add item(s) to your cart.\n";
        greeting += "3. Delete <index> | Remove an item from your cart.\n";
        greeting += "4. Help | Show this menu.\n";
        greeting += "5. Exit | Exit this program.\n\n";

        return greeting;
    }

    private String goodbye() {
        String goodbye = "See you again!\n\n";
        return goodbye;
    }

    public String listCart() {
        String contents = "";

        if (cart.size() > 0) {
            contents += "These items are currently in your cart.\n\n";
            for (int i = 0; i < cart.size(); i++) {
                contents += (i + ". " + cart.get(i) + "\n");
            }
        } else {
            contents += "Your cart is empty.\n";
        }
        return contents;
    }

    public void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {

        boolean martIsOpen = true;

        FreshMart fm = new FreshMart();

        String input, command;
        Console cons = System.console();

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
                    fm.print("");
                    break;
                case "delete":
                    fm.print("Command accepted.");
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
        }
    }
}