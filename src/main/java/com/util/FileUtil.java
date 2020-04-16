package com.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    /**
     * @param file 源文件
     * @param path 保存路径
     * @param fileName 保存的文件名
     * @return java.lang.String 返回文件路径
     * @date 2020/4/16
     * @author Charlotte
     */
    public static String saveFile(MultipartFile file, String path, String fileName) throws IOException {

        //获取图片后缀
        String suffix = file.getContentType().toLowerCase();//图片后缀，用以识别哪种格式数据
        suffix = suffix.substring(suffix.lastIndexOf("/") + 1);
        System.out.println("后缀:" + suffix);

        //指定保存的目录
        File targetFile = new File(path, fileName + "." + suffix);
        if (!targetFile.getParentFile().exists()) { //注意，判断父级路径是否存在
            targetFile.getParentFile().mkdirs();
        }
        //保存
        file.transferTo(targetFile);
        return "/image/"+fileName + "." + suffix;
    }
}
