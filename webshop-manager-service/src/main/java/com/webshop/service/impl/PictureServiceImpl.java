package com.webshop.service.impl;


import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.common.utils.PictureResult;
import com.webshop.common.utils.ExceptionUtil;
import com.webshop.common.utils.FtpUtil;
import com.webshop.common.utils.IDUtils;
import com.webshop.service.PictureService;


@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USER_NAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		// 判断是否为空
		if(uploadFile ==null || uploadFile.isEmpty()) {
			return PictureResult.error("上传图片为空");
		}
		//取文件名
		String originalFilename  = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
				//可以使用uuid生成新文件名。
				//UUID.randomUUID()
				//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		DateTime dateTime = new DateTime();
		String filePath  = dateTime.toString("yyyy/mm/dd");
		try {
			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, 
					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return PictureResult.error(ExceptionUtil.getStackTrace(e));
		}
		//返回结果，生成一个可以访问到图片的url返回
		
		return PictureResult.ok(IMAGE_BASE_URL + filePath + "/" + imageName + ext);
	}

}
