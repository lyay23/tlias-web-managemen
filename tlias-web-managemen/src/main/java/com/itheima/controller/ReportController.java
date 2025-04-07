package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/8:55
 * @Description: 报表统计的controller
 */
@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    /**
     * 获取员工职位统计人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("获取员工职位统计人数");
       JobOption jobOption= reportService.getEmpJobData();
        return Result.success(jobOption);
    }
}
