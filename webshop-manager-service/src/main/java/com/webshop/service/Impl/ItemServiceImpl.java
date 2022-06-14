package com.webshop.service.impl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webshop.common.pojo.EUDataGridResult;
import com.webshop.common.result.TaotaoResult;
import com.webshop.common.utils.ExceptionUtil;
import com.webshop.common.utils.IDUtils;
import com.webshop.mapper.TbItemDescMapper;
import com.webshop.mapper.TbItemMapper;
import com.webshop.pojo.TbItem;
import com.webshop.pojo.TbItemDesc;
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

	@Override
	public TaotaoResult addItem(TbItem item, TbItemDesc itemDesc) {
		try {
			//生成商品id
			//可以使用redis的自增长key，在没有redis之前使用时间+随机数策略生成
			Long itemId = IDUtils.genItemId();
			//补全不完整的字段
			item.setId(itemId);
			item.setStatus((byte) 1);
			Date date = new Date();
			item.setCreated(date);
			item.setUpdated(date);
			//把数据插入到商品表
			itemMapper.insert(item);
			//添加商品描述
			itemDesc.setItemId(itemId);
			itemDesc.setCreated(date);
			itemDesc.setUpdated(date);
			//把数据插入到商品描述表
			itemDescMapper.insert(itemDesc);
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return TaotaoResult.ok();
	}

}

	





