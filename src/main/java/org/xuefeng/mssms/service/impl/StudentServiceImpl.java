package org.xuefeng.mssms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xuefeng.mssms.entity.Student;
import org.xuefeng.mssms.entity.StudentExample;
import org.xuefeng.mssms.mapper.StudentMapper;
import org.xuefeng.mssms.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student queryStudentByStuno(String stuno) {
        Student student = studentMapper.selectStudentByStuno(stuno);
        return student;
    }

    @Override
    public List<Student> queryStudentByGraclass(String graclass) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGraclassEqualTo(graclass);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size()==0){
            return null;
        }
        return students;
    }
}
