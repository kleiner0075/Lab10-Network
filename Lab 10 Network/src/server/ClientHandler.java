package server;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientHandler extends Thread {
	private Socket clientSocket;
	
	public ClientHandler(Socket socket) {
		this.clientSocket = socket;
	}
	
	public void run() {
		//handle client requests
	}
	
	private void loginUser(String username, String password) {
		//code for user validation
		//references the db tables for column
	}

	private void transferFunds(int fromUserId, int toUserId, double amount) {
		//code for funds transfer
		//transfer funds from user 1 to user 2 or vice versa
	}

	private double checkBalance(int userId) {
		//fund
		double funds = 0;
		return funds;
	}
}