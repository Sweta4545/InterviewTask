package task1.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import task1.service.CustomerService;
import task1.validators.CustomerForm;
import task1.validators.RegisterValidator;
import task1.model.Customer;

@Controller
@RequestMapping("/register")
public class RegisterController {

		@Autowired
		private CustomerService customerService;

		@Autowired
		RegisterValidator registerValidater;

		@RequestMapping(method = RequestMethod.GET)
		public String showCustomerLogin(Map<String, CustomerForm> model) {
			CustomerForm customerForm = new CustomerForm();
			model.put("customerForm", customerForm);
			return "/register";
		}

		@RequestMapping(method = RequestMethod.POST)
		public ModelAndView processCustomerLogin(@Valid CustomerForm customerForm, BindingResult result, Map<?, ?> model) {
			registerValidater.validate(customerForm, result);

			if (result.hasErrors()) {
				return new ModelAndView("/register");
			} else {

				Customer customer = new Customer();
				customer.setFullName(customerForm.getFullName());
				customer.setEmailAddress(customerForm.getEmailAddress());
				customer.setPassword(customerForm.getPassword());
				customer.setMobileNumber(customerForm.getMobileNumber());
				customer.setAddress(customerForm.getAddress());
				customer.setGooglePlusCode(customerForm.getGooglePlusCode());
				customer.setIsPremium(customerForm.getIsPremium());
				customer.setDob(customerForm.getDob());
				customer.setMasterId(customerForm.getMasterId());
				customer.setIdValue(customerForm.getIdValue());

				customerService.saveCustomer(customer);
			}
			return new ModelAndView("redirect:login.html");
		}

}
