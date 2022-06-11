package com.webshop.service;


import com.webshop.common.pojo.EUDataGridResult;
import com.webshop.pojo.TbItem;


public interface ItemService {

	TbItem getItemById(long itenId);
	public EUDataGridResult getItemList(int page, int rows);

	
}
