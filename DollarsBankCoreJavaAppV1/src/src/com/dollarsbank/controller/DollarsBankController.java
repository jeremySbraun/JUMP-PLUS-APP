package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;
import com.dollarsbank.utility.FileStorageUtility;

public class DollarsBankController {

	
	
	public static void run() {
		Scanner userInput = new Scanner(System.in);
		boolean newUser = false;
		
		FileStorageUtility.addAccount(new Account("test", "test Address", "123456789", "1", "pass", 150.00));
		FileStorageUtility.addAccount(new Account("test", "test Address", "123456789", "2", "pass", 150.00));
		
		int choice = 0;
		
		
		do {
		 choice = ConsolePrinterUtility.welcomeToBank(userInput);
		
		switch(choice) {
		case 1: 
		
		Account newAccount = ConsolePrinterUtility.newAccount(userInput);
		
		
		
		if(newAccount.equals(null)) {
			newUser = false;
		}
		for(Account storedAccount : FileStorageUtility.getCreatedAccounts()) {
			if(storedAccount.equals(newAccount)) {
			System.out.println("An account like this already exists! Please try again.");
			newUser = false; 
			}
		}
		
		FileStorageUtility.addAccount(newAccount);
		newUser = true;
		newAccount.getTranscationHistory().add("Initial deposit Amount of " + DataGeneratorStubUtil.formatDouble(newAccount.getDepositedAmount()));
			break;
		
			
		case 2: 
			Customer inSystem= ConsolePrinterUtility.Login(userInput);
			Account retreivedAccount = null;
			
			for(Account storedAccount : FileStorageUtility.getCreatedAccounts()) {
				if(storedAccount.getUserId().equals(inSystem.getUserId()) && storedAccount.getPassword().equals(inSystem.getPassword())) {
					
					 
					do {
						
						retreivedAccount = storedAccount;
						choice = ConsolePrinterUtility.welcomeCustomer(userInput);
						
					 switch(choice) {
					 case 1:
						 ConsolePrinterUtility.depositAmount(userInput, retreivedAccount);
						 break;
						 
						 
					 case 2:
						 ConsolePrinterUtility.withdrawAmount(userInput, retreivedAccount);
						 break;
						 
					 case 3:
						 
						 //TODO add functionality to incorporate an account to add too
						 ConsolePrinterUtility.fundsTransfer(userInput, retreivedAccount);
						 break;
						 
					 case 4:
						ConsolePrinterUtility.recentTransactions(retreivedAccount);
						 
						 break;
						 
					 case 5:
						 ConsolePrinterUtility.displayCustomerInformation(retreivedAccount);
						 break;
						 
					 case 6:
						 System.out.println("Logging out valued customer!");
						 newUser = true;
						 break;
					 }
					 
					}while(choice != 6);
				}
			}
			
			break;
			
		case 3: 
			System.out.println("Enjoy your day!");
			System.exit(0);
		
	}
		
		}while(newUser);
}
	
	
	
	
	
	
}

