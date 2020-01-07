/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.business.config;

import com.coder.websocket.business.service.IApplicationContextService;
import com.coder.websocket.business.service.TestBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Version 1.0
 * @Author pengxiang.liu
 * @Created 2019/11/16 16:19
 * @Description <p>
 * @Modification Date Author Version Description
 * 2019年11月16日 pengxiang.liu 1.0 create file
 */
@Configuration
@ComponentScan(
		basePackageClasses = {IApplicationContextService.class}
)
public class WebsocketBusinessConfig {

	@Bean
	public TestBeanPostProcessor beanPostProcessor() {
		return new TestBeanPostProcessor();
	}
}