package org.xuefeng.mssms.entity;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.id
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.stuno
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    private String stuno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.stuname
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    private String stuname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.graclass
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    private String graclass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.psd
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    private String psd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.sex
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    private String sex;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.id
     *
     * @return the value of student_info.id
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.id
     *
     * @param id the value for student_info.id
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.stuno
     *
     * @return the value of student_info.stuno
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public String getStuno() {
        return stuno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.stuno
     *
     * @param stuno the value for student_info.stuno
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public void setStuno(String stuno) {
        this.stuno = stuno == null ? null : stuno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.stuname
     *
     * @return the value of student_info.stuname
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public String getStuname() {
        return stuname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.stuname
     *
     * @param stuname the value for student_info.stuname
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.graclass
     *
     * @return the value of student_info.graclass
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public String getGraclass() {
        return graclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.graclass
     *
     * @param graclass the value for student_info.graclass
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public void setGraclass(String graclass) {
        this.graclass = graclass == null ? null : graclass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.psd
     *
     * @return the value of student_info.psd
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public String getPsd() {
        return psd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.psd
     *
     * @param psd the value for student_info.psd
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public void setPsd(String psd) {
        this.psd = psd == null ? null : psd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.sex
     *
     * @return the value of student_info.sex
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.sex
     *
     * @param sex the value for student_info.sex
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}