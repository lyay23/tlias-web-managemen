package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentCountOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/8:57
 * @Description: 报表统计的service接口的实现
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 1.调用mapper查询数据
           //map: pos=校验主管,num=1
           //     pos=XXX ,num=2
        List<Map<String, Object>> maps = empMapper.countEmpJobData();

        // 2. 组装结果并返回
          //根据key获取value,并将结果封装到一个新的集合中
          // dataMap 拿到了里面的一个个map集合
          // dataMap.get("pos") 获取到里面的pos对应的值
          // .toList();将结果封装到一个list集合中
          // jobList 拿到了里面的一个个pos对应的值 职位名称
        List<Object> jobList = maps.stream().map(dataMap -> dataMap.get("pos")).toList();

        // dataNum 拿到了里面的一个个pos对应的值 职位数量
        List<Object> dataList = maps.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    /**
     * 获取员工性别统计
     * @return
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 获取班级人数统计
     */
    @Override
    public StudentCountOption getStudentCountData() {
        List<Map<String, Object>> maps = studentMapper.countStuNumData();

        List<Object> jobList = maps.stream().map(dataMap -> dataMap.get("cname")).toList();

        List<Object> dataList = maps.stream().map(dataMap -> dataMap.get("scount")).toList();
        return new StudentCountOption(jobList,dataList);
    }
}
