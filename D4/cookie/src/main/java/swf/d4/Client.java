package swf.d4;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    // initializing socket and input output streams
    private DataOutputStream dos = null;
    private Scanner scanner = null;
    private Socket socket = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connection Established!! ");
            System.out.println("input \"Finish\" to terminate the connection. ");

            scanner = new Scanner(System.in);

            dos = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException uh) {
            System.out.println(uh);
        } catch (IOException io) {
            System.out.println(io);
        }

        String str = "";

        while (!str.equals("Finish")) {
            str = scanner.nextLine();
            try {
                dos.writeUTF(str);
            } catch (IOException io) {
                System.out.println(io);
            }
        }
        System.out.println(" Connection Terminated!! ");

        try {
            dos.close();
            socket.close();
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public static void main(String argvs[]) {
        // creating object of class Client
        Client client = new Client("localhost", 6666);
    }
}
