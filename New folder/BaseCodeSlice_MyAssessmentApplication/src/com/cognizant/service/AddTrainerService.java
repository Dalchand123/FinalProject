package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.AddTrainerDao;

import com.cognizant.entity.TrainerInfo;
import com.cognizant.entity.TrainerSchedule;

@Component
@Transactional
public class AddTrainerService {
	@Autowired
	AddTrainerDao addTrainer;
	
	public void addTrainer(TrainerSchedule trainerSchedule)
	{
		
		TrainerInfo trainer = trainerSchedule.getTrainer();
		long trainerId = trainer.getTrainerId();
		TrainerInfo trainer1=addTrainer.viewTrainerDao(trainerId);
		
		
		if(trainer1!=null){
			System.out.println("hi hi 1");
			List<TrainerSchedule> list = trainer1.getSchedule();
			trainerSchedule.setTrainer(trainer1);
			list.add(trainerSchedule);
			trainer1.setSchedule(list);
			System.out.println("hi hi 2");
			
		}
		else{
			System.out.println("hi hi 3");
			addTrainer.addTrainerDao(trainerSchedule);
			System.out.println("hi hi 4");
		}
	}
	

}
