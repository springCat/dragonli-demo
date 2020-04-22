package com.demo.common;

import com.demo.blog.BlogController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import org.springcat.dragonli.jfinal.DragonLiConfig;

import java.util.Arrays;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * API 引导式配置
 */
public class DemoConfig extends DragonLiConfig {
	
	static Prop p;


	/**
	 * 配置常量
	 */
	public void configConstantPlus(Constants me) {
		if (p == null) {
			p = PropKit.useFirstFound("demo-config-pro.txt", "demo-config-dev.txt");
		}
		me.setDevMode(false);
	}

	/**
	 * 配置路由
	 */
	public void configRoutePlus(Routes me) {
		me.add("/blog", BlogController.class);
	}
	
	public void configEnginePlus(Engine me) {
	}
	
	/**
	 * 配置插件
	 */
	public void configPluginPlus(Plugins me) {

	}

	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptorPlus(Interceptors me){
 	}
	
	/**
	 * 配置处理器
	 */
	public void configHandlerPlus(Handlers me) {

	}

	public void onStart() {

	}

	public void onStop() {

	}

	/**
	 * 启动入口，运行此 main 方法可以启动项目，此 main 方法可以放置在任意的 Class 类定义中，不一定要放于此
	 */
	public static void main(String[] args) {

		UndertowServer undertowServer = UndertowServer
				.create(DemoConfig.class);
		undertowServer
				.addHotSwapClassPrefix("org.springcat.dragonli")
				.start();
	}
}
