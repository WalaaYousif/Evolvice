/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME ApplicationMainLogger.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice;
 * @see [ApplicationMainLogger]
 */

package com.evolvice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Walaa Yousif
 */

@Aspect
@Component
public class ApplicationMainLogger {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationMainLogger.class);

	@Before("execution(* com.evolvice.controller..*(..)) || " + "execution(* com.evolvice.service..*(..)) || "
			+ "execution(* com.evolvice.dataaccessobject..*(..))")
	public void logStartOfMethod(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String logMsg = "Class:" + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", Method:"
				+ joinPoint.getSignature().getName() + ", Params:";
		try {
			for (Object arg : args)
				logMsg += ("," + arg.toString());
		} catch (Exception ex) {
			logMsg = ",No Params ";
		}
		logger.info(logMsg + Arrays.deepToString(args));
	}

	@AfterThrowing(pointcut = "execution(* com.evolvice.controller..*(..)) || "
			+ "execution(* com.evolvice.service..*(..)) || "
			+ "execution(* com.evolvice.dataaccessobject..*(..)) ", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		String logMsg = "Class:" + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", Failed Method : "
				+ joinPoint.getSignature().getName() + ", Casue :" + exception.getMessage();
		logger.error(logMsg, exception);
	}

	@AfterReturning(pointcut = "execution(* com.evolvice.controller..*(..)) || "
			+ "execution(* com.evolvice.service..*(..)) || "
			+ "execution(* com.evolvice.dataaccessobject..*(..))", returning = "response")
	public void afterReturning(JoinPoint joinPoint) {
		String logMsg = "";
		try {
			logMsg = "Class:" + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", Method : "
					+ joinPoint.getSignature().getName();
		} catch (Exception ex) {
			logMsg = "no return ";
		}
		logger.info(logMsg);
	}
}
