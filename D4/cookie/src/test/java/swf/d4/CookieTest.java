package swf.d4;

import org.junit.Test;

public class CookieTest {

    @Test
    public void getCookie() {
        Cookie c = Cookie.getCookie("Cookies.json");
        System.out.println(c.getFortune());
    }
}
