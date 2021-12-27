package task1.validators;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CustomerForm {

	private int customerId;
	
	@NotEmpty
	@Size(max = 100)
	private String fullName;

	@NotEmpty
	@Size(max = 100)
	@Email
	private String emailAddress;
	
	@NotEmpty
	@Size(max = 20)
	private String password;
	
	private String confirmPassword;
	
	@Size(max = 100)
	private String address;

	@Size(max = 15)
	private String mobileNumber;
	
	@Size(max = 20)
	private String googlePlusCode;
	
	private String isPremium;
	private String dob;
	private String masterId;
	
	@Size(max = 40)
	private String idValue;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGooglePlusCode() {
		return googlePlusCode;
	}

	public void setGooglePlusCode(String googlePlusCode) {
		this.googlePlusCode = googlePlusCode;
	}

	public String getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(String isPremium) {
		this.isPremium = isPremium;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
	
	

}