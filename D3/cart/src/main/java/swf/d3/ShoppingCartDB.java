package swf.d3;

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
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUsername().equals(userName)) {
                sc = carts.get(i);
            }
        }
        return sc;
    }

    @SuppressWarnings("unchecked")
    public void saveCart(ShoppingCart sc) {
        boolean duplicate = false;
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUsername().equals(sc.getUsername())) {
                carts.set(i, sc);
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            carts.add(sc);
        }
        try (
                FileWriter file = new FileWriter("users.json")) {

            JSONArray cartsExport = new JSONArray();
            for (int i = 0; i < carts.size(); i++) {
                cartsExport.add(cartToJSON(carts.get(i)));
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

    private ShoppingCart jsonToCart(JSONObject obj) {
        ShoppingCart sc = new ShoppingCart((String) obj.get("User"));

        JSONArray items = (JSONArray) obj.get("Items");
        for (int i = 0; i < items.size(); i++) {
            sc.addToCart((String) items.get(i));
        }
        return sc;
    }

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