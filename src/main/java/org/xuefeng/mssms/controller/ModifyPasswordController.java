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
import org.xuefeng.mssms.service.ModifyPasswordService;
import org.xuefeng.mssms.service.StudentService;
import org.xuefeng.mssms.service.TeacherService;

/**
 * @Author: hanyun.li
 * @Date: 2020/4/26 11:02
 * @Description: 修改密码api
 */
@Controller
@RequestMapping("/modifyPassword")
public class ModifyPasswordController {

    @Autowired
    ModifyPasswordService modifyPasswordService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/modifyStudentPassword.do", method = RequestMethod.GET)
    public String goModifyStudentPassword(@RequestParam("stuno") String stuno,
                                          Model model) {
        Student student = studentService.queryStudentByStuno(stuno);
        model.addAttribute("info",student);
        return "changeStudentPassword";
    }

    @RequestMapping(value = "/modifyTeacherPassword.do", method = RequestMethod.GET)
    public String goModifyTeacherPassword(@RequestParam("teachno") String teachno,
                                          Model model) {
        Teacher teacher = teacherService.queryTeacherByTeachno(teachno);
        model.addAttribute("info",teacher);
        return "changeTeacherPassword";
    }

    @RequestMapping(value = "/modifyAdminPassword.do", method = RequestMethod.GET)
    public String goModifyAdminPassword(@RequestParam("account") String account,
                                        Model model) {
        Admin admin = adminService.queryAdminByAccount(account);
        model.addAttribute("info",admin);
        return "changeAdminPassword";
    }

    @RequestMapping(value = "/modifyStudentPassword", method = RequestMethod.POST)
    public String modifyStudentPassword(@RequestParam("number") String number,
                                        @RequestParam("old") String old,
                                        @RequestParam("new1") String new1,
                                        @RequestParam("new2") String new2,
                                        Model model
    ) {

        if (!new1.equals(new2)){
            model.addAttribute("errorMessage","两次输入的新密码不相同！");
            return "changeStudentPassword";
        }
        String s = modifyPasswordService.modifyPasswordByStuno(number, old, new1);
        if (s.equals("-1")){
            model.addAttribute("errorMessage","您输入的工号不正确！");
            return "changeStudentPassword";
        }
        if (s.equals("-2")){
            model.addAttribute("errorMessage","您输入的当前密码不正确！");
            return "changeStudentPassword";
        }
        Student student = studentService.queryStudentByStuno(number);
        model.addAttribute("info",student);
        model.addAttribute("idinfo","学生");
        return "studentInfo";
    }

    @RequestMapping(value = "/modifyTeacherPassword", method = RequestMethod.POST)
    public String modifyTeacherPassword(@RequestParam("number") String number,
                                        @RequestParam("old") String old,
                                        @RequestParam("new1") String new1,
                                        @RequestParam("new2") String new2,
                                        Model model
    ) {
        if (!new1.equals(new2)){
            model.addAttribute("errorMessage","两次输入的新密码不相同！");
            return "changeTeacherPassword";
        }
        String s = modifyPasswordService.modifyPasswordByTeachNo(number, old, new1);
        if (s.equals("-1")){
            model.addAttribute("errorMessage","您输入的工号不正确！");
            return "changeTeacherPassword";
        }
        if (s.equals("-2")){
            model.addAttribute("errorMessage","您输入的当前密码不正确！");
            return "changeTeacherPassword";
        }
        Teacher teacher = teacherService.queryTeacherByTeachno(number);
        model.addAttribute("info",teacher);
        model.addAttribute("idinfo","教师");
        return "teacherInfo";
    }

    @RequestMapping(value = "/modifyAdminPassword", method = RequestMethod.POST)
    public String modifyAdminPassword(@RequestParam("number") String number,
                                      @RequestParam("old") String old,
                                      @RequestParam("new1") String new1,
                                      @RequestParam("new2") String new2,
                                      Model model
    ) {
        if (!new1.equals(new2)){
            model.addAttribute("errorMessage","两次输入的新密码不相同！");
            return "changeAdminPassword";
        }
        String s = modifyPasswordService.modifyPasswordByAccount(number, old, new1);
        if (s.equals("-1")){
            model.addAttribute("errorMessage","您输入的工号不正确！");
            return "changeAdminPassword";
        }
        if (s.equals("-2")){
            model.addAttribute("errorMessage","您输入的当前密码不正确！");
            return "changeAdminPassword";
        }
        Admin admin = adminService.queryAdminByAccount(number);
        model.addAttribute("info",admin);
        model.addAttribute("idinfo","管理员");
        return "adminInfo";
    }
}
