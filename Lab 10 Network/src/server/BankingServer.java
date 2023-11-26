package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankingServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the BankingServer class
            new BankingServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BankingServer() throws IOException {
        try {
            // Establish a connection to the MySQL database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankofrak",
                    "root",
                    "root"
            );

            ServerSocket serverSocket = new ServerSocket(5001);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, connection).start();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}