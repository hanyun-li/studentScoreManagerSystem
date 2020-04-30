package org.xuefeng.mssms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.xuefeng.mssms.dto.AllStudentScoreDto;
import org.xuefeng.mssms.dto.StudentAllScoreDto;
import org.xuefeng.mssms.dto.StudentScoreDto;
import org.xuefeng.mssms.entity.Course;
import org.xuefeng.mssms.entity.Score;
import org.xuefeng.mssms.entity.Student;
import org.xuefeng.mssms.entity.StudentExample;
import org.xuefeng.mssms.mapper.CourseMapper;
import org.xuefeng.mssms.mapper.ScoreMapper;
import org.xuefeng.mssms.mapper.StudentMapper;
import org.xuefeng.mssms.service.ScoreService;
import org.xuefeng.mssms.util.BubbleSortUtil;
import org.xuefeng.mssms.util.ScoreUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    CourseMapper courseMapper;


    @Override
    public List<Score> queryScoreByStuno(String stuno) {
        List<Score> scores = scoreMapper.selectScoreByStuno(stuno);
        return scores;
    }

    @Override
    public StudentAllScoreDto getMyAverageAndTotalScore(String stuno) {
        List<Score> scores = queryScoreByStuno(stuno);
        StudentAllScoreDto studentAllScoreDto = new StudentAllScoreDto();
        studentAllScoreDto.setMyAverageScore(ScoreUtil.getMyAverageScore(scores));
        studentAllScoreDto.setMyTotalScore(ScoreUtil.getMyTotalScore(scores));
        return studentAllScoreDto;
    }

    @Override
    public List<AllStudentScoreDto> querySingleStudentScore(String stuno, String courseName) {
        List<AllStudentScoreDto> allStudentScoreDtos = queryAstdByStuno(stuno);
        List<AllStudentScoreDto> list = new ArrayList<>();
        if(!StringUtils.isEmpty(courseName)&&!StringUtils.isEmpty(stuno)){
            for (int i =0;i<allStudentScoreDtos.size();i++){
                if (allStudentScoreDtos.get(i).getAllStudentCourseName().equals(courseName)){
                    list.add(allStudentScoreDtos.get(i));
                }
            }
            return list;
        }
        return allStudentScoreDtos;
    }

    @Override
    public List<AllStudentScoreDto> queryScoreByGraclassAndCourseName(String graclass, String courseName) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGraclassEqualTo(graclass);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size()==0){
            return null;
        }

        return querySingleStudentScore(students.get(0).getStuno(),courseName);
    }

    @Override
    public List<AllStudentScoreDto> queryScoreByGraclassAndCourseName1(String graclass, String courseName) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGraclassEqualTo(graclass);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size()<=1){
            return null;
        }

        return querySingleStudentScore(students.get(1).getStuno(),courseName);
    }

    @Override
    public List<AllStudentScoreDto> queryScoreByGraclassAndCourseName2(String graclass, String courseName) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGraclassEqualTo(graclass);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size()<=2){
            return null;
        }

        return querySingleStudentScore(students.get(2).getStuno(),courseName);
    }

    @Override
    public StudentScoreDto queryStdByStuno(String stuno) {

        List<AllStudentScoreDto> allStudentScoreDtos = queryAstdByStuno(stuno);
        StudentScoreDto studentScoreDto = null;
//        全班所有学生该课程的成绩
        float[] studentScore = new float[allStudentScoreDtos.size()];
        for (int i = 0; i < allStudentScoreDtos.size(); i++) {
            studentScore[i] = allStudentScoreDtos.get(i).getAllStudentScore();
        }

        System.out.println("最大成绩" + BubbleSortUtil.getMaxScore(studentScore));
        System.out.println("最小成绩" + BubbleSortUtil.getMinScore(studentScore));
        return null;
    }

    @Override
    public List<AllStudentScoreDto> queryAstdByStuno(String stuno) {

        List<AllStudentScoreDto> list = new ArrayList<>();

//        StudentExample studentExample = new StudentExample();
//        studentExample.createCriteria().andStunoEqualTo(stuno);
//        List<Student> students = studentMapper.selectByExample(studentExample);
//        Student student = students.get(0);

//        该学生该课程的所有成绩对象
        List<Score> scoreObjects = scoreMapper.selectScoreByStuno(stuno);
//        System.out.println("该学生该课程的所有成绩对象"+scoreObjects);
        for (Score scoreObject : scoreObjects
        ) {
            StudentScoreDto studentScoreDto = querySSDByCourseid(scoreObject.getScore(), scoreObject.getCourseid());
            AllStudentScoreDto allStudentScoreDto = new AllStudentScoreDto();
            Course course = courseMapper.selectCourseByCourseid(scoreObject.getCourseid());
//            System.out.println("courseid"+course.getCoursename());
            course.getCourseid();
//            System.out.println("该学生该课程的对象"+course);
//            添加该课程名称
            allStudentScoreDto.setId(scoreObject.getId());
            allStudentScoreDto.setAllStudentCourseName(course.getCoursename());
//            添加该课程成绩
            allStudentScoreDto.setAllStudentScore(scoreObject.getScore());
            allStudentScoreDto.setStudentScoreDto(studentScoreDto);
            list.add(allStudentScoreDto);

        }

//        System.out.println(list);

        return list;
    }

    @Override
    public StudentScoreDto querySSDByCourseid(float myScore, String courseid) {

        StudentScoreDto studentScoreDto = new StudentScoreDto();
        List<Score> scores = scoreMapper.selectScoreByCourseid(courseid);
        //        全班所有学生该课程的成绩
        float[] studentScore = new float[scores.size()];

        for (int i = 0; i < scores.size(); i++) {
            studentScore[i] = scores.get(i).getScore();
        }

        studentScoreDto.setAverageScore(BubbleSortUtil.getAverageScore(studentScore));
        studentScoreDto.setMaxScore(BubbleSortUtil.getMaxScore(studentScore));
        studentScoreDto.setMinScore(BubbleSortUtil.getMinScore(studentScore));
        studentScoreDto.setRankingOfScore(BubbleSortUtil.getRankingOfScore(myScore, studentScore));

//        System.out.println("平均成绩"+BubbleSort.getAverageScore(studentScore));
//        System.out.println("最大成绩"+BubbleSort.getMaxScore(studentScore));
//        System.out.println("最小成绩"+BubbleSort.getMinScore(studentScore));


        return studentScoreDto;
    }
}
