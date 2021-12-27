package task1.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import task1.dao.CustomerDao;
import task1.model.Customer;


@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Customer> validateLoginCustomer(String emailAddress, String password) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Customer where emailAddress=:emailAddress and password=:password")
				.setString("emailAddress", emailAddress).setString("password", password).list();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByCustomerEmail(String emailAddress) {
		return sessionFactory.getCurrentSession().createQuery("from Customer where emailAddress=:emailAddress")
				.setParameter("emailAddress", emailAddress).list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Customer> listCustomer() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();

	}

	public void saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

}
