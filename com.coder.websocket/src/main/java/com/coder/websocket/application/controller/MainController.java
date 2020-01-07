/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author jian.zhang
 * @Created 2019年8月9日 下午12:27:09
 * @Description
 *              <p>
 * @Modification
 *               <p>
 *               Date Author Version Description
 *               <p>
 *               2019年8月9日 jian.zhang 1.0 create file
 */
@RestController
public class MainController {

	@Value("${spring.application.name}")
	private String applicationName;

	@RequestMapping(path = { "/", "/index.html", "/main.html" })
	public String index() {
		return applicationName;
	}

	public static void main(String[] args) {

	}

}
