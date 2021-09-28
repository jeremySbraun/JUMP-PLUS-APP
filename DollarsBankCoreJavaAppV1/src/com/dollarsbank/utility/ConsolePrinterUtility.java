package com.dollarsbank.utility;

import java.util.Scanner;

import javax.swing.plaf.multi.MultiInternalFrameUI;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

import jdk.jfr.DataAmount;


public class ConsolePrinterUtility {

	
	private static final String MENU_STRING = "+----------------------------------+";
	private static final String SIDE_MENU_STRING = "| ";
	private static final String SIDE_MENU_STRING_END_STRING = "|";
	
	
	public static int welcomeToBank(Scanner input) {
		int choice = 0;
		while(choice != 1 && choice != 2 && choice != 3) {
		menuBlock("DOLLARSBANK Welcomes You!");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit.");
		
		System.out.println(ColorsUtility.applyColor("\nEnter Choice (1,2 or 3)  :", "GREEN",false));
		
		String inputChoice = input.nextLine();
		
		try {
			choice = Integer.parseInt(inputChoice);
			if(choice != 1 && choice != 2 && choice != 3) {
				System.out.println("The value you entered is not "
						+ "a valid response!");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid Input!!!");
		}
		
	}
		return choice;
		
}
	
	public static Account newAccount(Scanner input ) {
		boolean accepted = false;
				menuBlock("Enter Details For New Account");
		
		System.out.println("Customer Name: ");
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		
		String nameString = input.nextLine();
		
		System.out.println(ColorsUtility.applyColor("Customer Address: ", "WHITE", false));
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		
		String addressString = input.nextLine();
		
		
		
		
		String contactString = "";
		while(!(accepted)) {
		
			
		System.out.println(ColorsUtility.applyColor("Customer Contact Info: ", "WHITE", false));
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		contactString = input.nextLine();
		
		 
		
			if(!(DataGeneratorStubUtil.phoneRegex(contactString))) {
				System.out.println(ColorsUtility.applyColor("The input is in an unexpted format."
						+ "\nPlease make sure the number you enter is a valid phone number\n" , "RED", false));
				accepted = false;
			}
			else {
				accepted = true;
			}
		
		
		}
		
		
		
		
		System.out.println(ColorsUtility.applyColor("User Id: ", "WHITE", false));
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		String userId = input.nextLine();
		

		accepted = false;
		
		String password = "";
		while(!(accepted)) {
			
			
			System.out.println(ColorsUtility.applyColor( "Password: 8 Characters with atleast 1 Lower, 1 Upper & 1 Special", "WHITE", false));
			System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
			 password = input.nextLine();
			 
			
				if(!(DataGeneratorStubUtil.passwordRegex(password))) {
					System.out.println(ColorsUtility.applyColor("The input is in an unexpted format."
							+ "\nPlease make sure the password you enter is a valid password\n", "RED", false));
					accepted = false;
				}
				else {
					accepted = true;
				}
			
			
			}
		
		System.out.println(ColorsUtility.applyColor("Initial Deposit Amount", "WHITE", false));
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		Double initialDeposit = input.nextDouble();
		input.nextLine();
		
		//TODO check for deposit amount 
		
		return new Account(nameString, addressString, contactString, userId, password,
				initialDeposit);
		
		
	}


	public static Customer Login(Scanner input) {
		
				menuBlock("Enter Login Details");
			
		
		System.out.println("User Id : ");
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		String userId = input.nextLine();
		
		System.out.println(ColorsUtility.applyColor("Password : ", "WHITE", false));
		
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		String password = input.nextLine();
		
		return new Customer(userId, password);
		
		
		
		
	}
	
	public static int welcomeCustomer(Scanner input) {
		
		
		int choice = 0;
		while(!(choice >= 1 && choice <= 6)) {
		menuBlock("WELCOME Customer!!!");
		
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
		
		System.out.println("\nEnter Choice (1,2,3,4,5 or 6)  :");
		
		String inputChoice = input.nextLine();
		
		
		try {
			choice = Integer.parseInt(inputChoice);
			if(!(choice >= 1 && choice <= 6)) {
				System.out.println(ColorsUtility.applyColor("The value you entered is not "
						+ "a valid response!", "RED", false));
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(ColorsUtility.applyColor("Invalid Input!!!", "RED", false));
		}
		
	}
		return choice;
		
	}
	
	public static void depositAmount(Scanner input, Account userAccount) {
		menuBlock("DEPOSIT");
		String inputString = "";
		boolean first = true;
		
		
		do{
			if(first) {
			System.out.println("Would you like to deposit money?");
			}else {
				System.out.println("Would you like to deposit more money?");
			}
			
			System.out.println("Y/N");
			
			System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
			
			inputString = input.nextLine().toLowerCase().substring(0, 1);
			
			
			if(inputString.equals("y")) {
				
				double amountDeposit = -1;
				do {
				System.out.println(ColorsUtility.applyColor("Please enter the amount you would like to deposit.", "WHITE", false));
				
				
				//TODO check for proper value!
				System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
				String userInput = input.nextLine();
				 amountDeposit = DataGeneratorStubUtil.checkForDouble(userInput);
				
				
				}while(amountDeposit == -1);
				Double newAmountDeposited = userAccount.getDepositedAmount() + amountDeposit;
				
				
				String history = "\nThe amount of " + DataGeneratorStubUtil.formatDouble(amountDeposit) + " has been deposited."
						+ "\n The current total of this account is " + DataGeneratorStubUtil.formatDouble(newAmountDeposited) + ".\n";
				
				System.out.println(ColorsUtility.applyColor(history, "WHITE", false));
				//TODO format properly
				userAccount.getTranscationHistory().add(history);
				
				userAccount.setDepositedAmount(newAmountDeposited);
				first = false;
				
			}else if(!(inputString.equals("n"))) {
				System.out.println(ColorsUtility.applyColor("Invalid Input!!", "RED", false));
				
			}
			
		}while(!(inputString.equals("n")));
		
		
	}
	
	public static void withdrawAmount(Scanner input, Account userAccount) {
		menuBlock("WITHDRAW");
		String inputString = "";
		boolean first = true;
		boolean failedAttempt = false;
		
		
		do{
			if(first) {
			System.out.println("Would you like to withdraw money?");
			}else if(failedAttempt) {
				System.out.println("Would you like to try to withdraw money again?");
			}
			
			else {
				System.out.println("Would you like to withdraw more money?");
			}
			
			System.out.println("Y/N\n");
			
			
			System.out.print(ColorsUtility.applyColor("", "YELLOW", true)); 
			inputString = input.nextLine().toLowerCase().substring(0, 1);
			
			if(inputString.equals("y")) {
				System.out.println(ColorsUtility.applyColor("\n", "WHITE", false));
				System.out.printf("You currently have " + "$%.2f" + 
						" in your account.\n", userAccount.getDepositedAmount());
				System.out.println("Please enter the amount you would like to withdraw.\n");
				
				
				System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
				String amountWithdrawnString = input.nextLine();
				Double amountWithdrawn = DataGeneratorStubUtil.checkForDouble(amountWithdrawnString);
				
				System.out.println(ColorsUtility.applyColor("\n", "WHITE", false));
				
				if(amountWithdrawn <= userAccount.getDepositedAmount() && amountWithdrawn != -1) {
					
					Double newAmountDeposited = userAccount.getDepositedAmount() - amountWithdrawn;
					
					userAccount.setDepositedAmount(newAmountDeposited);
					
					String history = "The amount of " + DataGeneratorStubUtil.formatDouble(amountWithdrawn) + " has been withdrawn."
							+ "\n The current total of this account is " + DataGeneratorStubUtil.formatDouble(newAmountDeposited) + ".\n\n";
					
					System.out.print(history);
					//TODO format properly
					userAccount.getTranscationHistory().add(history);
					
					first = false;
					failedAttempt = false;
				}else {
					failedAttempt = true;
					first = false;
					System.out.println(ColorsUtility.applyColor("The value you entered is not available to withdraw!\n", "RED", false));
				}
			}else if(!(inputString.equals("n"))) {
				System.out.println(ColorsUtility.applyColor("Invalid Input!!", "RED", false));
				
			}
			
		}while(!(inputString.equals("n")));
			
		
	}
	
	//TODO add a system memory to obtain account receiver
	public static void fundsTransfer(Scanner input, Account sender) {
		boolean first = true;
		boolean UserExists = false;
		String inputString = ""; 
		String receiverId = "";
		
		menuBlock("Funds Transfer");
		
		
		
		do {
			
			if(first) {
				System.out.println("Would you like to transfer funds to an account?");
			}else {
		System.out.println("Would you like to transfer funds to a different account?");
			}
		
			
			System.out.println("Y/N");
		
		
		System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
		inputString = input.nextLine().toLowerCase().substring(0, 1);
		
		
		if((inputString.equals("y") || receiverId.equals("QUIT")) && (!(inputString.equals("n")))) {
		
		
		do {
			System.out.println(ColorsUtility.applyColor("\n", "WHITE", false));
			System.out.println("Please enter user id of account you would like to transfer to. \nPlease enter 'QUIT' if "
					+ "you wish to exit funds transfer.");
			
			System.out.print(ColorsUtility.applyColor("", "YELLOW", true));
			 receiverId = input.nextLine();
			
			System.out.println(ColorsUtility.applyColor("\n", "WHITE", false));
			for(Account receiver : FileStorageUtility.getCreatedAccounts()) {
				
				if(receiver.getUserId().equals(receiverId)) {
					
					
					System.out.println("The receiving account is: ");
					System.out.println("Full Name: " + receiver.getFullName());
					System.out.println("User Id: " + receiver.getUserId());
					
					
					
					System.out.println("\nYour account currently has a balance of: " + 
					DataGeneratorStubUtil.formatDouble(sender.getDepositedAmount()));
					System.out.println("\nPlease enter the amount you would like to transfer.\n If this is made in error please enter 0.");
					
					
					System.out.print(ColorsUtility.applyColor("", "YELLOW", true)); 
					Double amountTransfer = DataGeneratorStubUtil.checkForDouble(input.nextLine());
					
					
					System.out.println(ColorsUtility.applyColor("\n", "WHITE", false)); 
					if(amountTransfer == 0){
						System.out.println("Returning to main menu.\n");
						return;
					}
					else if(amountTransfer == -1){
						System.out.println(ColorsUtility.applyColor("The value you entered is not an accepted value!", "RED", false));					
					}
					
					else if(amountTransfer <= sender.getDepositedAmount()) {
					sender.setDepositedAmount(sender.getDepositedAmount() - amountTransfer);
					receiver.setDepositedAmount(receiver.getDepositedAmount()+amountTransfer);
					first = false;
					UserExists = true;
					
					
					String successString = 
							"The amount of  " + DataGeneratorStubUtil.formatDouble(amountTransfer) +
							" has been transferred to User Id: " + receiver.getUserId() + ". \n\nThe current balance in your account is " 
									+ DataGeneratorStubUtil.formatDouble(sender.getDepositedAmount())
									+ ".\n\n";
					sender.getTranscationHistory().add(successString);
					
					System.out.println(successString);
					
					receiver.getTranscationHistory().add("\n\nThe amount of " + DataGeneratorStubUtil.formatDouble(amountTransfer) +
							" has been transferred into your account. The current balance in your account is " + 
							DataGeneratorStubUtil.formatDouble(receiver.getDepositedAmount()) + "\n\n");
					
					
					
					}
					
					else {
						System.out.println(ColorsUtility.applyColor("The value you entered is not available to withdraw!", "RED", false));
					}
				}
				}
			
			if(receiverId.equals("QUIT")) {
				UserExists = true;
			}
			if(!(UserExists)) {
					System.out.println(ColorsUtility.applyColor("This user doesn't exist!", "RED", false));
			}
				
				
				
		}while(!(UserExists));
			
		
		
		
		}
		
		
		
		}while(inputString.equals("y"));
		
	}
	
	
	
	public static void recentTransactions(Account account) {
		
		for(int i = 0; (i < account.getTranscationHistory().size() && i < 5) ; i++) {
			System.out.println(account.getTranscationHistory()
					.get(account.getTranscationHistory().size() - (1 + i)));
		}
		
	}
	
	public static void displayCustomerInformation(Account account) {
		
		menuBlock("Customer Info");
		System.out.println("Customer Name: " + account.getFullName());
		System.out.println("Customer Address: " + account.getAddress());
		System.out.println("Customer Contact Number: " + account.getContactNumber());
		System.out.println("User Id: " + account.getUserId());
		System.out.println("Password: " + account.getPassword());
		System.out.println("Current Deposit: " + account.getDepositedAmount());
	}
	
	
	//TODO create printf for proper sizing
	public static void menuBlock(String title) {
		
		
		
		while(title.length() < MENU_STRING.length() - 3) {
			title = " "+ title + " ";
		}
		
		if(title.length() >33 ) {
			title = title.substring(0, title.length()-1);
		}
		
		
		
		title =(SIDE_MENU_STRING +title + SIDE_MENU_STRING_END_STRING);
		System.out.printf((ColorsUtility.applyColor("%-36s\n","BLUE", false)), MENU_STRING);
		System.out.printf((ColorsUtility.applyColor("%-36s\n", "BLUE", false)), title);
		System.out.printf((ColorsUtility.applyColor("%-36s\n","BLUE", false)), MENU_STRING);
	}



}
