package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;

@Component
public class ApplyHomeLoanDAO {

	@PersistenceContext
	private EntityManager em;
	static Logger logger = Logger.getLogger(ApplyHomeLoanDAO.class);

	@Transactional
	public boolean applyHomeLoanUserDetails(UserDetails ud) {
		logger.debug("In ApplyHomeLoanDAO in applyHomeLoanUserDetails method  ");
		em.persist(ud);

		return true;
	}

	public UserDetails gettHomeLoanUserDetails(long accountNumber) {

		UserDetails ud = em.find(UserDetails.class, accountNumber);
		return ud;

	}

}
