package com.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.webshop.common.pojo.EUDataGridResult;

import com.webshop.service.ItemService;

@Controller
@RequestMapping("manager")
public class ItemController {
	
		@Autowired
		private ItemService itemService;
		


		@RequestMapping("/item/list")
		@ResponseBody
		public EUDataGridResult getItemList(Integer page, Integer rows) {
			EUDataGridResult result = itemService.getItemList(page, rows);
			return result;
		}
		

	}


