package org.xuefeng.mssms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xuefeng.mssms.dto.StudentScoreStatusDto;
import org.xuefeng.mssms.entity.*;
import org.xuefeng.mssms.mapper.AdminMapper;
import org.xuefeng.mssms.mapper.CourseMapper;
import org.xuefeng.mssms.mapper.ScoreMapper;
import org.xuefeng.mssms.mapper.StudentMapper;
import org.xuefeng.mssms.service.AdminService;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public Admin getAdmin(int id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    @Override
    public Admin queryTest(Integer id) {
        Admin admin = adminMapper.selectTest(id);
        return admin;
    }

    @Override
    public Admin queryAdminByAccount(String account) {
        Admin admin = adminMapper.selectAdminByAccount(account);
        return admin;
    }

    @Override
    public String deleteScore(Integer id) {
        int i = scoreMapper.deleteByPrimaryKey(id);
        if (i == 0) {
            return "删除失败！";
        }
        return "删除成功！";
    }

    @Override
    public List<StudentScoreStatusDto> getStudentsScoreStatus() {
        List<StudentScoreStatusDto> studentScoreStatusDtos = new ArrayList<>();
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCourseidLike("%%");
        List<Course> courses = courseMapper.selectByExample(courseExample);
//        总人数
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStunoLike("%%");
        int totalPeopleNumber = studentMapper.selectByExample(studentExample).size();
        for (int i = 0; i < courses.size(); i++) {
            StudentScoreStatusDto studentScoreStatusDto = new StudentScoreStatusDto();
            studentScoreStatusDto.setCourseName(courses.get(i).getCoursename());
            studentScoreStatusDto.setTotalPeople(totalPeopleNumber);
            studentScoreStatusDto.setPassPeople(getPassPeopleByCourseId(courses.get(i).getCourseid()));
            studentScoreStatusDto.setPassRate(100*getPassPeopleByCourseId(courses.get(i).getCourseid()) / totalPeopleNumber);
            studentScoreStatusDto.setNoPassPeople(totalPeopleNumber - getPassPeopleByCourseId(courses.get(i).getCourseid()));
            studentScoreStatusDto.setNoPassRate(100*(totalPeopleNumber - getPassPeopleByCourseId(courses.get(i).getCourseid())) / totalPeopleNumber);
            studentScoreStatusDto.setExcellentPeople(getExcellentPeopleByCourseId(courses.get(i).getCourseid()));
            studentScoreStatusDto.setRateOfExcellence(100*getExcellentPeopleByCourseId(courses.get(i).getCourseid()) / totalPeopleNumber);
            studentScoreStatusDtos.add(studentScoreStatusDto);
        }

        System.out.println(studentScoreStatusDtos.toString());
        return studentScoreStatusDtos;
    }

    /**
     * 根据课程id获取该课程及格人数
     *
     * @param courseId
     * @return
     */
    private Integer getPassPeopleByCourseId(String courseId) {
        int passPeople = 0;
        List<Score> scores = scoreMapper.selectScoreByCourseid(courseId);
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).getScore() >= 60.0f) {
                passPeople++;
            }
        }
        return passPeople;
    }

    /**
     * 根据课程id获取该课程优秀人数
     *
     * @param courseId
     * @return
     */
    private Integer getExcellentPeopleByCourseId(String courseId) {
        int ExcellentPeople = 0;
        List<Score> scores = scoreMapper.selectScoreByCourseid(courseId);
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).getScore() >= 90.0f) {
                ExcellentPeople++;
            }
        }
        return ExcellentPeople;
    }
}
