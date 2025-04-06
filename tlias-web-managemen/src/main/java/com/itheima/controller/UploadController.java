package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.util.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/01/14:09
 * @Description: 阿里云oss对象存储，实现头像上传
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传头像，参数：{}", file.getOriginalFilename());
        // 需要讲文件交给oss存储管理
        String url=aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("上传头像成功，返回的url：{}", url);

        return Result.success(url);
    }
}
