package task1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import task1.model.Admin;

@Service
public interface AdminService {

	public List<Admin> listAdmin();

	public void saveAdmin(Admin admin);

	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
}