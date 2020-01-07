/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.business.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Version 1.0
 * @Author pengxiang.liu
 * @Created 2019/11/19 15:33
 * @Description <p>
 * @Modification Date Author Version Description
 * 2019年11月19日 pengxiang.liu 1.0 create file
 */
@Slf4j
public class TestBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info(beanName + "初始化完成");
		return bean;
	}
}