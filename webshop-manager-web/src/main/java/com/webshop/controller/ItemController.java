package com.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.webshop.common.pojo.EUDataGridResult;
import com.webshop.common.result.TaotaoResult;
import com.webshop.pojo.TbItem;
import com.webshop.pojo.TbItemDesc;
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
		
		@RequestMapping("/save")
		@ResponseBody
		public TaotaoResult addItem(TbItem item, String desc) {
			TbItemDesc itemDesc = new TbItemDesc();
			itemDesc.setItemDesc(desc);
			TaotaoResult result = itemService.addItem(item, itemDesc);
			return result;
		}



}


