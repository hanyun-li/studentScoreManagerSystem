package org.xuefeng.mssms.service;

/**
 * @Author: hanyun.li
 * @Date: 2020/4/26 10:20
 * @Description:
 */
public interface ModifyPasswordService {
    String modifyPasswordByStuno(String stuno, String nowPassword, String afterPassword);

    String modifyPasswordByTeachNo(String teachno, String nowPassword, String afterPassword);

    String modifyPasswordByAccount(String account, String nowPassword, String afterPassword);

}
