package swf.d3;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ShoppingCartDB {

    private String filePath;

    public ShoppingCartDB(String filePath) {
        this.filePath = filePath;
    }

    public ShoppingCart loadCart(String userName){
        // To Do
        return new ShoppingCart();
    }

    public void saveCart(ShoppingCart sc){
        // To Do
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @SuppressWarnings("unchecked")
    private JSONObject cartToJSON(ShoppingCart sc){
        JSONObject obj = new JSONObject();
        obj.put("User", sc.getUsername());

        JSONArray items = new JSONArray();
        for(int i=0;i<sc.size();i++){
            items.add(sc.get(i));
        }
        obj.put("Items",items);

        return obj;
    }

    private ShoppingCart jsonToCart(JSONObject obj){
        ShoppingCart sc = new ShoppingCart((String)obj.get("User"));
        
        JSONArray items = (JSONArray) obj.get("Items");
        for(int i=0;i<items.size();i++){
            sc.addToCart((String)items.get(i));
        }

        return sc;
    }

    public String getFilePath(){
        return filePath;
    }   

    public boolean doesUserExist(){
        boolean userExists = true;
        // To Do
        return userExists;
    }

    public ArrayList<String> getUsers(){
        // To Do
        return new ArrayList<String>();
    }
        public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.setUsername("John");
        sc.addToCart("apple");
        sc.addToCart("orange");
        sc.addToCart("mango");
        sc.addToCart("kiwi");
        sc.addToCart("banana");
        ShoppingCartDB scdb = new ShoppingCartDB("Test");
        JSONObject obj = scdb.cartToJSON(sc);
        System.out.println(obj);
        sc = scdb.jsonToCart(obj);
        System.out.println(sc.getUsername());
        for(int i=0;i<sc.size();i++){
            System.out.println(sc.get(i));
        }
    }
}