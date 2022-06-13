package com.webshop.service;

import org.springframework.web.multipart.MultipartFile;

import com.webshop.common.utils.PictureResult;

public interface PictureService {

	 PictureResult uploadPicture(MultipartFile uploadFile);
	 
	

}
