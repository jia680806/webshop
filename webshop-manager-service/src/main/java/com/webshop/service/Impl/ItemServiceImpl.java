package com.webshop.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.mapper.TbItemMapper;
import com.webshop.pojo.TbItem;
import com.webshop.pojo.TbItemExample;
import com.webshop.pojo.TbContentCategoryExample.Criteria;
import com.webshop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
		
	@Autowired
		private TbItemMapper itemMapper;
	
		@Override
		public TbItem getItemById(long itenId) {
			TbItemExample example = new TbItemExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(itenId);
			List<TbItem> list = itemMapper.selectByExample(example);
			if(list !=null && list.size()>0) {
				TbItem item = list.get(0);
				return item;
			}
			
			return null;
		}

}
