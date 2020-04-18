package com.File.controller;

import com.User.service.UserService;
import com.entity.User;
import com.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    // 这里的是application.properties中配置的地址
    @Value("${up.path}")
    private String uploadPicPath;

    @Resource
    UserService userService;


    // 头像上传
    @PostMapping("/image")
    public String upImage(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId) throws Exception {


        String fileName = FileUtil.saveFile(file, uploadPicPath+"/headImg", userId + "_headImg");

        //更新数据库
        User user = this.userService.findById(userId);
        System.out.println("更新前："+user.toString());
        user.setHeadImg("/image/headImg/"+fileName);
        System.out.println("更新后："+user.toString());
        this.userService.save(user);
        return "/image/headImg/"+fileName;

    }

    //问诊图片上传
    @PostMapping("/inquiry")
    public String upInquiry_img(@RequestParam("file")MultipartFile file) throws IOException {
        String path = uploadPicPath+"/inquiry_img/";
        String fileName = FileUtil.saveFile(file,path,"inquiry_img");
        return "/image/inquiry_img/"+fileName;

    }


}
