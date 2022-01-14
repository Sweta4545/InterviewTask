package task1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import task1.model.Customer;

@Repository
public interface CustomerDao {
	
	public List<Customer> listCustomer();

	public void saveCustomer(Customer customer);
	
	public List<Customer> validateLoginCustomer(String emailAddress, String password);

	public List<Customer> getCustomerByCustomerEmail(String emailAddress);
	
	

}
