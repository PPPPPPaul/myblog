package com.lk.controller;

import com.lk.custom.result.PictureResult;
import com.lk.utils.PictureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
    @Value("${IMG_ADDR}")
    private String img_addr;
    @RequestMapping("/uploadFile")
    @ResponseBody
    public PictureResult picUpload(MultipartFile file){
        return PictureUtil.uploadFile(file,img_addr);
    }
}
