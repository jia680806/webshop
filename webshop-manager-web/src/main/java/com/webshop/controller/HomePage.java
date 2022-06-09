package com.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理系统首页
 * @author zhang_hong_jia
 *
 */
@Controller
@RequestMapping("manager")
public class HomePage {
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		//返回首页地址
		
		return "index";
	}

}
