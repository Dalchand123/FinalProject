package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;

@Component
public class ViewHomeLoanDAO {
	@PersistenceContext
	private EntityManager em;

	static Logger logger = Logger.getLogger(ViewHomeLoanDAO.class);

	UserDetails user = new UserDetails();

	@Transactional
	public UserDetails retrieveUserHomeLoanDetails(long accountNumber) {

		UserDetails home = em.find(UserDetails.class, accountNumber);

		logger.debug("User details in ViewHomeLoanDAO are :" + home);

		return home;
	}

}
