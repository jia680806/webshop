package com.webshop.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.mapper.TbItemDescMapper;
import com.webshop.mapper.TbItemMapper;
import com.webshop.mapper.TbItemParamItemMapper;
import com.webshop.pojo.TbItem;
import com.webshop.pojo.TbItemExample;
import com.webshop.pojo.TbItemExample.Criteria;

import com.webshop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		System.out.println(list);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}

		return null;
	}
}
