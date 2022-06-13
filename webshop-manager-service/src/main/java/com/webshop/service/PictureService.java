package com.webshop.service;

import org.springframework.web.multipart.MultipartFile;

import com.webshop.common.pojo.PictureResult;

public interface PictureService {

	 PictureResult uploadPicture(MultipartFile uploadFile);
	 
	

}
