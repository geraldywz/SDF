package swf.assessment;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.Socket;

public class Server implements Runnable {

	static final String DEFAULT_FILE = "index.html";

	ArrayList<String> folders;
	private Socket socket;
	private HttpClientConnection htc;

	public Server(Socket socket, ArrayList<String> newFolders) {
		this.socket = socket;
		if (newFolders.size() > 0 && newFolders != null) {
			for (String folderPath : newFolders) {
				this.folders.add(folderPath + "/");
			}
		} else {
			this.folders = new ArrayList<String>();
			this.folders.add("static/");
		}
	}

	private String getContentType(String fileRequest) {
		if (fileRequest.endsWith(".htm") || fileRequest.endsWith(".html"))
			return "text/html";
		else
			return "text/plain";
	}

	private void fileNotFound(String fileRequest) throws IOException {
		String title = "HTTP/1.1 404 Not Found";
		String errorMsg = fileRequest + " not found";
		htc.printError(title, errorMsg);
		System.out.println("File " + fileRequest + " not found");
	}

	private void methodNotAllowed(String method) throws IOException {
		String title = "HTTP/1.1 405 Method Not Allowed";
		String errorMsg = method + " not supported";
		htc.printError(title, errorMsg);
		System.out.println(method + " not supported");
	}

	private byte[] readFileData(File file, int fileLength) throws IOException {
		FileInputStream fileIn = null;
		byte[] fileData = new byte[fileLength];

		try {
			fileIn = new FileInputStream(file);
			fileIn.read(fileData);
		} finally {
			if (fileIn != null)
				fileIn.close();
		}
		return fileData;
	}

	@Override
	public void run() {
		String fileRequest = "";
		try {
			htc = new HttpClientConnection(socket);
			String method = htc.getMethod();
			
			if (("GET").equals(method)) {
				fileRequest = htc.getFileRequest();
				if (fileRequest.endsWith("/")) {
					fileRequest += DEFAULT_FILE;
				}
				
				String content = null;
				int fileLength = 0;
				byte[] fileData = null;
				
				for (int i = 0; i < folders.size(); i++) {
					String folderPath = folders.get(i);					
					File file = new File(new File(folderPath), fileRequest);
					if (file.canRead()) {
						fileLength = (int) file.length();
						content = getContentType(fileRequest);
						fileData = readFileData(file, fileLength);
						break;
					} else {
						System.exit(1);
					}
				}
				htc.print("HTTP/1.1 200 OK", content, fileLength, fileData);

				System.out.println("File " + fileRequest + " of type " + content + " returned");

			} else {
				methodNotAllowed(method);
			}

		} catch (FileNotFoundException fnfe) {
			try {
				fileNotFound(fileRequest);
			} catch (IOException ioe) {
				System.err.println("File not found exception : " + ioe.getMessage());
			}

		} catch (IOException ioe) {
			System.err.println("Server error : " + ioe);
		} finally {
			try {
				htc.close();
				socket.close();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Connection closed.\n");
		}
	}
}