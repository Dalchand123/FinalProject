package com.cognizant.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect @Component
public class LoggerAspect {
	static Logger logger = Logger.getLogger(LoggerAspect.class);
	
	
	

    @Before("execution(* com.cognizant.*..*(..))")
    public void logJoinPoint(JoinPoint joinPoint)
    {
        logger.warn("Join point kind : " + joinPoint.getKind());
        logger.warn("Signature declaring type : "+ joinPoint.getSignature().getDeclaringTypeName());
        logger.warn("Signature name : " + joinPoint.getSignature().getName());
        logger.warn("Arguments : " + Arrays.toString(joinPoint.getArgs()));
        logger.warn("Target class : "+ joinPoint.getTarget().getClass().getName());
        logger.warn("This class : " + joinPoint.getThis().getClass().getName());
    }
      
    @AfterReturning(pointcut="execution(* com.cognizant.*..*(..))", returning = "result")
    public void logAfterAll(JoinPoint joinPoint, Object result)
    {

    	 logger.warn("Exiting from Method :"+joinPoint.getSignature().getName());
    	 logger.warn("Return value :"+result);
    }

    

	
	
	
	/*@Before("execution(* com.cognizant.dao.ViewEducationLoanDAO.*(..))")
	public void logBefore(JoinPoint joinPoint) {
        logger.warn("Account Number is :"+Arrays.toString(joinPoint.getArgs()));
        logger.warn(joinPoint.getSignature().getName()+" method called in ViewEducationLoanDao");
        logger.warn("Target class : "+ joinPoint.getTarget().getClass().getName());
        logger.warn("This class : " + joinPoint.getThis().getClass().getName());
	}
	
	 @AfterReturning(  
             pointcut = "execution(* com.cognizant.dao.ViewEducationLoanDAO.*(..))",  
             returning= "result")  
	public void logAfter(JoinPoint joinPoint,Object result) {
      
		
		logger.debug("Result is :"+result);
	}
	 
	 @Before("execution(* com.cognizant.dao.ViewHomeLoanDAO.retrieveUserHomeLoanDetails(..))")
		public void logBeforeHome(JoinPoint joinPoint) {
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
	      
	   } */ 

	
}
