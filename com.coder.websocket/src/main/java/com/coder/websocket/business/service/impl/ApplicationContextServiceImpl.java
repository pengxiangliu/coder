/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.business.service.impl;

import com.coder.websocket.business.service.IApplicationContextService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @Version 1.0
 * @Author pengxiang.liu
 * @Created 2019/11/16 16:22
 * @Description <p>
 * @Modification Date Author Version Description
 * 2019年11月16日 pengxiang.liu 1.0 create file
 */
@Service
public class ApplicationContextServiceImpl implements IApplicationContextService, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}