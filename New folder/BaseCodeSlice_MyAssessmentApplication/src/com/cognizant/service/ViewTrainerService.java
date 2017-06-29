package com.cognizant.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ViewTrainerDao;
import com.cognizant.entity.TrainerInfo;
import com.cognizant.entity.TrainerSchedule;

@Component @Transactional
public class ViewTrainerService {
	@Autowired
	ViewTrainerDao viewtrainers;
	
	public List<TrainerSchedule> viewTrainerServiceMethod(Date date)
	{
		List<TrainerSchedule> trainers=viewtrainers.viewTrainerDao(date);
		
		return trainers;
	}

}
