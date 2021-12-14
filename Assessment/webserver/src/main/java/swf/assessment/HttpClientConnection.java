package swf.assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class HttpClientConnection {

    private BufferedReader in = null;
    private PrintWriter out = null;
    private BufferedOutputStream dataOut = null;

    private String method;
    private String fileRequest;

    public HttpClientConnection(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
        dataOut = new BufferedOutputStream(socket.getOutputStream());

        // Get 1st line of the request
        String input = in.readLine();

        StringTokenizer parse = new StringTokenizer(input);
        method = parse.nextToken().toUpperCase();

        fileRequest = parse.nextToken().toLowerCase();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        dataOut.close();
    }

    public String getMethod() {
        return this.method;
    }

    public String getFileRequest() {
        return this.fileRequest;
    }

    public void print(String title, String content, int fileLength, byte[] fileData) throws IOException {
        out.println(title);
        out.println("Server: Java HTTP Server 1.0");
        out.println("Date: " + new Date());
        out.println("Content-type: " + content);
        out.println("Content-length: " + fileLength);
        out.println(); // blank line between headers and content
        out.flush(); // flush character output stream buffer

        dataOut.write(fileData, 0, fileLength);
        dataOut.flush();
    }

    public void printError(String title, String errorMsg) {
        out.println(title);
        out.println();
        out.println(errorMsg);
        out.println();
        out.flush();
    }
}
