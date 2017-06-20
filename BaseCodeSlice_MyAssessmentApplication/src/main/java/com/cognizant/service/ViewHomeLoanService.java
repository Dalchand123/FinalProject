package com.cognizant.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ViewHomeLoanDAO;
import com.cognizant.entity.UserDetails;

@Component

public class ViewHomeLoanService {

	UserDetails user = new UserDetails();
	@Autowired
	ViewHomeLoanDAO getHomeLoanDetails;

	static Logger logger = Logger.getLogger(ViewHomeLoanService.class);

	@Transactional
	public UserDetails retrieveUserHomeLoanDetails(long accountNumber) {
		user = getHomeLoanDetails.retrieveUserHomeLoanDetails(accountNumber);

		return user;
	}

}
