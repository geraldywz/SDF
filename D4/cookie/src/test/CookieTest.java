package swf.d4;

import static org.junit.Assert.assertTrue;

import java.beans.Transient;

import org.junit.Test;

public class CookieTest {

    @Test
    public void getCookie() {
        Cookie c = Cookie.getCookie("Cookies.json");
        System.out.println(c.getFortune());
    }

}
