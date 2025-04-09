package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.pojo.StudentCountOption;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取员工性别统计人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("获取员工性别统计人数");
        List<Map<String,Object>> genderList= reportService.getEmpGenderData();

        return Result.success(genderList);
    }

    /**
     * 获取班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getClassNumData() {
        log.info("获取班级人数统计");
        StudentCountOption studentCountOption= reportService.getStudentCountData();
        return Result.success(studentCountOption);
    }

    /**
     * 获取学员学历统计
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentEduData() {
        log.info("获取学员学历统计");
        List<Map<String,Object>> eduList= reportService.getStudentEduData();
        return Result.success(eduList);
    }
}
