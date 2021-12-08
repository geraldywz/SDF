package swf.d3;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.Scanner;

public class FreshMart {

    ShoppingCart cart;
    ShoppingCartDB cartDB;

    public FreshMart() {
        cart = new ShoppingCart();
        cartDB = new ShoppingCartDB();
    }

    private String generateRandomString(int stringLength) {
        int leftLimit = 97;     // letter 'a'
        int rightLimit = 122;   // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public void goodbye() {
        String goodbye = "See you again!\n\n";
        print(goodbye);
    }

    public void greeting() {
        print("Welcome to Fresh Mart!\n");

        print("\t-= Users =-");
        print("Login <Name>\t\t| Log in to your cart.");
        print("Save \t\t\t| Save your cart.");
        print("Users \t\t\t| List all users.");
        print("\n\t-= Shopping Cart =-");
        print("Add <item1>, <item2> \t| Add item(s) to your cart.");
        print("Delete <index> \t\t| Remove an item from your cart.");
        print("List \t\t\t| List the contents of your cart.");
        print("\n\t-= Interface =-");
        print("Help \t\t\t| Show this menu.");
        print("Exit \t\t\t| Exit this program.\n");
    }

    public void invalidCommand(String wrongCommand) {
        print("\n" + wrongCommand + " is not a valid command.\n");
        print("Use the [help] command to see a list of valid commands.\n");
    }

    public void listCart() {
        if (cart.getUsername() != null) {
            print("\nHi " + cart.getUsername() + "!\n");
        }
        if (cart.size() > 0) {
            print("These items are currently in your cart:");
            for (int i = 0; i < cart.size(); i++) {
                print((i + 1) + ". " + cart.get(i));
            }
        } else {
            print("Your cart is empty.\n");
        }
    }

    public void listUsers() {
        ArrayList<String> userList = cartDB.getUsers();
        if (userList.size() > 0) {
            print("\nThe following users are registered:\n");
            for (int i = 0; i < userList.size(); i++) {
                print(((i + 1) + ". " + userList.get(i) + ""));
            }
        } else {
            print("Be the first user to register!\n");
        }
    }

    public void login(Scanner sc) {
        boolean notFound = true;
        sc.useDelimiter(Pattern.compile("[\\p{Punct}*]"));
        if (sc.hasNext()) {
            String userName = sc.next().trim().toLowerCase();
            ArrayList<String> userList = cartDB.getUsers();
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).equals(userName)) {
                    cart = cartDB.loadCart(userName);
                    notFound = false;
                    listCart();
                    break;
                }
            }
            if (notFound) {
                cart.setUsername(userName);
                cartDB.saveCart(cart);
                print("\n" + userName + " has created an account.\n");
            }
        } else {
            print("\nUser name required.\n\n");
        }
    }

    private void populateSampleData(int numOfCarts) {
        for (int i = 0; i < numOfCarts; i++) {
            ShoppingCart newCart = new ShoppingCart(generateRandomString(5));
            for (int j = 0; j < 5; j++) {
                newCart.addToCart(generateRandomString(8));
            }
            cartDB.saveCart(newCart);
        }
    }

    private void print(String text) {
        System.out.println(text);
    }

    public void processPurchase(Scanner sc) {
        sc.useDelimiter(Pattern.compile("[\\p{Punct}*]"));
        print("");
        while (sc.hasNext()) {
            String newItem = sc.next().trim().toLowerCase();
            if (cart.addToCart(newItem)) {
                print(newItem + " has been added to your cart.");
            } else {
                print(newItem + " already exists in cart.");
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

    public void saveCart() {
        if (cart.getUsername() == null) {
            print("Please login before you save your cart.\n");
        } else {
            cartDB.saveCart(cart);
            print("Your shopping cart has been saved.\n");
        }
    }

    public static void main(String[] args) {

        boolean martIsOpen = true;

        String input, command;
        Console cons = System.console();
        FreshMart fm = new FreshMart();
        fm.populateSampleData(6);

        fm.greeting();

        while (martIsOpen) {
            input = cons.readLine();
            Scanner sc = new Scanner(input);
            command = sc.next().toLowerCase();

            switch (command) {
                case "login":
                    fm.login(sc);
                    break;
                case "save":
                    fm.saveCart();
                    break;
                case "users":
                    fm.listUsers();
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