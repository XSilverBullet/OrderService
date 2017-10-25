/**
 *  @Author: Z003CUHM
 *  @Date: Nov 28, 2016
 * 
 *  Copyright (C) Siemens AG 2016
 *  All Rights Reserved
 *
 *  This software is furnished under a corporate license for use on a
 *  cloud system and cannot be copied to other system.
 *
 *  This software is the confidential and proprietary information of Siemens CT
 *  ("Confidential Information"). You shall not disclose such Confidential 
 *  Information and shall use it only in accordance with the terms of the license 
 *  agreement you entered into with Siemens CT.
 *
 */

package com.siemens.scic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName SimpleCorsFilter.java
 * 
 *
 * <b><pre>
 * Copyright (C) Siemens AG 2016
 * All Rights Reserved
 * </pre></b>
 *
 * @Author Z003CUHM
 * @Date Nov 28, 2016
 * @Version
 */
@Component
public class SimpleCorsFilter implements Filter {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    	logger.debug("Enter SimpleCorsFilter");
    	
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}
