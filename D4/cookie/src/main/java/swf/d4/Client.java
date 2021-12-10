package swf.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private BufferedReader in = null;
    private PrintWriter out = null;
    private Scanner scanner = null;
    private Socket socket = null;

    private boolean terminated;

    public Client(String address, int port) {
        terminated = false;

        try {
            socket = new Socket(address, port);
            System.out.println("\nSocket initialized.");
            System.out.println("Waiting for response ... \n");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected to: " + address + ":" + port + ".\n");

            String command = "";
            String response = "";
            scanner = new Scanner(System.in);

            while (!terminated) {                
                command = scanner.nextLine();
                out.println(command);
                out.flush();
                
                response = in.readLine().toLowerCase();

                switch (response) {
                    case "finish":
                        terminated = true;
                        break;
                    default:
                        System.out.println(response);
                }
            }

            in.close();
            out.close();
            socket.close();
            scanner.close();
            System.out.println(" Connection Terminated.");

        } catch (UnknownHostException uh) {
            System.out.println(uh);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public static void main(String args[]) {
        String[] arguments = args[0].split(":");
        new Client(arguments[0], Integer.parseInt(arguments[1]));
    }
}
