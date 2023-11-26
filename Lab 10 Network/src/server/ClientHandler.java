package server;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private Connection connection;

    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            // Handle client requests
            // Example: login("ryan", "ryanpass");
            // Example: transferFunds(1, 2, 100.0);
            // Example: checkBalance(1);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(String username, String password) throws SQLException {
        // Example: Perform login by querying the database
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Login successful
                System.out.println("Login successful!");
            } else {
                // Login failed
                System.out.println("Invalid username or password");
            }
        }
    }

    private void transferFunds(int senderId, int receiverId, double amount) throws SQLException {
        // Example: Perform fund transfer by updating the database
        // You'll need to handle transactions properly to ensure atomicity
        String updateSenderBalance = "UPDATE users SET balance = balance - ? WHERE id = ?";
        String updateReceiverBalance = "UPDATE users SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement updateSender = connection.prepareStatement(updateSenderBalance);
             PreparedStatement updateReceiver = connection.prepareStatement(updateReceiverBalance)) {
            connection.setAutoCommit(false);

            // Deduct funds from the sender
            updateSender.setDouble(1, amount);
            updateSender.setInt(2, senderId);
            updateSender.executeUpdate();

            // Add funds to the receiver
            updateReceiver.setDouble(1, amount);
            updateReceiver.setInt(2, receiverId);
            updateReceiver.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

            System.out.println("Funds transferred successfully!");
        } catch (SQLException e) {
            connection.rollback();
            connection.setAutoCommit(true);
            e.printStackTrace();
        }
    }

    private void checkBalance(int userId) throws SQLException {
        // Example: Retrieve and print user's balance
        String sql = "SELECT balance FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                System.out.println("Your balance is: " + balance);
            } else {
                System.out.println("User not found");
            }
        }
    }
}
