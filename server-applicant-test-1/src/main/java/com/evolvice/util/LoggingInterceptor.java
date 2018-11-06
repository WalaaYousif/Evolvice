/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME LoggingInterceptor.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice.util
 * @see [LoggingInterceptor]
 */

package com.evolvice.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Walaa Yousif
 */

public class LoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(LoggingInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		StringBuilder logMessage = new StringBuilder();
		logMessage.append("method: ").append(request.getMethod()).append("\t");
		logMessage.append("uri: ").append(request.getRequestURI()).append("\t");
		logMessage.append("status: ").append(response.getStatus()).append("\t");
		logMessage.append("remoteAddress: ").append(request.getRemoteAddr()).append("\t");

		if (ex != null) {
			LoggingInterceptor.LOG.error(logMessage.toString(), ex);
		} else {
			LoggingInterceptor.LOG.info(logMessage.toString());
		}

	}

}
