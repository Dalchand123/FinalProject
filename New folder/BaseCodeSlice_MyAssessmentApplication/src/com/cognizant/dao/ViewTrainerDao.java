package com.cognizant.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.cognizant.entity.TrainerInfo;
import com.cognizant.entity.TrainerSchedule;

@Component
public class ViewTrainerDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<TrainerSchedule> viewTrainerDao(Date date)
	{
		
		 Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DAY_OF_MONTH, 7);
	        java.sql.Date date1 = new java.sql.Date(c.getTime().getTime()); 
	    
		Query query = em.createQuery("from TrainerSchedule t where t.startDate >=?  and t.startDate <=?  ");
		query.setParameter(1, date);
		query.setParameter(2, date1);
		List<TrainerSchedule> trainers = query.getResultList();
		  
		  return trainers;
	}
	

}
