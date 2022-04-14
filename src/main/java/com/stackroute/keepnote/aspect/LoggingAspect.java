package com.stackroute.keepnote.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */
@Component
@Aspect
public class LoggingAspect {
	/*
	 * Write loggers for each of the methods of controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
	@Pointcut(value = "execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void beforeController() {
	}

	@Before("beforeController()")
	public void beforeAspect(JoinPoint joinpoint) {
		System.out.println("-------@Before(\"beforeController()\"----------"+joinpoint.getSignature());

	}

	@Pointcut(value = "execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void afterController() {
	}

	@After("afterController()")
	public void afterAspect(JoinPoint joinpoint) {
		System.out.println("----------@After(afterController()"+joinpoint.getSignature());
	}

	@Pointcut(value = "execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void afterThrowing() {
	}

	@AfterThrowing(pointcut="execution(* com.stackroute.keepnote.controller.*.*(..))",throwing="exception")
	public void afterThrowingAspect(Exception exception) {
		System.out.println("----@AfterThrowing---"+exception.getMessage());
	}
	@Pointcut(value = "execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void afterReturning() {
	}

	@AfterReturning(pointcut="execution(* com.stackroute.keepnote.controller.*.*(..))",returning="val")
	public void afterReturningAspect(Object val) {
		System.out.println("----@AfterReturning---"+val);
	}
}
