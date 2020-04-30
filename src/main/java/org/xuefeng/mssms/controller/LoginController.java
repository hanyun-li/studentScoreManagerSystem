package org.xuefeng.mssms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xuefeng.mssms.entity.Admin;
import org.xuefeng.mssms.entity.Student;
import org.xuefeng.mssms.entity.Teacher;
import org.xuefeng.mssms.service.AdminService;
import org.xuefeng.mssms.service.StudentService;
import org.xuefeng.mssms.service.TeacherService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AdminService adminService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    public String toLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model){

        System.out.println(username);
        System.out.println(password);

        Admin admin = adminService.queryAdminByAccount(username);
        Student student = studentService.queryStudentByStuno(username);
        Teacher teacher = teacherService.queryTeacherByTeachno(username);

        if (admin != null&&password.equals(admin.getPassword())){
            model.addAttribute("info",admin);
            model.addAttribute("idinfo","管理员");
            model.addAttribute("stuno",username);
            return "adminInfo";
        }

        if (student != null&&password.equals(student.getPsd())){
            model.addAttribute("info",student);
            model.addAttribute("idinfo","学生");
            model.addAttribute("stuno",username);
            return "studentInfo";
        }

        if (teacher != null&&password.equals(teacher.getPsd())){
            model.addAttribute("info",teacher);
            model.addAttribute("idinfo","教师");
            model.addAttribute("stuno",username);
            return "teacherInfo";
        }

        model.addAttribute("error","用户名或密码错误!");

        return "login";
    }

    @RequestMapping(value = "/goLogin",method = RequestMethod.GET)
    public String goLoin(){
        return "login";
    }
}
