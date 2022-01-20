package task1.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import task1.model.Account;
import task1.model.Admin;
import task1.model.Customer;
import task1.service.AccountService;
import task1.service.CustomerService;
import task1.validators.CustomerForm;
import task1.validators.LoginValidator;
import task1.validators.RegisterValidator;

@Controller
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	@Autowired
	RegisterValidator registerValidater;
	@Autowired
	private LoginValidator loginValidator;

	@RequestMapping(value = "/customer/customerLogin", method = RequestMethod.GET)
	public ModelAndView showCustomerLogin(Map<String, Customer> model, HttpSession session) {
		if (session.getAttribute("emailAddress") == null) {
			Customer customer = new Customer();
			model.put("customer", customer);
			return new ModelAndView("/customer/customerLogin");
		} else {
			return new ModelAndView("redirect:customerHome.html");

		}
	}
	
	@RequestMapping(value = "/customer/customerLogin", method = RequestMethod.POST)
	public ModelAndView processCustomerLogin(@Valid Customer customer, BindingResult result, Map<?, ?> model, HttpSession session) {
		loginValidator.customerValidate(customer, result);
		if (result.hasErrors()) {
			return new ModelAndView("/customer/customerLogin");
		}
		List<Customer> cutomerList = customerService.getCustomerByCustomerEmail(customer.getEmailAddress());
		if (cutomerList != null && cutomerList.size() > 0) {
			Customer customer2 = new Customer();
			customer2 = (Customer) cutomerList.get(0);
			session.setAttribute("fullName", customer2.getFullName());
		}
		session.setAttribute("emailAddress", customer.getEmailAddress());
		return new ModelAndView("redirect:customerHome.html");

	}

	
	@RequestMapping(value = "/customer/customerLogout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:customerLogin.html");
	}
	
	@RequestMapping(value = "/customer/customerRegister", method = RequestMethod.GET)
	public String showCustomerLogin(Map<String, CustomerForm> model) {
		CustomerForm customerForm = new CustomerForm();
		model.put("customerForm", customerForm);
		return "/customer/customerRegister";
	}

	@RequestMapping(value = "/customer/customerRegister", method = RequestMethod.POST)
	public ModelAndView processCustomerLogin(@Valid CustomerForm customerForm, BindingResult result, Map<?, ?> model) {
		registerValidater.customerValidate(customerForm, result);

		if (result.hasErrors()) {
			return new ModelAndView("/customer/customerRegister");
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
		return new ModelAndView("redirect:customerLogin.html");
	}
	
	@RequestMapping(value = "/customer/customerHome", method = RequestMethod.GET)
	public ModelAndView showCustomerHome(Customer customer, HttpServletRequest request, HttpSession session, Map<String, List<Customer>> model, Map<String, List<Account>> model1) {
		if ((session.getAttribute("emailAddress")) == null) {
			return new ModelAndView("redirect:customerLogin.html");
			
		}
		
		List<Customer> customerList = customerService.getCustomerByCustomerEmail((String)session.getAttribute("emailAddress"));
		
		/*Customer currentCustomer = (Customer) session.getAttribute("emailAddress");
		int currCustomerId = currentCustomer.getCustomerId();

		List<Account> customerList1 = accountService.getAccountByCustomerId(currCustomerId);*/
		
		model.put("customerList", customerList);
		//model1.put("customerList1", customerList1);
		return new ModelAndView("customer/customerHome");
	}

}
