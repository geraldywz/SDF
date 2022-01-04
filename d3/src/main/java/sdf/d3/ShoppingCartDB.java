package sdf.d3;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ShoppingCartDB {

    private String filePath;
    private ArrayList<ShoppingCart> carts;

    public ShoppingCartDB() {
        carts = new ArrayList<ShoppingCart>();
    }

    public ShoppingCartDB(String filePath) {
        this.filePath = filePath;
        carts = new ArrayList<ShoppingCart>();
    }

    public ShoppingCart loadCart(String userName) {
        ShoppingCart sc = null;
        for (ShoppingCart cart : carts) {
            if (userName.equals(cart.getUsername())) {
                sc = cart;
                break;
            }
        }
        return sc;
    }

    @SuppressWarnings("unchecked")
    public void saveCart(ShoppingCart sc) {

        for (ShoppingCart cart : carts) {
            if (sc.getUsername().equals(cart.getUsername())) {
                carts.remove(cart);
                break;
            }
        }
        carts.add(sc);
        try (
                FileWriter file = new FileWriter("users.json")) {

            JSONArray cartsExport = new JSONArray();
            for (ShoppingCart cart : carts) {
                cartsExport.add(cartToJSON(cart));
            }
            file.write(cartsExport.toString());

            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @SuppressWarnings("unchecked")
    private JSONObject cartToJSON(ShoppingCart sc) {
        JSONObject obj = new JSONObject();
        obj.put("User", sc.getUsername());

        JSONArray items = new JSONArray();
        for (int i = 0; i < sc.size(); i++) {
            items.add(sc.get(i));
        }
        obj.put("Items", items);

        return obj;
    }

    /* private ShoppingCart jsonToCart(JSONObject obj) {
        ShoppingCart sc = new ShoppingCart((String) obj.get("User"));

        JSONArray items = (JSONArray) obj.get("Items");
        for (Object item : items) {
            sc.addToCart((String) item);
        }
        return sc;
    } */

    public String getFilePath() {
        return filePath;
    }

    public ArrayList<String> getUsers() {
        ArrayList<String> userList = new ArrayList<>();
        for (ShoppingCart cart : carts) {
            userList.add(cart.getUsername());
        }
        return userList;
    }
}