<template>
	<div class="about">

	</div>
</template>
<script>
	import SockJS from 'sockjs-client';
	import webstomp from 'webstomp-client';

	export default {
		name: "Login",
		data: function() {
			return {}
		},
		mounted() {
			let self = this;
			let socket = new SockJS("http://192.168.0.29:10079/websocket-simple");
			let stompClient = webstomp.over(socket);
			stompClient.connect({
				access_token: "e194ee63-0bd2-40a8-a701-b946d01afb4d"
			}, (frame) => {
				self.socket = stompClient;

				stompClient.subscribe("/topic/socket", (res) => {
					let data = JSON.parse(res.body);
					console.log(data.message);
					self.message = data.message;
				});
				stompClient.send("/socket", JSON.stringify({
					"message": "test"
				}));

			});
		},
		methods: {

		}
	}
</script>