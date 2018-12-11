package com.lk.utils;

import com.lk.custom.result.PictureResult;
import org.springframework.web.multipart.MultipartFile;


public class PictureUtil {
	
	public static PictureResult uploadFile(MultipartFile uploadFile, String img_addr){
		PictureResult res = new PictureResult();
		if(uploadFile != null){
			try {
				FastDFSClient fdfsClient = new FastDFSClient("classpath:client.conf");
				String originalFilename = uploadFile.getOriginalFilename();
				String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
				String url = fdfsClient.uploadFile(uploadFile.getBytes(),ext);
				url = img_addr +url;
				res.setError(0);
				res.setUrl(url);
			} catch (Exception e) {
				res.setError(1);
				res.setMessage("图片上传失败！");
				e.printStackTrace();
			}
		}else{
			res.setError(1);
			res.setMessage("图片为空！");
		}
		return res;
	}

}
