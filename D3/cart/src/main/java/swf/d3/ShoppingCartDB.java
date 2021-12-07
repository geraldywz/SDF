package swf.d3;

import java.util.ArrayList;
//import org.json.simple.JSONArray;
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

    private JSONObject toJSON(ShoppingCart sc){
        JSONObject obj = new JSONObject();
        obj.put("User", sc.getUsername());
        obj.put();
        obj.put();
        obj.put();

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
}