package task1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "admin_id")
	private Long adminId;

	@Column(name = "admin_name")
	private String adminName;

	@NotEmpty
	@Column(name = "admin_email")
	private String adminEmail;

	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@Column(name = "gender")
	private String adminGender;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "address")
	private String address;

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}