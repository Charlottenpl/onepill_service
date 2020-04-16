package com.File.controller;

import com.User.service.UserService;
import com.entity.User;
import com.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    // 这里的是application.properties中配置的地址
    @Value("${up.path}")
    private String uploadPicPath;

    @Resource
    UserService userService;


    // 文件上传
    @PostMapping("/up")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId) throws Exception {


        String fileName = FileUtil.saveFile(file, uploadPicPath, userId + "_headImg");

        //更新数据库
        User user = this.userService.findById(userId);
        user.setHeadImg(fileName);
        this.userService.save(user);

        return fileName;
//        System.out.println("userId:"+userId);
//        String suffix = file.getContentType().toLowerCase();//图片后缀，用以识别哪种格式数据
//        suffix = suffix.substring(suffix.lastIndexOf("/")+1);
//        System.out.println("后缀:"+suffix);
//        String fileName = "image01"+"."+suffix;
//
//        File targetFile = new File(uploadPicPath, fileName);
//        if(!targetFile.getParentFile().exists()){ //注意，判断父级路径是否存在
//            targetFile.getParentFile().mkdirs();
//        }
//        //保存
//        file.transferTo(targetFile);
//        System.out.println("返回结果:"+uploadPicPath+"/"+fileName);
//        return uploadPicPath+"/"+fileName;
        // 存储图片到本地
//        return storePic(file);

    }


}
