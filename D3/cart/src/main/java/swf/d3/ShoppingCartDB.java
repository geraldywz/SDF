package swf.d3;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ShoppingCartDB {

    private String filePath;
    private ArrayList<ShoppingCart> carts;

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
        return new ShoppingCart();
    }

    public void saveCart(ShoppingCart sc){
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUsername().equals(sc.getUsername())) {
                carts.set(i, sc);
                break;
            }else{
                carts.add(sc);
            }
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private JSONObject cartToJSON(ShoppingCart sc) {
        JSONObject obj = new JSONObject();
        obj.put("User", sc.getUsername());

        JSONArray items = new JSONArray();
        for (int i = 0; i < sc.size(); i++) {
            items.put(sc.get(i));
        }
        obj.put("Items", items);

        return obj;
    }

    private ShoppingCart jsonToCart(JSONObject obj) {
        ShoppingCart sc = new ShoppingCart((String) obj.get("User"));

        JSONArray items = (JSONArray) obj.get("Items");
        for (int i = 0; i < items.length(); i++) {
            sc.addToCart((String) items.get(i));
        }
        return sc;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean doesUserExist() {
        boolean userExists = true;
        // To Do
        return userExists;
    }

    public ArrayList<String> getUsers() {
        // To Do
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart("John");
        sc.populateSampleData();
        ShoppingCartDB scdb = new ShoppingCartDB("Test");
        JSONObject obj = scdb.cartToJSON(sc);
        System.out.println(obj);
        sc = scdb.jsonToCart(obj);
        System.out.println(sc.getUsername());
        for (int i = 0; i < sc.size(); i++) {
            System.out.println(sc.get(i));
        }
    }
}