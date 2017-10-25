/**
 *  @Author: Z003NVXJ
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
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringContainerFactory.java
 * 
 *
 * <b><pre>
 * Copyright (C) Siemens AG 2016
 * All Rights Reserved
 * </pre></b>
 *
 * @Author Z003NVXJ
 * @Date Nov 28, 2016
 * @Version
 */
@Component
public class SpringContainerFactory implements ApplicationContextAware {
	private static final Logger logger = LoggerFactory.getLogger(SpringContainerFactory.class);
	private static ApplicationContext applicationContext;

    /**
     * Instantiates a new Spring container factory.
     */
    public SpringContainerFactory() {
		logger.debug("SpringContainerFactory initialized");
    }

	@Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        SpringContainerFactory.applicationContext = applicationContext;
        logger.debug("SpringContainerFactory - applicationContext set");
    }

    /**
     * Gets application context.
     *
     * @return the applicationContext
     */
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Gets bean.
     *
     * @param name the name
     * @return the bean
     */
    public static <T> T getBean(final String name, final Class<T> clazz) {
        if (!applicationContext.containsBean(name)) {
            return null;
        }
        return applicationContext.getBean(name, clazz);
    }

    /**
     * Gets bean.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @return the bean
     */
    public static <T> T getBean(final Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
