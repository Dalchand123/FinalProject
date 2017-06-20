package com.cognizant.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class EducationLoanDetails {

	private String educationLoanId;
	@Id
	private String eduLoanAccountNumber;

	@Range(min = 1, max = 999999999999999l, message = "Please enter valid amount.")
	private long eduLoanAmount;
	private Date eduLoanApplyDate;
	@Range(min = 1, max = 10, message = "Please enter valid Duration.")
	private int eduLoanDuration;
	@Range(min = 1, max = 2000000, message = "Please enter valid Annual Income.")
	private long fatherAnnualIncome;
	@Range(min = 1, max = 999999999999999l, message = "Please enter valid Course fee.")
	private int courseFee;
	@NotEmpty(message = "Course name can not be empty.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Only Alphabets are allowed.")
	private String courseName;
	@NotEmpty(message = "Father's name can not be empty.")

	private String fatherName;

	@Range(min = 16, message = "ID card number can not be empty.")
	private long idNumber;
	private transient long accountNumber;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private UserDetails user;

	public EducationLoanDetails(String educationLoanId, String eduLoanAccountNumber, long eduLoanAmount,
			Date eduLoanApplyDate, int eduLoanDuration, long fatherAnnualIncome, int courseFee, String courseName,
			UserDetails user, String fatherName, long idNumber) {
		super();
		this.educationLoanId = educationLoanId;

		this.eduLoanAccountNumber = eduLoanAccountNumber;
		this.eduLoanAmount = eduLoanAmount;
		this.eduLoanApplyDate = eduLoanApplyDate;
		this.eduLoanDuration = eduLoanDuration;
		this.fatherAnnualIncome = fatherAnnualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.user = user;
		this.fatherName = fatherName;
		this.idNumber = idNumber;
	}

	public EducationLoanDetails(long eduLoanAmount, Date eduLoanApplyDate, int eduLoanDuration, long fatherAnnualIncome,
			int courseFee, String courseName, String fatherName, long idNumber) {
		super();

		this.eduLoanAmount = eduLoanAmount;
		this.eduLoanApplyDate = eduLoanApplyDate;
		this.eduLoanDuration = eduLoanDuration;
		this.fatherAnnualIncome = fatherAnnualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idNumber = idNumber;
	}

	public EducationLoanDetails() {

	}

	public EducationLoanDetails(String educationLoanId, String eduLoanAccountNumber, long eduLoanAmount,
			Date eduLoanApplyDate, int eduLoanDuration, long fatherAnnualIncome, int courseFee, String courseName,
			String fatherName, long idNumber) {
		super();
		this.educationLoanId = educationLoanId;

		this.eduLoanAccountNumber = eduLoanAccountNumber;
		this.eduLoanAmount = eduLoanAmount;
		this.eduLoanApplyDate = eduLoanApplyDate;
		this.eduLoanDuration = eduLoanDuration;
		this.fatherAnnualIncome = fatherAnnualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idNumber = idNumber;
	}

	public String getEducationLoanId() {
		return educationLoanId;
	}

	public void setEducationLoanId(String educationLoanId) {
		this.educationLoanId = educationLoanId;
	}

	public String getEduLoanAccountNumber() {
		return eduLoanAccountNumber;
	}

	public void setEduLoanAccountNumber(String eduLoanAccountNumber) {
		this.eduLoanAccountNumber = eduLoanAccountNumber;
	}

	public long getEduLoanAmount() {
		return eduLoanAmount;
	}

	public void setEduLoanAmount(long eduLoanAmount) {
		this.eduLoanAmount = eduLoanAmount;
	}

	public Date getEduLoanApplyDate() {
		return eduLoanApplyDate;
	}

	public void setEduLoanApplyDate(Date eduLoanApplyDate) {
		this.eduLoanApplyDate = eduLoanApplyDate;
	}

	public int getEduLoanDuration() {
		return eduLoanDuration;
	}

	public void setEduLoanDuration(int eduLoanDuration) {
		this.eduLoanDuration = eduLoanDuration;
	}

	public long getFatherAnnualIncome() {
		return fatherAnnualIncome;
	}

	public void setFatherAnnualIncome(long fatherAnnualIncome) {
		this.fatherAnnualIncome = fatherAnnualIncome;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "EducationLoanDetails [educationLoanId=" + educationLoanId + ", eduLoanAccountNumber="
				+ eduLoanAccountNumber + ", eduLoanAmount=" + eduLoanAmount + ", eduLoanApplyDate=" + eduLoanApplyDate
				+ ", eduLoanDuration=" + eduLoanDuration + ", fatherAnnualIncome=" + fatherAnnualIncome + ", courseFee="
				+ courseFee + ", courseName=" + courseName + ", fatherName=" + fatherName + ", idNumber=" + idNumber
				+ "]";
	}

}
