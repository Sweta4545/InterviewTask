package task1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task1.dao.CustomerDao;
import task1.model.Customer;
import task1.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> validateLoginCustomer(String emailAddress, String password) {
		return customerDao.validateLoginCustomer(emailAddress, password);
	}

	public List<Customer> getCustomerByCustomerEmail(String emailAddress) {
		return customerDao.getCustomerByCustomerEmail(emailAddress);
	}

	public List<Customer> listCustomer() {
		return customerDao.listCustomer();

	}

	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

}
