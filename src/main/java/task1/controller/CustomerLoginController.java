package task1.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import task1.service.CustomerService;
import task1.validators.LoginValidator;
import task1.model.Customer;

@Controller
@RequestMapping("/login")
public class CustomerLoginController {
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showCustomerLogin(Map<String, Customer> model, HttpSession session) {
		if (session.getAttribute("emailAddress") == null) {
			Customer customer = new Customer();
			model.put("customer", customer);
			return new ModelAndView("/login");
		} else {
			return new ModelAndView("redirect:home.html");

		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processCustomerLogin(@Valid Customer customer, BindingResult result, Map<?, ?> model, HttpSession session) {
		loginValidator.validate(customer, result);
		if (result.hasErrors()) {
			return new ModelAndView("/login");
		}
		List<Customer> customerlist = customerService.getCustomerByCustomerEmail(customer.getEmailAddress());
		if (customerlist != null && customerlist.size() > 0) {
			Customer customer1 = new Customer();
			customer1 = (Customer) customerlist.get(0);
			session.setAttribute("fullName", customer1.getFullName());
		}
		session.setAttribute("emailAddress", customer.getEmailAddress());
		return new ModelAndView("redirect:home.html");

	}

}
