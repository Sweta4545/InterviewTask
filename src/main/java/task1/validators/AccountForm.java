package task1.validators;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountForm {
	
	private Long accountId;
	
	@NotEmpty
	@Size(max = 50)
	private String accountNumber;
	
	private Date accountOpenDate;
	private Date accountCloseDate;
	
	private int balance;
	
	@Size(max = 100)
	private String accountType;
	
	private Long customerId;
	

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public Date getAccountCloseDate() {
		return accountCloseDate;
	}

	public void setAccountCloseDate(Date accountCloseDate) {
		this.accountCloseDate = accountCloseDate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

		

}
