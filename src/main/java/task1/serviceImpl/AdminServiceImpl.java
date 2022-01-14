package task1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task1.dao.AdminDao;
import task1.model.Admin;
import task1.service.AdminService;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public List<Admin> validateLoginAdmin(String adminEmail, String password) {
		return adminDao.validateLoginAdmin(adminEmail, password);
	}

	public List<Admin> getAdminByAdminEmail(String adminEmail) {
		return adminDao.getAdminByAdminEmail(adminEmail);
	}

	public List<Admin> listAdmin() {
		return adminDao.listAdmin();

	}

	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
		
	}
}