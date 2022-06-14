package com.webshop.service;

import com.webshop.common.pojo.EUDataGridResult;
import com.webshop.common.result.TaotaoResult;
import com.webshop.pojo.TbItem;
import com.webshop.pojo.TbItemDesc;


public interface ItemService {

	TbItem getItemById(long itenId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult addItem(TbItem item, TbItemDesc itemDesc);

	
}
