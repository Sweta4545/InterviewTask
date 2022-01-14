package task1.dao;

import java.util.List;

import task1.model.Account;

public interface AccountDao {
	
	public List<Account> listAccount();
	public List<Account> getAccountByAccountId(Long accountId);
	public List<Account> getAccountByCustomerId(int customerId);
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Account account);

}
