package task1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	
	private String accountNumberString;
	private Date accountOpenDate;
	private Date accountClosedDate;
	private Double balance;
	private String accountTypeString;
	
	@JoinColumn(name = "customerId")
	private int customerId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumberString() {
		return accountNumberString;
	}

	public void setAccountNumberString(String accountNumberString) {
		this.accountNumberString = accountNumberString;
	}

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public Date getAccountClosedDate() {
		return accountClosedDate;
	}

	public void setAccountClosedDate(Date accountClosedDate) {
		this.accountClosedDate = accountClosedDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountTypeString() {
		return accountTypeString;
	}

	public void setAccountTypeString(String accountTypeString) {
		this.accountTypeString = accountTypeString;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumberString=" + accountNumberString + ", accountOpenDate="
				+ accountOpenDate + ", accountClosedDate=" + accountClosedDate + ", balance=" + balance
				+ ", accountTypeString=" + accountTypeString + ", customerId=" + customerId + "]";
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String accountNumberString, Date accountOpenDate, Date accountClosedDate,
			Double balance, String accountTypeString, int customerId) {
		super();
		this.accountId = accountId;
		this.accountNumberString = accountNumberString;
		this.accountOpenDate = accountOpenDate;
		this.accountClosedDate = accountClosedDate;
		this.balance = balance;
		this.accountTypeString = accountTypeString;
		this.customerId = customerId;
	}
	
	
	


}
