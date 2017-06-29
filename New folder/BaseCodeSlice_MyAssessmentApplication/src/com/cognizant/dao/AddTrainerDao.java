package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cognizant.entity.TrainerInfo;
import com.cognizant.entity.TrainerSchedule;


@Component
public class AddTrainerDao {
	
	@PersistenceContext
	private EntityManager em;
	public void addTrainerDao(TrainerSchedule trainerSchedule)
	{
		em.persist(trainerSchedule);
	}
	
	public TrainerInfo viewTrainerDao(long trainerId)
	{
		
		  TrainerInfo trainer1 =  em.find(TrainerInfo.class, trainerId);
		  return trainer1;
	}
	

}
