package task1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import task1.model.Customer;

@Repository
public interface CustomerDao {
	
	public List<Customer> listCustomer();

	public void saveCustomer(Customer customer);
	
	public List<Customer> validateLoginCustomer(String emailAddress, String password);

	public List<Customer> getCustomerByCustomerEmail(String emailAddress);
	
	

}
