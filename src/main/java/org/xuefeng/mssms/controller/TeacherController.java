package org.xuefeng.mssms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xuefeng.mssms.service.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/addScore.do", method = RequestMethod.GET)
    public String goAddScore() {
        return "addScore";
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public String addSore(@RequestParam("stuno") String stuno,
                          @RequestParam("courseName") String courseName,
                          @RequestParam("score") Float score,
                          Model model) {

        String errorMessage = teacherService.addScore(stuno, courseName, score);
        if (errorMessage.equals("添加成功！")) {
            return "teacherQueryStudentScore";
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
            return "teacherQueryStudentScore";
        }
        model.addAttribute("stuno", stuno);
        model.addAttribute("courseName", courseName);
        model.addAttribute("score", score);
        model.addAttribute("errorMessage", errorMessage);
        return "modifyScore";
    }


}
