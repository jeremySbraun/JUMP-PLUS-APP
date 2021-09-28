package com.dollarsbank.utility;

import java.util.ArrayList;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class FileStorageUtility {

	
private static	ArrayList<Account> createdAccounts = new ArrayList<Account>();







public static ArrayList<Account> getCreatedAccounts() {
	return createdAccounts;
}

public static void setCreatedAccounts(ArrayList<Account> createdAccounts) {
	FileStorageUtility.createdAccounts = createdAccounts;
}


public static void addAccount(Account addAccount) {
	createdAccounts.add(addAccount);
}

public static Account checkAccount(Customer logCustomer) {
	
	Account accountFound = null;
	for(Account account : createdAccounts) {
		if(account.getUserId().equals(logCustomer.getUserId())) {
			if(account.getPassword().equals(logCustomer.getPassword())) {
				accountFound = account;
				return accountFound;
			}
			else {
				System.out.println("Incorrect Password");
				return null;
			}
		}
	}

	System.out.println("User not Found.");
	return null;
	
}


	
	
	
	 
}
