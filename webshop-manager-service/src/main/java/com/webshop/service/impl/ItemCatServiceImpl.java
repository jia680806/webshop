package com.webshop.service.impl;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.common.pojo.TreeNode;
import com.webshop.mapper.TbItemCatMapper;
import com.webshop.pojo.TbItemCat;
import com.webshop.pojo.TbItemCatExample;
import com.webshop.pojo.TbItemCatExample.Criteria;
import com.webshop.service.ItemCatService;


@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private TbItemCatMapper itemCatMapper;


	@Override
	public List<TreeNode> getItemCatList(long parentId) {
		//根据parentId查询分类列表
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//分类列表转换成TreeNode的列表
		List<TreeNode> resultList = new ArrayList<>();
		
		for(TbItemCat tbItemCat : list) {
			TreeNode node = new TreeNode(tbItemCat.getId(),tbItemCat.getName(),
					tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}

		return resultList;
	}

}
