package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankingServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5000);
		while (true) {
			Socket clientSocket = serverSocket.accept();
			new ClientHandler(clientSocket).start();
		}
	}

}
