package com.cognizant.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.TrainerInfo;
import com.cognizant.entity.TrainerSchedule;
import com.cognizant.service.ViewTrainerService;

@Controller
public class ViewTrainerController {
	
	@Autowired
	ViewTrainerService viewTrainerService;
	@RequestMapping(value = "/viewtrainer", method = RequestMethod.GET)
	public String viewTrainerDetails(Model model) {
		model.addAttribute("TrainerSchedule",new TrainerSchedule());
       
		return "View";
	}
	
	@RequestMapping(value = "/viewtrainer1", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TrainerSchedule> viewTrainerDetails1(@RequestParam("startDate") String startDate,Model model) {
		
		
		 System.out.println("hi this is the year 1");
		 
		
		java.sql.Date dat = java.sql.Date.valueOf(startDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dat);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		
		List<TrainerSchedule> trainers=  viewTrainerService.viewTrainerServiceMethod(dat);
		List<TrainerSchedule> trainers1 = new ArrayList<TrainerSchedule>();
		for(int i=0;i<trainers.size();i++)
		{
			TrainerSchedule trainerSchedule1 = trainers.get(i);
			 trainerSchedule1.getTrainer().setSchedule(null);
			trainers1.add(trainerSchedule1);
		}
        
       System.out.println("hi this is the year 2 " +year);
       System.out.println("here is the list of schedule with trainers info"+trainers1);
		return trainers1;
	}

}
