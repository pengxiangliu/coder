/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.application;

import com.coder.websocket.application.config.WebSocketApplicationConfig;
import com.coder.websocket.business.config.WebsocketBusinessConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @Author jian.zhang
 * @Created 2019年8月9日 上午11:45:26
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年8月9日 jian.zhang 1.0 create file
 */
@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@Import({WebSocketApplicationConfig.class, WebsocketBusinessConfig.class})
public class WebSocketApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().properties(getDefaultProperties())
									  .sources(WebSocketApplication.class)
									  .run(args);
	}

	private static Map<String, Object> getDefaultProperties() {
		final Map<String, Object> defaultProperties = new HashMap<>();
		defaultProperties.put(ConfigFileApplicationListener.CONFIG_NAME_PROPERTY, StringUtils.collectionToCommaDelimitedString(getConfigNames()));
		return defaultProperties;
	}

	private static List<String> getConfigNames() {
		final List<String> result = new ArrayList<>();
		result.add("web.socket");
		return result;
	}
}
