/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.application.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.coder.websocket.application.controller.value.WebSocketRequest;
import com.coder.websocket.application.controller.value.WebSocketResponse;

/**
 * @Version 1.0
 * @Author jian.zhang
 * @Created 2019年8月9日 下午2:58:39
 * @Description
 *              <p>
 * @Modification
 *               <p>
 *               Date Author Version Description
 *               <p>
 *               2019年8月9日 jian.zhang 1.0 create file
 */
@Controller
public class WebSocketController {

	@MessageMapping("/socket")
	@SendTo("/topic/socket")
	public WebSocketResponse soket(WebSocketRequest request) throws IOException {
		final WebSocketResponse webSocketResponse = new WebSocketResponse();
		webSocketResponse.setMessage("socket:" + LocalDateTime.now().toString());
		return webSocketResponse;
	}

}
