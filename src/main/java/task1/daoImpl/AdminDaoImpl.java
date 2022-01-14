package task1.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import task1.dao.AdminDao;
import task1.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Admin> validateLoginAdmin(String adminEmail, String password) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Admin where adminEmail=:adminEmail and password=:password")
				.setString("adminEmail", adminEmail).setString("password", password).list();
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAdminByAdminEmail(String adminEmail) {
		return sessionFactory.getCurrentSession().createQuery("from Admin where adminEmail=:adminEmail")
				.setParameter("adminEmail", adminEmail).list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Admin> listAdmin() {
		return (List<Admin>) sessionFactory.getCurrentSession().createCriteria(Admin.class).list();

	}

	public void saveAdmin(Admin admin) {
		sessionFactory.getCurrentSession().saveOrUpdate(admin);
		
	}

}