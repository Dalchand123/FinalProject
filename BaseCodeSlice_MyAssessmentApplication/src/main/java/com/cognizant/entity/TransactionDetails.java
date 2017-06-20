package com.cognizant.entity;

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
public class TransactionDetails {
	@Id
	long transactionId;
	@NotEmpty(message = "Mandatory Field.")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Only Alphabets are allowed.")
	String transactionDescription;
	@NotEmpty(message = "Mandatory Field")
	String transactionType;

	@Range(min = 1, max = 999999999999999l, message = "Please enter valid amount.")
	double transactionAmount;
	private transient long accountNumber;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private UserDetails user;

	public TransactionDetails(long transactionId, String transactionDescription, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
	}

	public TransactionDetails(long transactionId, String transactionDescription, String transactionType,
			double transactionAmount, UserDetails user) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;

		this.transactionAmount = transactionAmount;
		this.user = user;
	}

	public TransactionDetails(String transactionDescription, String transactionType, double transactionAmount) {
		super();
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public TransactionDetails() {

	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionDetails(Long transactionId, String transactionDescription, String transactionType,
			double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;

		this.transactionAmount = accountBalance;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", transactionDescription="
				+ transactionDescription + ", transactionType=" + transactionType + ", transactionAmount="
				+ transactionAmount + "]";
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
