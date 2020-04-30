package org.xuefeng.mssms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xuefeng.mssms.dto.AllStudentScoreDto;
import org.xuefeng.mssms.dto.StudentAllScoreDto;
import org.xuefeng.mssms.entity.Student;
import org.xuefeng.mssms.service.ScoreService;
import org.xuefeng.mssms.service.StudentService;

import java.util.List;


@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    StudentService studentService;

    @Autowired
    ScoreService scoreService;

    @RequestMapping(value = "/queryAllScore", method = RequestMethod.GET)
    public String queryAllScore(@RequestParam("stuno") String stuno,
                                Model model) {

        List<AllStudentScoreDto> allStudentScoreDtos = scoreService.queryAstdByStuno(stuno);
        StudentAllScoreDto myAverageAndTotalScore = scoreService.getMyAverageAndTotalScore(stuno);
        model.addAttribute("list", allStudentScoreDtos);
        model.addAttribute("myAllScore", myAverageAndTotalScore);

        return "studentScore";
    }

    @RequestMapping(value = "/goQueryStudentScore", method = RequestMethod.GET)
    public String goQueryStudentScore() {

        return "teacherQueryStudentScore";
    }

    @RequestMapping(value = "/queryStudentScore", method = RequestMethod.POST)
    public String teacherQueryStudentScore(@RequestParam("stuno") String stuno,
                                           @RequestParam("courseName") String courseName,
                                           Model model) {

        List<AllStudentScoreDto> allStudentScoreDtos = scoreService.querySingleStudentScore(stuno, courseName);
        StudentAllScoreDto myAverageAndTotalScore = scoreService.getMyAverageAndTotalScore(stuno);
        Student student = studentService.queryStudentByStuno(stuno);
        model.addAttribute("myAllScore", myAverageAndTotalScore);
        model.addAttribute("list", allStudentScoreDtos);
        model.addAttribute("student", student);

        return "teacherQueryStudentScore";
    }

    @RequestMapping(value = "/goManagerQueryStudentScore", method = RequestMethod.GET)
    public String goManagerQueryStudentScore() {
        return "managerQueryStudentScore";
    }

    @RequestMapping(value = "/managerQueryStudentScore", method = RequestMethod.POST)
    public String managerQueryStudentScore(@RequestParam("stuno") String stuno,
                                           @RequestParam("courseName") String courseName,
                                           Model model) {

        List<AllStudentScoreDto> allStudentScoreDtos = scoreService.querySingleStudentScore(stuno, courseName);
        StudentAllScoreDto myAverageAndTotalScore = scoreService.getMyAverageAndTotalScore(stuno);
        Student student = studentService.queryStudentByStuno(stuno);
        model.addAttribute("myAllScore", myAverageAndTotalScore);
        model.addAttribute("list", allStudentScoreDtos);
        model.addAttribute("student", student);

        return "managerQueryStudentScore";
    }

    @RequestMapping(value = "/goStudentScoreByClassAndCourse", method = RequestMethod.GET)
    public String goStudentScoreByClassAndCourse() {
        return "studentScoreByClassAndCourse";
    }

    @RequestMapping(value = "/studentScoreByClassAndCourse", method = RequestMethod.POST)
    public String studentScoreByClassAndCourse(@RequestParam("graclass") String graclass,
                                               @RequestParam("courseName") String courseName,
                                               Model model) {

        List<AllStudentScoreDto> allStudentScoreDtos = scoreService.queryScoreByGraclassAndCourseName(graclass, courseName);
        List<AllStudentScoreDto> allStudentScoreDtos1 = scoreService.queryScoreByGraclassAndCourseName1(graclass, courseName);
        List<AllStudentScoreDto> allStudentScoreDtos2 = scoreService.queryScoreByGraclassAndCourseName2(graclass, courseName);

        List<Student> students = studentService.queryStudentByGraclass(graclass);
        model.addAttribute("list", allStudentScoreDtos);
        model.addAttribute("student", students.get(0));

        if (students.size()==2){
            model.addAttribute("list1", allStudentScoreDtos1);
            model.addAttribute("student1", students.get(1));
        }

        if (students.size()==3){
            model.addAttribute("list1", allStudentScoreDtos1);
            model.addAttribute("student1", students.get(1));

            model.addAttribute("list2", allStudentScoreDtos2);
            model.addAttribute("student2", students.get(2));
        }

        return "studentScoreByClassAndCourse";
    }


}
