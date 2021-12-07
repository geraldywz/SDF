package swf.d3;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FreshMart {

    ShoppingCart cart;

    public FreshMart() {
        cart = new ShoppingCart();
    }

    public void goodbye() {
        String goodbye = "See you again!\n\n";
        print(goodbye);
    }

    public void greeting() {
        String greeting = "Welcome to Fresh Mart!\n\n";

        greeting += "\t\t-= Users =-\n";
        greeting += "Login <Name>\t\t| Log in to your cart.\n";
        greeting += "Save \t\t\t| Save your cart.\n";
        greeting += "Users \t\t\t| List all users.\n";
        greeting += "\n\t\t-= Shopping Cart =-\n";
        greeting += "Add <item1>, <item2> \t| Add item(s) to your cart.\n";
        greeting += "Delete <index> \t\t| Remove an item from your cart.\n";
        greeting += "List \t\t\t| List the contents of your cart.\n";
        greeting += "\n\t\t-= Interface =-\n";
        greeting += "Help \t\t\t| Show this menu.\n";
        greeting += "Exit \t\t\t| Exit this program.\n\n";

        print(greeting);
    }

    public void invalidCommand(String wrongCommand) {
        String errorMsg = "\n"+ wrongCommand + " is not a valid command.\n";
        errorMsg += "Use the [help] command to see a list of valid commands.\n";

        print(errorMsg);
    }

    public void listCart() {
        String contents = "";

        if (cart.size() > 0) {
            contents += "\nThese items are currently in your cart:\n\n";
            for (int i = 0; i < cart.size(); i++) {
                contents += ((i + 1) + ". " + cart.get(i) + "\n");
            }
        } else {
            contents += "Your cart is empty.\n";
        }
        print(contents);
    }

    private void print(String text) {
        System.out.println(text);
    }

    public void processPurchase(Scanner sc) {
        sc.useDelimiter(Pattern.compile("[\\p{Punct}*]"));
        while (sc.hasNext()) {
            String newItem = sc.next().trim().toLowerCase();
            if (cart.addToCart(newItem)) {
                print(newItem + " has been added to your cart.\n");
            } else {
                print(newItem + " already exists in cart.\n");
            }
        }
    }

    public void processRemoval(Scanner sc) {
        if (sc.hasNextInt()) {
            int index = sc.nextInt();
            String removed = cart.removeFromCart(index);
            if (removed != null) {
                print(removed + " has been removed.\n");
            } else {
                print("PLease key in a valid index.");
                print("Use the [list] command to see a list of current indices.\n");
            }
        } else {
            print("Please key in the index of the item to remove after [delete].");
            print("Use the [list] command to see a list of current indices.\n");
        }
    }

    public static void main(String[] args) {

        boolean martIsOpen = true;

        String input, command;
        Console cons = System.console();
        FreshMart fm = new FreshMart();

        fm.greeting();

        while (martIsOpen) {
            input = cons.readLine();
            Scanner sc = new Scanner(input);
            command = sc.next().toLowerCase();

            switch (command) {
                case "login":

                    break;
                case "list":
                    fm.listCart();
                    break;
                case "add":
                    fm.processPurchase(sc);
                    break;
                case "delete":
                    fm.processRemoval(sc);
                    break;
                case "help":
                    fm.greeting();
                    break;
                case "exit":
                    fm.goodbye();
                    martIsOpen = false;
                    break;
                default:
                    fm.invalidCommand(command);
            }
            sc.close();
        }
    }
}