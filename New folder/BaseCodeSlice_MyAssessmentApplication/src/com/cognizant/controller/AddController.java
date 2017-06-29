package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.entity.TrainerSchedule;
import com.cognizant.service.AddTrainerService;



@Controller
public class AddController {
	
	@Autowired		
	  AddTrainerService addtrainer;
	
	
	@RequestMapping(value = "/addtrainer", method = RequestMethod.GET)
	public String getTrainerDetails( Model model) {
		model.addAttribute("TrainerSchedule",new TrainerSchedule());
       
		return "Apply";
	}
	
	@RequestMapping(value = "/savetrainer", method = RequestMethod.POST)
	public String saveTrainerDetails(@ModelAttribute("TrainerSchedule") TrainerSchedule trainer, BindingResult result, Model model) {
		
    System.out.println(trainer);
  
    addtrainer.addTrainer(trainer);
  
		return "success";
	}

}
