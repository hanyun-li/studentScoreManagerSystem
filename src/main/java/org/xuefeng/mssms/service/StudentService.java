package org.xuefeng.mssms.service;

import org.xuefeng.mssms.dto.StudentScoreDto;
import org.xuefeng.mssms.entity.Student;

import java.util.List;

public interface StudentService {
    Student queryStudentByStuno(String stuno);

    List<Student> queryStudentByGraclass(String graclass);


}
