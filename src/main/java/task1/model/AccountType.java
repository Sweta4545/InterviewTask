package task1.model;

public enum AccountType {
	
	SAVING ("Saving"),
	CURRENT ("Current"),
	FIXED ("Fixed");
	
	private final String accountType;
	
	private AccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountType() {
		return this.accountType;
	}
}
