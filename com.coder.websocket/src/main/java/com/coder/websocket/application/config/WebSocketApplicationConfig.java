/*******************************************************************************
 * Copyright (c) 2019, 2019 Dauron Corporation.
 ******************************************************************************/
package com.coder.websocket.application.config;

import com.coder.websocket.application.controller.MainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * @Version 1.0
 * @Author jian.zhang
 * @Created 2019年8月9日 下午12:24:07
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年8月9日 jian.zhang 1.0 create file
 */
@Configuration
public class WebSocketApplicationConfig {

	@ComponentScan(basePackageClasses = {MainController.class})
	public class ControllerConfig {

	}

	// 此注解表示使用STOMP协议来传输基于消息代理的消息，此时可以在@Controller类中使用@MessageMapping
	@EnableWebSocketMessageBroker
	public class MessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

		/**
		 * 注册 Stomp的端点 addEndpoint：添加STOMP协议的端点。这个HTTP URL是供WebSocket或SockJS客户端访问的地址 withSockJS：指定端点使用SockJS协议
		 */
		@Override
		public void registerStompEndpoints(StompEndpointRegistry registry) {
			//@formatter:off
			registry.addEndpoint("/websocket-simple")
					.addInterceptors(handshakeInterceptor())
					.setHandshakeHandler(userHandshakeHandler())
					.setAllowedOrigins("*")
					.withSockJS();
			//@formatter:on
		}

		/**
		 * 配置消息代理 启动简单Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
		 */
		@Override
		public void configureMessageBroker(MessageBrokerRegistry registry) {
			//@formatter:off
			registry
//					.setApplicationDestinationPrefixes("/app")
//					.enableStompBrokerRelay("topic", "queue")
					.enableSimpleBroker("/topic", "/queue");
			//@formatter:on
		}

		@Bean
		public HandshakeInterceptor handshakeInterceptor() {
			return new CoderWebSocketHandshakeInterceptor();
		}

		@Bean
		public UserHandshakeHandler userHandshakeHandler() {
			return new UserHandshakeHandler();
		}
	}

	class CoderWebSocketHandshakeInterceptor implements HandshakeInterceptor {

		/**
		 * @see HandshakeInterceptor#beforeHandshake(ServerHttpRequest, ServerHttpResponse,
		 * WebSocketHandler, Map)
		 */
		@Override
		public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

			System.out.println(request.getURI()
									  .toString() + ":" + request.getPrincipal());
			return true;
		}

		/**
		 * @see HandshakeInterceptor#afterHandshake(ServerHttpRequest, ServerHttpResponse,
		 * WebSocketHandler, Exception)
		 */
		@Override
		public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

		}
	}

	class UserHandshakeHandler extends DefaultHandshakeHandler {

		/**
		 * @see org.springframework.web.socket.server.support.AbstractHandshakeHandler#determineUser(ServerHttpRequest, WebSocketHandler,
		 * Map)
		 */
		@Override
		protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
			System.out.println(1);
			return super.determineUser(request, wsHandler, attributes);
		}
	}
}
