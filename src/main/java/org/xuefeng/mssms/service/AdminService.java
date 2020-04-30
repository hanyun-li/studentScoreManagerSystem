package org.xuefeng.mssms.service;


import org.xuefeng.mssms.dto.StudentScoreStatusDto;
import org.xuefeng.mssms.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin getAdmin(int id);

    Admin queryTest(Integer id);

    Admin queryAdminByAccount(String account);

    String deleteScore(Integer id);

    List<StudentScoreStatusDto> getStudentsScoreStatus();
}
