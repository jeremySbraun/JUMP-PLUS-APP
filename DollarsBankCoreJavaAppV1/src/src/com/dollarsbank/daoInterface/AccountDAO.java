package com.dollarsbank.daoInterface;

import java.util.List;

import com.dollarsbank.model.Account;

public interface AccountDAO {

	public List<Account> getAllAccounts();
	public Account getAccount(String userId);
	public boolean addAccount(Account a);
	
	//not required
	public boolean deleteAccount(String userId);
	//not required
	public boolean updateAccount(String userId);
	
}
