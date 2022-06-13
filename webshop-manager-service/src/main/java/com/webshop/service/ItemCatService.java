package com.webshop.service;

import java.util.List;

import com.webshop.common.pojo.TreeNode;

public interface ItemCatService {
	List<TreeNode> getItemCatList(long parentId);
}
