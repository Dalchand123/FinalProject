package com.cognizant.common;

import java.util.Random;



public class Utility {

	public static String loanId(long accountNumber) {
		StringBuffer sb3 = new StringBuffer();
		System.out.println("In utility class " + accountNumber);
		String account = Long.toString(accountNumber);
		String lastThreeDigit = account.substring(13, 16);
		sb3.append("HL").append("-").append(lastThreeDigit);
		String loanId = sb3.toString();

		return loanId;
	}

	public static String loanAccountNumber() {
		long time = System.nanoTime();
		Random rd = new Random();
		int i = rd.nextInt(10);
		String random = Integer.toString(i);
		String timeInString1 = Long.toString(time);
		StringBuffer sb = new StringBuffer();
		sb.append(timeInString1).append(random);
		String sb2 = sb.toString();

		return sb2;
	}

	

	
}
