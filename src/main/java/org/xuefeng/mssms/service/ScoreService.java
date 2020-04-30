package org.xuefeng.mssms.service;

import org.xuefeng.mssms.dto.AllStudentScoreDto;
import org.xuefeng.mssms.dto.StudentAllScoreDto;
import org.xuefeng.mssms.dto.StudentScoreDto;
import org.xuefeng.mssms.entity.Score;

import java.util.List;

public interface ScoreService {
    List<Score> queryScoreByStuno(String stuno);

    StudentScoreDto queryStdByStuno(String stuno);

    List<AllStudentScoreDto> queryAstdByStuno(String stuno);

    StudentScoreDto querySSDByCourseid(float myScore,String courseid);

    StudentAllScoreDto getMyAverageAndTotalScore(String stuno);

    List<AllStudentScoreDto> querySingleStudentScore(String stuno,String courseName);

    List<AllStudentScoreDto> queryScoreByGraclassAndCourseName(String graclass,String courseName);
    List<AllStudentScoreDto> queryScoreByGraclassAndCourseName1(String graclass,String courseName);
    List<AllStudentScoreDto> queryScoreByGraclassAndCourseName2(String graclass,String courseName);

}
