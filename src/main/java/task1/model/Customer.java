package task1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;
	
	@NotNull
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "google_plus_code")
	private String googlePlusCode;
	
	@Column(name = "is_premium")
	private String isPremium;
	
	@Column(name = "date_of_birth")
	private String dob;
	
	@Column(name = "master_id")
	private String masterId;
	
	@Column(name = "id_value")
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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