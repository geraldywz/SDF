package swf.d4;

import org.junit.Test;

public class ServerTest {

    @Test
    public void startServer() {
        new Server(12345, "Cookies,json");
    }
}
