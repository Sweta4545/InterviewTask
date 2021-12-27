package task1.validators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import task1.service.CustomerService;

@Component("RegisterValidator")
public class RegisterValidator {
	
	@Autowired
	private CustomerService customerService;

	public boolean supports(Class<?> klass) {
		return CustomerForm.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
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

}
