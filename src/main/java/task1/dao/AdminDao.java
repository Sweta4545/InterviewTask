package task1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import task1.model.Admin;

@Repository
public interface AdminDao {
	
	public List<Admin> listAdmin();

	public void saveAdmin(Admin admin);
	
	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
}