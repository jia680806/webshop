package com.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager")
public class PageController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	/**
	 * 显示其他功能页面
	 * @param page 功能页面
	 * @return
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	

}
