package swf.assessment;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean running = true;
        int port = 3000; // default to 3000
        ArrayList<String> folders = new ArrayList<String>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--port":
                    port = Integer.parseInt(args[i + 1]);
                    i++;
                    break;
                case "--docRoot":
                    StringTokenizer token = new StringTokenizer(args[i + 1], ":");
                    while (token.hasMoreTokens()) {
                        folders.add(token.nextToken());
                    }
                    i++;
                    break;
                default:
                    break;
            }
        }

        ExecutorService pool = Executors.newFixedThreadPool(3);

        ServerSocket socket = new ServerSocket(port);
        System.out.println("Server started.\nListening for connections on port : " + port + " ...\n");

        while (running) {
            Server server = new Server(socket.accept(), folders);

            System.out.println("Connection opened. (" + new Date() + ")");

            Thread thread = new Thread(server);
            thread.start();

            // pool.execute(server);
        }
        socket.close();
        pool.shutdown();
    }

}
