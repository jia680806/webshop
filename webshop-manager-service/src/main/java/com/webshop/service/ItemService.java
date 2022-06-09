package com.webshop.service;

import org.springframework.stereotype.Service;

import com.webshop.pojo.TbItem;

@Service
public interface ItemService {

	TbItem getItemById(long itenId);

}
