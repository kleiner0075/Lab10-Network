package banking;

import java.util.Scanner;

public class BankingClient {
	public static void main(String[] args) {
		//connect to server
		//implement user interface
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Bank of RAK");
		System.out.println("Please select an option:");
		System.out.println("--------------------------");
		System.out.println("1. Transfer Funds");
		System.out.println("2. Check Balance");
		System.out.println("3. Exit");

		int numInput = userInput.nextInt();
		switch(numInput) {
		case 1:
			System.out.println("how much would you like to transfer?");
			break;
		case 2:
			System.out.println();
			break;
		case 3:
			System.out.println("Goodbye!");
			break;
			default:
				System.out.println("not a good answer");
		}

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
		System.out.println("you're broke as fuck lmaooooooo");

		return funds;
	}
}
