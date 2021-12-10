package swf.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private BufferedReader in = null;
    private PrintWriter out = null;
    private Socket socket = null;
    private ServerSocket server = null;

    private boolean terminated;

    public Server(int port, String filename) {
        terminated = false;

        try {
            server = new ServerSocket(port);
            System.out.println("Server initialized.");
            System.out.println("Waiting for connection ... \n");

            socket = server.accept();
            System.out.println("Client connected!");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String command = "";
            String response = "";

            while (!terminated) {

                command = in.readLine().toLowerCase();

                System.out.println("Received: " + command);

                switch (command) {
                    case "get-cookie":
                        response = sendCookie(filename);
                        break;
                    case "finish":
                        terminated = true;
                        response = command;
                        break;
                    default:
                        response = invalidCommand(command);
                }
                out.println(response);
                out.flush();
            }
            in.close();
            out.close();
            socket.close();
            server.close();
            System.out.println(" Connection Terminated.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String sendCookie(String filename) {
        Cookie c = Cookie.getCookie(filename);
        return c.getFortune();
    }

    private String invalidCommand(String wrongCommand) {
        return "" + wrongCommand + " is not a valid command.";
        // return "Use the [help] command to see a list of valid commands.\n";
    }

    public static void main(String args[]) {
        Server server = new Server(Integer.parseInt(args[0]), args[1]);
    }

}