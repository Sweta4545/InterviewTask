package task1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task1.dao.AccountDao;
import task1.model.Account;
import task1.service.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;

	public List<Account> listAccount() {
		return accountDao.listAccount();

	}

	public List<Account> getAccountByAccountId(Long accountId) {
		return accountDao.getAccountByAccountId(accountId);

	}
	public List<Account> getAccountByCustomerId(int customerId) {
		return accountDao.getAccountByCustomerId(customerId);

	}

	public void saveAccount(Account account) {
		accountDao.saveAccount(account);;
		
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);;
		
	}

	public void deleteAccount(Account account) {
		accountDao.deleteAccount(account);;
		
	}

}
