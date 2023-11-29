package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankingServer {

    public static void main(String[] args) {
    	ServerSocket serverSocket = new ServerSocket(5000);
    	while (true) {
    		Socket clientSocket = serverSocket.accept();
    		new ClientHandler(clientSocket).start();
    	}
    
    }
}
