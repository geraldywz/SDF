package swf.d4;

import org.junit.Test;

public class ClientTest {

    @Test
    public void runClient() {
        new Client("localhost",12345);
    }
}