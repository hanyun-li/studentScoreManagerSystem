package org.xuefeng.mssms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.GET)
    public String getStudentInfo(Model model){

        return "";
    }



}
