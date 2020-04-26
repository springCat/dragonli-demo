package com.demo.blog;

import cn.hutool.core.map.MapUtil;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import org.springcat.dragonli.jfinal.controller.JsonController;

public class BlogController extends JsonController {

	@Inject
	private BlogService blogService;

	@Before(BlogPara.class)
	public void json() {
		BlogPara jsonBean = getJsonBean(BlogPara.class);
		jsonBean.setContent(getHeader("x-uid"));
		renderJson(jsonBean);
	}

	@Before(BlogPara.class)
	public void testRpc(){
		BlogPara blogPara = new BlogPara();
		BlogPara resp = blogService.json(blogPara,MapUtil.of("x-uid","xxxx"),null);
		renderJson(resp);
	}

	public void config(){
//		renderText(ConfigUtil.getUserConf("/1/1/1"));
	}
}


