/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @Version 1.0
 * @Author pengxiang.liu
 * @Created 2019/12/4 10:40
 * @Description <p>
 * @Modification Date Author Version Description
 * 2019年12月04日 pengxiang.liu 1.0 create file
 */
@Controller
public class SseController {

	public SseEmitter emitter() {
		SseEmitter emitter = new SseEmitter();

		return emitter;
	}
}