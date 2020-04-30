package org.xuefeng.mssms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xuefeng.mssms.entity.*;
import org.xuefeng.mssms.mapper.AdminMapper;
import org.xuefeng.mssms.mapper.StudentMapper;
import org.xuefeng.mssms.mapper.TeacherMapper;
import org.xuefeng.mssms.service.ModifyPasswordService;

import java.util.List;

/**
 * @Author: hanyun.li
 * @Date: 2020/4/26 10:26
 * @Description: 修改用户密码
 */
@Service
public class ModifyPasswordServiceImpl implements ModifyPasswordService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    AdminMapper adminMapper;


    /**
     * 修改学生密码
     * @param stuno
     * @param nowPassword
     * @param afterPassword
     * @return
     */
    @Override
    public String modifyPasswordByStuno(String stuno, String nowPassword, String afterPassword) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStunoEqualTo(stuno);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size()==0){
            return "-1";
        }
        if (!students.get(0).getPsd().equals(nowPassword)){
            return "-2";
        }
        Student student1 = new Student();
        student1.setStuno(stuno);
        student1.setPsd(afterPassword);
        int i = studentMapper.updatePasswordByStuno(student1);
        return String.valueOf(i);
    }

    /**
     * 修改老师密码
     * @param teachno
     * @param nowPassword
     * @param afterPassword
     * @return
     */
    @Override
    public String modifyPasswordByTeachNo(String teachno, String nowPassword, String afterPassword) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeachnoEqualTo(teachno);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size()==0){
            return "-1";
        }
        if (!teachers.get(0).getPsd().equals(nowPassword)){
            return "-2";
        }
        Teacher teacher = new Teacher();
        teacher.setTeachno(teachno);
        teacher.setPsd(afterPassword);
        int i = teacherMapper.updatePasswordByTeachNo(teacher);
        return String.valueOf(i);
    }

    /**
     * 修改管理员密码
     * @param account
     * @param nowPassword
     * @param afterPassword
     * @return
     */
    @Override
    public String modifyPasswordByAccount(String account, String nowPassword, String afterPassword) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(account);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size()==0){
            return "-1";
        }
        if (!admins.get(0).getPassword().equals(nowPassword)){
            return "-2";
        }
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPassword(afterPassword);
        int i = adminMapper.updatePasswordByAccount(admin);
        return String.valueOf(i);
    }
}
