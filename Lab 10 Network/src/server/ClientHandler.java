	package server;

import java.net.Socket;

public class ClientHandler extends Thread {
	private Socket clientSocket;
	
	public ClientHandler(Socket socket) {
		this.clientSocket = socket;
	}
	
	public void run() {
		//handle client requests
	}

}
