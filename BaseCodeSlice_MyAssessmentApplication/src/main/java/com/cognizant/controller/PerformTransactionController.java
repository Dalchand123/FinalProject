package com.cognizant.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.exception.BankManagementException;
import com.cognizant.service.PerformTransactionService;

@Controller
public class PerformTransactionController {

	@Autowired
	PerformTransactionService service;

	static Logger logger = Logger.getLogger(PerformTransactionController.class);

	@RequestMapping(value = "/performtransaction/{accountNumber}", method = RequestMethod.GET)
	public String getTransaction(@PathVariable("accountNumber") String accountNumber, Model model) {
		model.addAttribute("TransactionDetails", new TransactionDetails());
		model.addAttribute("accountNumber", accountNumber);
		return "PerformTransaction";
	}

	@RequestMapping(value = "/performtransaction/{accountNumber}", method = RequestMethod.POST)
	public String performTransaction1(@ModelAttribute("TransactionDetails") @Valid TransactionDetails transaction,
			BindingResult result, @PathVariable("accountNumber") String accountNumber, Model model) {

		transaction.setAccountNumber(Long.parseLong(accountNumber));
		logger.debug(transaction);
		long acc = transaction.getAccountNumber();
		try {
			service.performTransaction(acc, transaction);

		} catch (ConstraintViolationException e) {

			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				logger.error("Validation message: " + next.getMessage());
				logger.error("Invalid field: " + next.getPropertyPath());
				logger.error("Validation class/bean: " + next.getRootBean());

				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());

			}
		} catch (BankManagementException e) {

			String msg = e.getMessage();
			String[] arr = msg.split(":");
			result.rejectValue(arr[0], "", e.getMessage());
		}

		if (result.hasErrors()) {
			return "PerformTransaction";

		}

		model.addAttribute("m1", transaction.getTransactionId());
		return "member";

	}

	@ModelAttribute("transactionTypeList")
	public Map<String, String> gettransactionTypeList() {
		Map<String, String> transactionTypeList = new HashMap<String, String>();
		transactionTypeList.put("deposit", " deposit");
		transactionTypeList.put("withdrawal", "withdrawal");

		return transactionTypeList;
	}

}
