package com.cognizant.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TrainerInfo {
	
	@Id
	private long trainerId;
	private String trainerName;
	private String collegeName;
	private String domain;
	
	@OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<TrainerSchedule>schedule;
	
	
	public TrainerInfo() {
		super();
	}


	public TrainerInfo(long trainerId, String trainerName, String collegeName, String domain) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.collegeName = collegeName;
		this.domain = domain;
	}


	public TrainerInfo(long trainerId, String trainerName, String collegeName, String domain,
			List<TrainerSchedule> schedule) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.collegeName = collegeName;
		this.domain = domain;
		this.schedule = schedule;
	}


	public long getTrainerId() {
		return trainerId;
	}


	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}


	public String getTrainerName() {
		return trainerName;
	}


	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}


	public List<TrainerSchedule> getSchedule() {
		return schedule;
	}


	public void setSchedule(List<TrainerSchedule> schedule) {
		this.schedule = schedule;
	}


	@Override
	public String toString() {
		return "TrainerInfo [trainerId=" + trainerId + ", trainerName=" + trainerName + ", collegeName=" + collegeName
				+ ", domain=" + domain + "]";
	}


	
	

}
