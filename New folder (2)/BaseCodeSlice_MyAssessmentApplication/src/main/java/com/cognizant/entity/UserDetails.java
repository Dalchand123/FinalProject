package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity

public class UserDetails {
	@Id @Column(name="ACCOUNT_NUMBER")
	long accountNumber;
	@Column(name="ACCOUNT_TYPE")
	String accountType;
	@Column(name="ACCOUNT_HOLDER_NAME")
	String accountHolderName;
	@Column(name="ACCOUNT_BALANCE")
	Double accountBalance;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Fetch(FetchMode.SELECT)
	List<HomeLoanDetails> homeloan;

	

	

	

	public UserDetails() {
	}

	public UserDetails(long accountNumber, String accountType, String accountHolderName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public UserDetails(long accountNumber, String accountType, String accountHolderName, Double accountBalance,
			List<HomeLoanDetails> homeloan) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.homeloan = homeloan;
	}

	

	

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<HomeLoanDetails> getHomeloan() {
		return homeloan;
	}

	public void setHomeloan(List<HomeLoanDetails> homeloan) {
		this.homeloan = homeloan;
	}

	

	

	



	@Override
	public String toString() {
		return "UserDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", accountBalance=" + accountBalance + "]";
	}

}
