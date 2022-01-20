package task1.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import task1.dao.AccountDao;
import task1.model.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Account> listAccount() {
		return (List<Account>) sessionFactory.getCurrentSession().createCriteria(Account.class)
				.addOrder(Order.desc("accountId")).list();
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Account> getAccountByAccountId(Long accountId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Account where accountId=:accountId ORDER BY accountId DESC")
				.setParameter("accountId", accountId).list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<Account> getAccountByCustomerId(int customerId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Account where customerId=:customerId ORDER BY accountId DESC")
				.setParameter("customerId", customerId).list();
	}

	public void saveAccount(Account account) {
		sessionFactory.getCurrentSession().save(account);
		
	}

	public void updateAccount(Account account) {
		sessionFactory
		.getCurrentSession()
		.createQuery(
		"UPDATE Account SET accountNumber=:accountNumber , accountOpenDate=:accountOpenDate , accountCloseDate=:accountCloseDate , balance=:balance , accountType=:accountType , customer_customer_id=:customer where accountId=:accountId").setParameter("accountNumber", account.getAccountNumber()).setParameter("accountOpenDate", account.getAccountOpenDate()).setParameter("accountCloseDate", account.getAccountCloseDate()).setParameter("balance", account.getBalance()).setParameter("accountType", account.getAccountType()).setParameter("customer", account.getCustomer()).setParameter("accountId", account.getAccountId()).executeUpdate();
		
	}

	public void deleteAccount(Account account) {
		sessionFactory.getCurrentSession().createQuery("delete from Account where accountId=:accountId")
		.setParameter("accountId", account.getAccountId()).executeUpdate();		
	}

}
