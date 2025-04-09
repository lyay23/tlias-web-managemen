package com.itheima.service;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentCountOption;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/8:56
 * @Description: 报表统计的service接口
 */
public interface ReportService {

    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别人数
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计班级人数
     */
    StudentCountOption getStudentCountData();
}
