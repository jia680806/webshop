package com.webshop.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webshop.common.pojo.EUDataGridResult;
import com.webshop.mapper.TbItemMapper;
import com.webshop.pojo.TbItem;
import com.webshop.pojo.TbItemExample;
import com.webshop.pojo.TbItemExample.Criteria;
import com.webshop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
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

	@Override
		public EUDataGridResult getItemList(int page, int rows) {
			//查询商品列表
			TbItemExample example = new TbItemExample();
			//分页处理
			PageHelper.startPage(page, rows);
			List<TbItem> list = itemMapper.selectByExample(example);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<TbItem> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
		}


	}

