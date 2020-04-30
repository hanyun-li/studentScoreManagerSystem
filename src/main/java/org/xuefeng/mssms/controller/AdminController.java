package org.xuefeng.mssms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xuefeng.mssms.dto.StudentScoreStatusDto;
import org.xuefeng.mssms.entity.Admin;
import org.xuefeng.mssms.service.AdminService;
import org.xuefeng.mssms.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/admin")
    public String getAdmin(Model model) {

        Admin admin = adminService.queryTest(1);

        model.addAttribute("admin", admin);
//        Admin admin = testService.getAdmin(1);
//        model.addAttribute("admin",admin);
        return "studentInfo";
    }

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/addScore.do", method = RequestMethod.GET)
    public String goAddScore() {
        return "addScore";
    }

//    @RequestMapping(value = "/adminInfo.do", method = RequestMethod.GET)
//    public String goAdminInfo() {
//        return "adminInfo";
//    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public String addSore(@RequestParam("stuno") String stuno,
                          @RequestParam("courseName") String courseName,
                          @RequestParam("score") Float score,
                          Model model) {

        String errorMessage = teacherService.addScore(stuno, courseName, score);
        if (errorMessage.equals("添加成功！")) {
            return "managerQueryStudentScore";
        }
        model.addAttribute("stuno", stuno);
        model.addAttribute("courseName", courseName);
        model.addAttribute("score", score);
        model.addAttribute("errorMessage", errorMessage);
        return "addScore";
    }

    @RequestMapping(value = "/modifyScore.do", method = RequestMethod.GET)
    public String goModifyScore() {
        return "modifyScore";
    }

    @RequestMapping(value = "/modifyScore", method = RequestMethod.POST)
    public String modifyScore(@RequestParam("stuno") String stuno,
                              @RequestParam("courseName") String courseName,
                              @RequestParam("score") Float score,
                              Model model) {

        String errorMessage = teacherService.updateScore(stuno, courseName, score);
        if (errorMessage.equals("更新成功！")) {
            return "managerQueryStudentScore";
        }
        model.addAttribute("stuno", stuno);
        model.addAttribute("courseName", courseName);
        model.addAttribute("score", score);
        model.addAttribute("errorMessage", errorMessage);
        return "modifyScore";
    }

    @RequestMapping(value = "/deleteScore", method = RequestMethod.GET)
    public String modifyScore(@RequestParam("id") Integer id,
                              Model model) {
        String errorMessage = adminService.deleteScore(id);
        model.addAttribute("errorMessage", errorMessage);
        return "managerQueryStudentScore";
    }

    @RequestMapping(value = "/queryStudentScoreStatus", method = RequestMethod.GET)
    public String modifyScore(Model model) {
        List<StudentScoreStatusDto> studentsScoreStatus = adminService.getStudentsScoreStatus();
        model.addAttribute("list", studentsScoreStatus);
        return "studentScoreStatus";
    }


}
