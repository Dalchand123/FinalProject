package com.cognizant.controller;

import java.util.Iterator;
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

import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.exception.BankManagementException;
import com.cognizant.service.ApplyEducationLoanService;

@Controller
public class ApplyEducationLoanController {

	@Autowired
	ApplyEducationLoanService service;

	static Logger logger = Logger.getLogger(ApplyEducationLoanController.class);

	@RequestMapping(value = "/applyLoan/{accountNumber}", method = RequestMethod.GET)
	public String getEducationLoanDetails(@PathVariable("accountNumber") String accountNumber, Model model) {
		model.addAttribute("EducationLoanDetails", new EducationLoanDetails());
		model.addAttribute("accountNumber", accountNumber);
		return "ApplyEducationLoan";
	}

	@RequestMapping(value = "/applyLoan/{accountNumber}", method = RequestMethod.POST)
	public String initiateEducationLoanDetails(
			@ModelAttribute("EducationLoanDetails") @Valid EducationLoanDetails educationLoanDetails,

			BindingResult result, Model model, @PathVariable("accountNumber") String accountNumber) {

		educationLoanDetails.setAccountNumber(Long.parseLong(accountNumber));
		boolean flag = true;

		logger.debug("Education Loan Details in EducationLoanController in saveOrUpdateEmployee method is :"
				+ educationLoanDetails);

		try {

			service.insertEducationLoanDetails(educationLoanDetails);
		} catch (ConstraintViolationException e) {
			flag = false;

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
			flag = false;

			String msg = e.getMessage();
			String arr[] = msg.split(":");
			logger.error("Validation message: " + e.getMessage());
			result.rejectValue(arr[0], "", arr[1]);

		}

		if (result.hasErrors()) {
			return "ApplyEducationLoan";
		}
		if (flag == false) {
			return "ApplyEducationLoan";
		} else {
			model.addAttribute("loanId", educationLoanDetails.getEducationLoanId());
			model.addAttribute("loanAccountNumber", educationLoanDetails.getEduLoanAccountNumber());

			return "EducationSuccess";
		}
	}
}
