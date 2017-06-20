package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;

@Component
public class ApplyEducationLoanDAO {

	static Logger logger = Logger.getLogger(ApplyEducationLoanDAO.class);
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insertEducationLoanDetails(UserDetails ud) {

		em.persist(ud);

	}

	@Transactional
	public UserDetails getUserDetails(long accountNumber) {

		logger.warn("Account Number is : " + accountNumber);
		UserDetails user = em.find(UserDetails.class, accountNumber);
		logger.debug(user);

		return user;

	}

}