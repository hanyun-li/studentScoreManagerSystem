package org.xuefeng.mssms.dto;

import lombok.Data;

/**
 * @Author: hanyun.li
 * @Date: 2020/4/17 23:58
* @Description:
 */
@Data
public class StudentScoreStatusDto {

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 所有人数
     */
    private Integer totalPeople;

    /**
     * 及格人数
     */
    private Integer passPeople;

    /**
     * 及格率
     */
    private Integer passRate;

    /**
     * 不及格人数
     */
    private Integer noPassPeople;

    /**
     * 不及格率
     */
    private Integer noPassRate;

    /**
     * 优秀人数  成绩大于或等于90分的为优秀成绩
     */
    private Integer excellentPeople;

    /**
     * 优秀率
     */
    private Integer rateOfExcellence;
}
