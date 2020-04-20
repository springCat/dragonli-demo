package com.demo.blog;

import cn.hutool.core.map.MapUtil;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import org.springcat.dragonli.config.ConfigUtil;
import org.springcat.dragonli.jfinal.controller.JsonController;



public class BlogController extends JsonController {

	@Inject
	private BlogService blogService;


	@Before(BlogPara.class)
	public void json() {
		BlogPara jsonBean = getJsonBean();
		jsonBean.setCode("200");
		jsonBean.setContent(getHeader("x-uid"));
		renderJson(jsonBean);
	}

	public void test(){
		BlogPara blogPara = new BlogPara();
		blogPara.setId(1);
		blogPara.setContent("content");
		blogPara.setTitle("title");
		BlogPara resp = blogService.json(blogPara);
		renderJson(resp);
	}
	public void testHeader(){
		BlogPara blogPara = new BlogPara();
		blogPara.setId(1);
		blogPara.setContent("content");
		blogPara.setTitle("title");
		BlogPara resp = blogService.json(blogPara,MapUtil.of("x-uid","xxxx"));
		renderJson(resp);
	}

	public void config(){
		renderText(ConfigUtil.getAppConf("/1/1/1"));
	}
}


