package com.cognizant.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cognizant.dao.ViewHomeLoanDAO;

import org.apache.log4j.Logger;

@Aspect @Component
public class LoggerAspect {
	static Logger logger = Logger.getLogger(ViewHomeLoanDAO.class);
	
	@Before("execution(* com.cognizant.dao.ViewHomeLoanDAO.retrieveUserHomeLoanDetails(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.warn("Account Number is :"+Arrays.toString(joinPoint.getArgs()));
        logger.warn(joinPoint.getSignature().getName()+" method called in ViewHomeLoanDao"); 
	
	}
	
	@After("execution(* com.cognizant.dao.ViewHomeLoanDAO.retrieveUserHomeLoanDetails(..))")
	 public void myadvice(JoinPoint jp)//it is advice (after advice)  
	    {  
	        System.out.println("additional concern");  
	        //System.out.println("Method Signature: "  + jp.getSignature());  
	    }  
	 @AfterReturning(  
             pointcut = "execution(* com.cognizant.dao.ViewHomeLoanDAO.retrieveUserHomeLoanDetails(..))",  
             returning= "result")  
               
   public void myadvice(JoinPoint jp,Object result)//it is advice (after returning advice)  
   {  
		 logger.debug("User details in ViewHomeLoanDAO are :" + result); 
      
   }  
 
	
	/*@After("execution(* com.cognizant.dao.ViewEducationLoanDAO.retrieveEducationLoanDetails(..))")
	public void logAfter(JoinPoint joinPoint) {
      
		System.out.println("retrieveEducationLoanDetails method called in ViewEducationLoanDao");
		
	}*/

	
}
