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

import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewEducationLoanService;

@Controller
public class ViewEducationLoanController {

	@Autowired
	ViewEducationLoanService service;

	static Logger logger = Logger.getLogger(ViewEducationLoanController.class);

	@RequestMapping(value = "/viewLoan/{accountNumber}", method = RequestMethod.GET)
	public String getJsp(Model model, @PathVariable("accountNumber") String accountNumber) {

		model.addAttribute("accountNumber", accountNumber);
		return "ViewEducationLoan";
	}

	@RequestMapping(value = "viewLoan/viewEducationLoanDetails/{accountNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserDetails> getEmployees(Model model,
			@PathVariable("accountNumber") String accountNumber) {

		long l = Long.parseLong(accountNumber);
		UserDetails user = new UserDetails();
		user = service.retrieveEducationLoanDetails(l);
		user.setHomeloan(null);
		user.setTrans(null);
		logger.debug("User details in ViewEducationLoanController :" + user);

		List<EducationLoanDetails> list = user.getHld();
		List<EducationLoanDetails> newList = new ArrayList<EducationLoanDetails>();
		List<UserDetails> li = new ArrayList<UserDetails>();
		for (int i = 0; i < list.size(); i++) {
			EducationLoanDetails eld = null;
			eld = list.get(i);
			eld.setUser(null);
			newList.add(eld);
		}

		user.setHld(newList);
		li.add(user);
		logger.debug("list of User details in ViewEducationLoanController is :" + li);
		return li;
	}

}
