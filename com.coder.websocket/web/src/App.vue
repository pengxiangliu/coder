<style lang="scss" scoped>
	@import "./style/common.scss";
	.main-app {
		@include fill-parent;
		>* {
			@include fill-parent;
		}
		.transition {
			animation-duration: 0.6s;
			animation-delay: 0s;
			animation-iteration-count: 1;
			-webkit-animation-duration: 0.6s;
			-webkit-animation-delay: 0s;
			-webkit-animation-iteration-count: 1;
			-moz-animation-duration: 0.6s;
			-moz-animation-delay: 0s;
			-moz-animation-iteration-count: 1;
			-ms-animation-duration: 0.6s;
			-ms-animation-delay: 0s;
			-ms-animation-iteration-count: 1;
		}
		#nav {
			padding: 30px;
			a {
				font-weight: bold;
				color: #2c3e50;
				&.router-link-exact-active {
					color: #42b983;
				}
			}
		}
	}
</style>
<template>
	<div class="main-app">
		<transition :enter-active-class="enterActiveClass" :leave-active-class="leaveActiveClass">
			<router-view name="mainApp" />
		</transition>
	</div>
</template>
<script>
	export default {
		name: 'mainApp',
		data: function() {
			return {
				enterActiveClass: "",
				leaveActiveClass: ""
			}
		},
		watch: {
			$route: function(to, from) {
				let showAnimation = true;
				if(showAnimation && from.name != null) {
					const toDepth = to.path.split("/").length;
					const fromDepth = from.path.split("/").length;
					if(toDepth > fromDepth) {
						this.enterActiveClass = "animation animated slideInRight";
						this.leaveActiveClass = "animation animated slideOutLeft";
					} else if(toDepth < fromDepth) {
						this.enterActiveClass = "animation animated slideInLeft";
						this.leaveActiveClass = "animation animated slideOutRight";
					} else {
						this.enterActiveClass = "";
						this.leaveActiveClass = "";
					}
				} else {
					this.enterActiveClass = "";
					this.leaveActiveClass = "";
				}
			}
		},
		mounted: function() {
			window.vue = this;
		}
	}
</script>