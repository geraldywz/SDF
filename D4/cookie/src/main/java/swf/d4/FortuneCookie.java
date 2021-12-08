package swf.d4;

import java.util.ArrayList;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FortuneCookie {

    private ArrayList<Cookie> cookies;

    private DataInputStream dis = null;
    private Socket socket = null;
    private ServerSocket server = null;

    public FortuneCookie(int port) {
        cookies = new ArrayList<Cookie>();

        try {
            server = new ServerSocket(port);
            System.out.println("Server starts");
            System.out.println("Waiting for a client to connect ... ");
            
            socket = server.accept();
            System.out.println("Connected with a Client!! ");

            dis = new DataInputStream(socket.getInputStream());
            String str = ""; // variable for reading messages sent by the client
            // Untill "Finish" is sent by the client,
            // keep reading messages
            while (!str.equals("Finish")) {
                try {
                    // reading from the underlying stream
                    str = dis.readUTF();
                    // printing the read message on the console
                    System.out.println(str);
                } catch (IOException io) {
                    System.out.println(io);
                }
            }
            
            socket.close();
            dis.close();
            System.out.println(" Connection Closed!! ");
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String argvs[]) {
        FortuneCookie fc = new FortuneCookie(6666);
    }

}