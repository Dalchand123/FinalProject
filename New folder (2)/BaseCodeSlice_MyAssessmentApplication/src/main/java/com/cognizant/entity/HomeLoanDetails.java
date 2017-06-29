package com.cognizant.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class HomeLoanDetails {
	
	@Column(name="HOME_LOAN_ID")
	private String homeLoanId;
	@Id @Column(name="HOME_LOAN_ACCOUNT_NUMBER")
	private String homeLoanAccountNumber;

	@Range(min = 1, max = 999999999999999l, message = "Please enter valid amount.")
	@NumberFormat(style = Style.NUMBER) @Column(name="LOAN_AMOUNT")
	private long loanAmount;

	@Column(name="LOAN_APPLY_DATE")
	private Date loanApplyDate;
	@Range(min = 1, max = 999999999999999l, message = "Please enter valid income.") @Column(name="ANNUAL_INCOME")
	private long annualIncome;
	@NotEmpty(message = "Company name should not be empty")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Only Alphabets are allowed.") @Column(name="COMPANY_NAME")
	private String companyName;
	@NotEmpty(message = "Designation can not be empty.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Only Alphabets are allowed.") @Column(name="DESIGNATION")
	private String designation;
	@Range(min = 1, max = 99, message = "Please enter valid experience years.") @Column(name="TOTAL_EXP")
	int totalExp;
	@Range(min = 1, max = 99, message = "Please enter valid experience years.") @Column(name="EXP_CURRENT_COMPANY")
	int expCurrentDate;
	@Column(name="LOAN_DURATION")
	int loanDuration;
	private transient long accountNumber;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private UserDetails user;

	public HomeLoanDetails() {

	}

	public HomeLoanDetails(String homeLoanId, String homeLoanAccountNumber, long loanAccount, Date loanApplyDate,
			long annualIncome, String companyName, String designation, int totalExp, int expCurrentDate,
			int loanDuration) {
		super();
		this.homeLoanId = homeLoanId;
		this.homeLoanAccountNumber = homeLoanAccountNumber;
		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.loanDuration = loanDuration;
	}

	public HomeLoanDetails(long loanAccount, Date loanApplyDate, long annualIncome, String companyName,
			String designation, int totalExp, int expCurrentDate, UserDetails user, int loanDuration) {
		// TODO Auto-generated constructor stub
		super();

		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.loanDuration = loanDuration;
		this.user = user;

	}

	public HomeLoanDetails(long loanAccount, Date loanApplyDate, long annualIncome, String companyName,
			String designation, int totalExp, int expCurrentDate, int loanDuration) {

		super();

		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.loanDuration = loanDuration;

	}

	public HomeLoanDetails(String homeLoanId, String homeLoanAccountNumber, long loanAmount, Date loanApplyDate,
			long annualIncome, String companyName, String designation, int totalExp, int expCurrentDate,
			UserDetails user, int loanDuration) {
		super();
		this.homeLoanId = homeLoanId;

		this.homeLoanAccountNumber = homeLoanAccountNumber;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.user = user;
		this.loanDuration = loanDuration;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public String getHomeLoanAccountNumber() {
		return homeLoanAccountNumber;
	}

	public void setHomeLoanAccountNumber(String homeLoanAccountNumber) {
		this.homeLoanAccountNumber = homeLoanAccountNumber;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAccount) {
		this.loanAmount = loanAccount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	public int getExpCurrentDate() {
		return expCurrentDate;
	}

	public void setExpCurrentDate(int expCurrentDate) {
		this.expCurrentDate = expCurrentDate;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "HomeLoanDetails [homeLoanId=" + homeLoanId + ", homeLoanAccountNumber=" + homeLoanAccountNumber
				+ ", loanAmount=" + loanAmount + ", loanApplyDate=" + loanApplyDate + ", annualIncome=" + annualIncome
				+ ", companyName=" + companyName + ", designation=" + designation + ", totalExp=" + totalExp
				+ ", expCurrentDate=" + expCurrentDate + ", loanDuration=" + loanDuration + "]";
	}

}
