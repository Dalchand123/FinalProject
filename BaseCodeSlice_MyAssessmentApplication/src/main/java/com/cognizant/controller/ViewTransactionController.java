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

import com.cognizant.entity.TransactionDetails;
//import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.PerformTransactionService;

@Controller
public class ViewTransactionController {
	@Autowired
	PerformTransactionService service;

	static Logger logger = Logger.getLogger(ViewTransactionController.class);

	@RequestMapping(value = "/viewtransaction/{accountNumber}", method = RequestMethod.GET)
	public String getTransaction(Model model, @PathVariable("accountNumber") String accountNumber) {
		model.addAttribute("accountNumber", accountNumber);
		return "ViewTransaction";
	}

	@RequestMapping(value = "viewtransaction/transaction/{accountNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserDetails> getEmployees(Model model,
			@PathVariable("accountNumber") String accountNumber) {
		TransactionDetails obj3 = new TransactionDetails();

		UserDetails ud = new UserDetails();
		long l = Long.parseLong(accountNumber);
		ud = service.retriveDetails(l);
		ud.setHomeloan(null);
		ud.setHld(null);
		List<TransactionDetails> li1 = new ArrayList<TransactionDetails>();
		List<TransactionDetails> li2 = new ArrayList<TransactionDetails>();
		li1 = ud.getTrans();

		for (int i = 0; i < li1.size(); i++) {
			obj3 = null;
			obj3 = li1.get(i);
			obj3.setUser(null);
			li2.add(obj3);
		}
		ud.setTrans(li2);

		List<UserDetails> li = new ArrayList<UserDetails>();
		li.add(ud);

		return li;
	}

}
