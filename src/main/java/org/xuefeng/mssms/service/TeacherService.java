package org.xuefeng.mssms.service;

import org.xuefeng.mssms.entity.Teacher;

public interface TeacherService {
    Teacher queryTeacherByTeachno(String teachno);

    String addScore(String stuno, String courseName, Float score);

    String updateScore(String stuno, String courseName, Float score);

}
