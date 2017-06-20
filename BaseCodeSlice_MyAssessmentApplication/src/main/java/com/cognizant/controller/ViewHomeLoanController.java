package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewHomeLoanService;

@Controller
public class ViewHomeLoanController {

	UserDetails user = new UserDetails();

	@Autowired
	ViewHomeLoanService viewHome;

	static Logger logger = Logger.getLogger(ViewHomeLoanController.class);

	@RequestMapping(value = "/viewuserhomeloandetails1/{accountNumber}", method = RequestMethod.GET)
	public String getHomeLoanDetails(Model model, @PathVariable("accountNumber") String accountNumber) {
		model.addAttribute("accountNumber", accountNumber);
		return "ViewHomeLoan";
	}

	@RequestMapping(value = "viewuserhomeloandetails1/viewuserhomeloandetails/{accountNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserDetails> getEmployees(Model model,
			@PathVariable("accountNumber") String accountNumber) {

		
		long l = Long.parseLong(accountNumber);
		user = viewHome.retrieveUserHomeLoanDetails(l);
		user.setHld(null);
		user.setTrans(null);

		List<UserDetails> user1 = new ArrayList<UserDetails>();
		List<HomeLoanDetails> home = new ArrayList<HomeLoanDetails>();
		List<HomeLoanDetails> home1 = user.getHomeloan();

		for (int i = 0; i < home1.size(); i++) {
			HomeLoanDetails hm = null;
			hm = home1.get(i);
			hm.setUser(null);
			home.add(hm);

		}
		user.setHomeloan(home);
		user1.add(user);

		return user1;
	}

}
