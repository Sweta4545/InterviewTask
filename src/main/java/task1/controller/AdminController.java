package task1.controller;

import java.util.ArrayList;
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
import task1.service.AccountService;
import task1.service.AdminService;
import task1.validators.AccountC;
import task1.validators.AdminForm;
import task1.validators.LoginValidator;
import task1.validators.RegisterValidator;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	RegisterValidator registerValidater;
	

	@RequestMapping(value = "/admin/adminLogin", method = RequestMethod.GET)
	public ModelAndView showAdminLogin(Map<String, Admin> model, HttpSession session) {
		if (session.getAttribute("adminEmail") == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return new ModelAndView("/admin/adminLogin");
		} else {
			return new ModelAndView("redirect:adminHome.html");

		}
	}

	@RequestMapping(value = "/admin/adminLogin", method = RequestMethod.POST)
	public ModelAndView processAdminLogin(@Valid Admin admin, BindingResult result, Map<?, ?> model, HttpSession session) {
		loginValidator.adminValidate(admin, result);
		if (result.hasErrors()) {
			return new ModelAndView("/admin/adminLogin");
		}
		List<Admin> adminlist = adminService.getAdminByAdminEmail(admin.getAdminEmail());
		if (adminlist != null && adminlist.size() > 0) {
			Admin admin1 = new Admin();
			admin1 = (Admin) adminlist.get(0);
			session.setAttribute("adminName", admin1.getAdminName());
		}
		session.setAttribute("adminEmail", admin.getAdminEmail());
		return new ModelAndView("redirect:adminHome.html");

	}
	
	@RequestMapping(value = "/admin/adminLogout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:adminLogin.html");
	}
	
	@RequestMapping(value = "/admin/adminRegister", method = RequestMethod.GET)
	public String showAdminLogin(Map<String, AdminForm> model) {
		AdminForm adminForm = new AdminForm();
		model.put("adminForm", adminForm);
		return "/admin/adminRegister";
	}

	@RequestMapping(value = "/admin/adminRegister", method = RequestMethod.POST)
	public ModelAndView processAdminLogin(@Valid AdminForm adminForm, BindingResult result, Map<?, ?> model) {
		registerValidater.adminValidate(adminForm, result);

		if (result.hasErrors()) {
			return new ModelAndView("/admin/adminRegister");
		} else {

			Admin admin = new Admin();
			admin.setAdminName(adminForm.getAdminName());
			admin.setAdminEmail(adminForm.getAdminEmail());
			admin.setPassword(adminForm.getPassword());
			admin.setAdminGender(adminForm.getAdminGender());
			admin.setPhoneNo(adminForm.getPhoneNo());
			admin.setAddress(adminForm.getAddress());

			adminService.saveAdmin(admin);
		}
		return new ModelAndView("redirect:adminLogin.html");
	}
	
	@RequestMapping(value = "/admin/adminHome", method = RequestMethod.GET)
	public ModelAndView showAdminHome(HttpServletRequest request, HttpSession session, Map<String, List<Account>> model) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminLogin.html");
		}
		
		List allAccountList = new ArrayList();
		List accountList = new ArrayList();

		accountList = accountService.listAccount();
	
		for (int i = 0; i < accountList.size(); i++) {
			AccountC accountC = new AccountC();
			List accountOptionsList = new ArrayList();
			Account account = new Account();
			account = (Account) accountList.get(i);
			accountC.setAccountId(account.getAccountId());
			accountC.setAccountNumber(account.getAccountNumber());
			accountC.setAccountOpenDate(account.getAccountOpenDate());
			accountC.setAccountCloseDate(account.getAccountCloseDate());
			accountC.setBalance(account.getBalance());
			accountC.setAccountType(account.getAccountType());
			accountC.setCustomer(account.getCustomer());


		
			allAccountList.add(accountC);
		}
		model.put("allAccountList", allAccountList);
		return new ModelAndView("admin/adminHome");
	
		
	}
	

}
