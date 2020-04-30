package org.xuefeng.mssms.util;

public class BubbleSortUtil {

    /**
     * 将该科成绩从大到小依次排列
     *
     * @param allScore
     * @return
     */
    public static float[] getSortArray(float[] allScore) {

        for (int i = 1; i < allScore.length; i++) {
            for (int j = 0; j < allScore.length - i; j++) {
                if (allScore[j] < allScore[j + 1]) {
                    float centerScore = allScore[j];
                    allScore[j] = allScore[j + 1];
                    allScore[j + 1] = centerScore;
                }
            }
        }

        return allScore;
    }

    /**
     * 获得该科在班级中的排名
     *
     * @param myScore
     * @return integer
     */
    public static Integer getRankingOfScore(float myScore, float[] allScore) {

        float[] sortArray = getSortArray(allScore);
        for (int i = 0; i < sortArray.length; i++) {
            if (allScore[i] == myScore) {
                return i + 1;
            }
        }
        return -1;

    }

    /**
     * 获得该科在班级中的平均成绩
     *
     * @param allScore
     * @return
     */
    public static float getAverageScore(float[] allScore) {
//        该科成绩的总和
        long sum = 0;
//        平均成绩
        float aver = 0;
        for (float score : allScore
        ) {
            sum += score;
        }

        if (allScore.length != 0) {
            aver = (int) sum / allScore.length;
        }

        return aver;
    }

    /**
     * 获得该科最大成绩
     *
     * @param allScore
     * @return
     */
    public static Float getMaxScore(float[] allScore) {
        float[] sortScore = getSortArray(allScore);

        return sortScore[0];

    }

    /**
     * 获得该科最小成绩
     *
     * @param allScore
     * @return
     */
    public static Float getMinScore(float[] allScore) {
        float[] sortScore = getSortArray(allScore);

        return sortScore[allScore.length - 1];

    }

    /**
     * test BubbleSort
     *
     * @param args
     */
    public static void main(String[] args) {
        float[] s = new float[8];
        s[0] = 1.0f;
        s[1] = 2.0f;
        s[2] = 5.0f;
        s[3] = 4.0f;
        s[4] = 3.0f;
        s[5] = 8.0f;
        s[6] = 6.0f;
        s[7] = 7.0f;


        float[] sortArray = getSortArray(s);
        for (float score : sortArray
        ) {
            System.out.println(score);
        }
        System.out.println(
                getMaxScore(sortArray) + "" +
                        getMinScore(sortArray)
        );
    }


}
