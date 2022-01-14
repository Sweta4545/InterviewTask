package task1.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("RegisterValidator")
public class RegisterValidator {
	

	public boolean supports(Class<?> klass) {
		return CustomerForm.class.isAssignableFrom(klass);
	}

	public void customerValidate(Object target, Errors errors) {
		CustomerForm customerForm = (CustomerForm) target;
		
		if ((customerForm.getEmailAddress()).length() > 0) {
			customerForm.setEmailAddress((customerForm.getEmailAddress().trim()));
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = p.matcher(customerForm.getEmailAddress());
			boolean b = m.matches();
			if (b != true) {
				errors.rejectValue("emailAddress", "emailAddress.is.not.valid",
						"Customer Email not a well-formed email address.");
			}
		}
		
		if (!(customerForm.getPassword()).equals(customerForm.getConfirmPassword())) {
			errors.rejectValue("password", "matchpassword.customerForm.password",
					"Password and Confirm Password do not match.");
		}
	}
	
	public void adminValidate(Object target, Errors errors) {
		AdminForm adminForm = (AdminForm) target;
		
		if ((adminForm.getAdminEmail()).length() > 0) {
			adminForm.setAdminEmail((adminForm.getAdminEmail().trim()));
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = p.matcher(adminForm.getAdminEmail());
			boolean b = m.matches();
			if (b != true) {
				errors.rejectValue("emailAddress", "emailAddress.is.not.valid",
						"Admin Email not a well-formed email address.");
			}
		}
		
		if (!(adminForm.getPassword()).equals(adminForm.getConfirmPassword())) {
			errors.rejectValue("password", "matchpassword.customerForm.password",
					"Password and Confirm Password do not match.");
		}
	}

}
