package org.xuefeng.mssms.dto;

import lombok.Data;

/**
 * @Description:
 * @Author: hanyun.li
 * @Date: 2020/4/11 16:20
 */
@Data
public class StudentAllScoreDto {
    /**
     * 平均成绩
     */
    float myAverageScore;

    /**
     * 总成绩
     */
    float myTotalScore;
}
