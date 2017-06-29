package com.cognizant.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TrainerSchedule {
	
	
	
	 private int duration;
	 private Date startDate;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduledId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerId")
	private TrainerInfo trainer;
	
	public TrainerSchedule() {
		super();
	}

	public TrainerSchedule(int duration, Date startDate, int scheduledId, TrainerInfo trainer) {
		super();
		this.duration = duration;
		this.startDate = startDate;
		this.scheduledId = scheduledId;
		this.trainer = trainer;
	}

	public TrainerSchedule(int duration, Date startDate, int scheduledId) {
		super();
		this.duration = duration;
		this.startDate = startDate;
		this.scheduledId = scheduledId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getScheduledId() {
		return scheduledId;
	}

	public void setScheduledId(int scheduledId) {
		this.scheduledId = scheduledId;
	}

	public TrainerInfo getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerInfo trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "TrainerSchedule [duration=" + duration + ", startDate=" + startDate + ", scheduledId=" + scheduledId
				+ ", trainer=" + trainer + "]";
	}

	
	
	
	
	

}
