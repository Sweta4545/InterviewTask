package task1.controller;

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

import task1.model.Admin;
import task1.model.Account;

import task1.service.AccountService;
import task1.validators.AccountForm;

@Controller
public class AccountController {
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping(value="/admin/addAccount", method = RequestMethod.GET)
	public String showAddAccount(Map<String, Object> model, HttpServletRequest request, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return "/admin/adminLogin";
		}
		AccountForm accountForm = new AccountForm();
		
		// if fined questionId then edit Question
		if (request.getParameter("accountId") != null) {
			Long accountId = Long.parseLong(request.getParameter("accountId"));
			List<Account> accountlist = accountService.getAccountByAccountId(accountId);
			if (accountlist != null && accountlist.size() > 0) {
				Account account = (Account) accountlist.get(0);
				accountForm.setAccountId(account.getAccountId());
				accountForm.setAccountNumber(account.getAccountNumber());
				accountForm.setAccountOpenDate(account.getAccountOpenDate());
				accountForm.setAccountCloseDate(account.getAccountCloseDate());
				accountForm.setBalance(account.getBalance());
				accountForm.setAccountType(account.getAccountType());
				accountForm.setCustomerId(account.getCustomerId());

			}
				
		}
		model.put("accountForm", accountForm);
		return "/admin/addAccount";
	}

	@RequestMapping(value="/admin/addAccount", method = RequestMethod.POST)
	public ModelAndView processAddAccount(@Valid AccountForm accountForm, BindingResult result,
			Map<String, Object> model, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminLogin.html");
		}
		
		
			Account account = new Account();
			account.setAccountNumber(accountForm.getAccountNumber());
			account.setAccountOpenDate(accountForm.getAccountOpenDate());
			account.setAccountCloseDate(accountForm.getAccountCloseDate());
			account.setBalance(accountForm.getBalance());
			account.setAccountType(accountForm.getAccountType());
			account.setCustomerId(accountForm.getCustomerId());


			
			if (accountForm.getAccountId() == null) {
				accountService.saveAccount(account);

			} 
			else {
				
				// update Question and Answer
				account.setAccountId(accountForm.getAccountId());
				accountService.updateAccount(account);
				}
			

		return new ModelAndView("redirect:adminHome.html");
	}
	
	@RequestMapping(value = "/admin/deleteAccount", method = RequestMethod.GET)
	public ModelAndView deleteAccount(Map<String, Object> model, HttpServletRequest request, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminLogin.html");
		}
		String accountIdInString = request.getParameter("accountId");
		if (accountIdInString != null && (!accountIdInString.equals(""))) {
			Account account = new Account();
			account.setAccountId(Long.parseLong(accountIdInString));
			accountService.deleteAccount(account);
		}
		return new ModelAndView("redirect:adminHome.html");
	}
	

	

	
	
}
