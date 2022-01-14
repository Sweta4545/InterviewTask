package task1.service;

import java.util.List;


import task1.model.Account;


public interface AccountService {
	
	public List<Account> listAccount();
	public List<Account> getAccountByAccountId(Long accountId);
	public List<Account> getAccountByCustomerId(int customerId);
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Account account);


	


}
