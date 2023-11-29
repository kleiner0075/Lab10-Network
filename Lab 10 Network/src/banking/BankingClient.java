package banking;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Scanner;

import server.*;

public class BankingClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//connect to server
		//implement user interface
		
		Socket socket = new Socket("localhost", 5001);
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Bank of RAK");
		System.out.println("Please Login");

		System.out.println("Please select an option:");
		System.out.println("--------------------------");
		System.out.println("1. Transfer Funds");
		System.out.println("2. Check Balance");
		System.out.println("3. Exit");

		int numInput = userInput.nextInt();
		switch(numInput) {
		case 1:
			System.out.println("how much would you like to transfer?");
			double transferAmount = userInput.nextDouble();
			break;
		case 2:
			System.out.println("Your balance is: ");
			break;
		case 3:
			System.out.println("Goodbye!");
			break;
			default:
				System.out.println("not a good answer");
		}

	}
}
