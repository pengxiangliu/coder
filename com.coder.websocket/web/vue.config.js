module.exports = {
	lintOnSave: false,
	publicPath: "./",
	outputDir: '../src/main/resources/static',
	assetsDir: 'assets',
	productionSourceMap: false,
	pages: {
		index: {
			entry: 'src/main.js',
			template: 'public/index.html',
			filename: 'index.html'
		}
	},
	css: {
		modules: true,
		sourceMap: true
	},
	devServer: {
		port: 8081,
		proxy: {
			"/gateway/adapter": {
				target: "http://192.168.0.29:31002",
				pathRewrite: {
					'^/gateway/adapter': ''
				},
				secure: false,
				ws: false,
				changeOrigin: false
			},
		}
	}
}