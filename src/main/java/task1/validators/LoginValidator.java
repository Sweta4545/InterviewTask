package task1.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import task1.model.Admin;
import task1.model.Customer;
import task1.service.AdminService;
import task1.service.CustomerService;

@Component("LoginValidator")
public class LoginValidator {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AdminService adminService;

	public boolean supports(Class<?> klass) {
		return Customer.class.isAssignableFrom(klass);
	}

	public void customerValidate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		if ((customer.getEmailAddress() != null) && (customer.getEmailAddress().length() > 0)) {
			customer.setEmailAddress(customer.getEmailAddress().trim());
			List<Customer> customerlist = customerService.validateLoginCustomer(customer.getEmailAddress(), customer.getPassword());
			if ((customerlist != null) && (customerlist.size() > 0)) {
			} else {
				errors.rejectValue("emailAddress", "notMatchEmailAndPassword.customer.emailAddress",
						"Customer Email or Password you entered is incorrect.");
			}
		}
	}
	
	public void adminValidate(Object target, Errors errors) {
		Admin admin = (Admin) target;
		if ((admin.getAdminEmail() != null) && (admin.getAdminEmail().length() > 0)) {
			admin.setAdminEmail(admin.getAdminEmail().trim());
			List<Admin> adminList = adminService.validateLoginAdmin(admin.getAdminEmail(), admin.getPassword());
			if ((adminList != null) && (adminList.size() > 0)) {
			} else {
				errors.rejectValue("emailAddress", "notMatchEmailAndPassword.admin.emailAddress",
						"Admin Email or Password you entered is incorrect.");
			}
		}
	}

}
