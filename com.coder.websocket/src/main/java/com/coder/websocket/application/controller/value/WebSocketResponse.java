/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.application.controller.value;

import java.io.Serializable;

import lombok.Data;

/**
 * @Version 1.0
 * @Author jian.zhang
 * @Created 2019年8月9日 下午3:02:58
 * @Description
 *              <p>
 * @Modification
 *               <p>
 *               Date Author Version Description
 *               <p>
 *               2019年8月9日 jian.zhang 1.0 create file
 */
@Data
public class WebSocketResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

}
