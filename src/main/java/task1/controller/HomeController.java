package task1.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import task1.model.Customer;


@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showSearchQuestion(Map model, HttpSession session) {
		if ((session.getAttribute("adminEmail")) == null) {
			Customer customer = new Customer();
			model.put("customer", customer);
			return "/home";
		}
		return "/home";
		
	}
		

}

