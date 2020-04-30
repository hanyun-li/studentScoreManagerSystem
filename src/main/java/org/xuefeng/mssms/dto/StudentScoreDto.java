package org.xuefeng.mssms.dto;

import lombok.Data;

@Data
public class StudentScoreDto {
    /**
     * 课程名称
     */
//    private String coursename;

    /**
     * 该科成绩
     */
//    private Float score;

    /**
     * 该科在全班的平均成绩
     */
    private Float averageScore;

    /**
     * 该科在全班的最高成绩
     */
    private Float maxScore;

    /**
     * 该科在全班的最低成绩
     */
    private Float minScore;

    /**
     * 该科成绩在全班的排名
     */
    private Integer rankingOfScore;
}
