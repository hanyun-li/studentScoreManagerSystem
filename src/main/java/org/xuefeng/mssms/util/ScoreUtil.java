package org.xuefeng.mssms.util;

import org.xuefeng.mssms.entity.Score;

import java.util.List;

/**
 * @Description:
 * @Author: hanyun.li
 * @Date: 2020/4/11 15:47
 */
public class ScoreUtil {
    public static Float getMyAverageScore(List<Score> scores){
        float[] scores1 = new float[scores.size()];
        for (int i= 0;i<scores.size();i++){
            scores1[i] = scores.get(i).getScore();
        }
        return BubbleSortUtil.getAverageScore(scores1);
    }

    public static Float getMyTotalScore(List<Score> scores){
        float[] scores1 = new float[scores.size()];
        for (int i= 0;i<scores.size();i++){
            scores1[i] = scores.get(i).getScore();
        }
        float s = 0f;
        for (int i= 0;i<scores.size();i++){
            s += scores.get(i).getScore();
        }
        return s;
    }
}
