package task1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import task1.model.Customer;

@Service
public interface CustomerService {
	
	public List<Customer> listCustomer();

	public void saveCustomer(Customer customer);

	public List<Customer> validateLoginCustomer(String emailaddress, String password);

	public List<Customer> getCustomerByCustomerEmail(String emailAddress);

}