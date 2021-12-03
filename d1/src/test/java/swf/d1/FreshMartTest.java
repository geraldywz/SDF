package swf.d1;

import org.junit.Test;

public class FreshMartTest{
    
    @Test
    public void testAddToCart(){
        FreshMart fm = new FreshMart();
        fm.addToCart("Apple");
        fm.addToCart("Durian");
        fm.addToCart("Orange");
        fm.addToCart("Pear");
        //assertTrue(fm.cartSize()==4);
        fm.print("4 items have been added to cart.");
    }
}