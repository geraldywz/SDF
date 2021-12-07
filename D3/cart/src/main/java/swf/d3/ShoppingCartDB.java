package swf.d3;

import java.util.ArrayList;

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

    public String getFilePath(){
        return filePath;
    }   

    public ArrayList<String> getUsers(){
        // To Do
        return new ArrayList<String>();
    }

}