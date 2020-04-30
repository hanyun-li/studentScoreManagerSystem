package org.xuefeng.mssms.dto;


import lombok.Data;

/**
 * @Author hanyun.li
 * @Date 2020/4/1 14:16
 * @Description
 */
@Data
public class AllStudentScoreDto {

    private Integer id;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 该学号对应学生的课程名称
     */
    private String allStudentCourseName;

    /**
     * 该学号对应学生的课程成绩
     */
    private Float allStudentScore;

    /**
     * StudentScoreDto
     */
    private StudentScoreDto studentScoreDto;

    /**
     * 错误消息提示
     */
    private String errorMessage;
}
