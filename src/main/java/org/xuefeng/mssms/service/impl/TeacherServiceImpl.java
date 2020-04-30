package org.xuefeng.mssms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.xuefeng.mssms.entity.*;
import org.xuefeng.mssms.mapper.CourseMapper;
import org.xuefeng.mssms.mapper.ScoreMapper;
import org.xuefeng.mssms.mapper.StudentMapper;
import org.xuefeng.mssms.mapper.TeacherMapper;
import org.xuefeng.mssms.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public Teacher queryTeacherByTeachno(String teachno) {
        Teacher teacher = teacherMapper.selectTeacherByTeachno(teachno);
        return teacher;
    }

    @Override
    public String addScore(String stuno, String courseName, Float score) {
        if(StringUtils.isEmpty(stuno)||StringUtils.isEmpty(courseName)){
            return "学号或课程名称为空！";
        }
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCoursenameEqualTo(courseName);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        if (courses.size()==0){
            return "不存在该课程！";
        }
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andStunoEqualTo(stuno);
        criteria.andCourseidEqualTo(courses.get(0).getCourseid());
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        if (scores.size()>0){
            return "该课程成绩已录入!";
        }
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStunoEqualTo(stuno);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size()==0){
            return "学号不存在！";
        }
        Score score1 = new Score();
        score1.setStuno(stuno);
        score1.setCourseid(courses.get(0).getCourseid());
        score1.setScore(score);
        int isInsert = scoreMapper.insert(score1);
        if(isInsert==0){
            return "添加失败！";
        }
        return "添加成功！";

    }

    @Override
    public String updateScore(String stuno, String courseName, Float score) {
        if(StringUtils.isEmpty(stuno)||StringUtils.isEmpty(courseName)){
            return "学号或课程名称为空！";
        }
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCoursenameEqualTo(courseName);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        if (courses.size()==0){
            return "不存在该课程！";
        }
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andStunoEqualTo(stuno);
        criteria.andCourseidEqualTo(courses.get(0).getCourseid());
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        if (scores.size()==0){
            return "学号不存在！";
        }
        Score score1 = new Score();
        score1.setId(scores.get(0).getId());
        score1.setStuno(scores.get(0).getStuno());
        score1.setCourseid(scores.get(0).getCourseid());
        score1.setScore(score);
        int isUpdate = scoreMapper.updateByPrimaryKey(score1);
        if(isUpdate==0){
            return "更新失败！";
        }
        return "更新成功！";
    }


}
