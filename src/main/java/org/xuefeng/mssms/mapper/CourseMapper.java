package org.xuefeng.mssms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.xuefeng.mssms.entity.Course;
import org.xuefeng.mssms.entity.CourseExample;

public interface CourseMapper {

    Course selectCourseByCourseid(String courseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    long countByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int deleteByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    List<Course> selectByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    Course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Sat Mar 21 13:47:44 CST 2020
     */
    int updateByPrimaryKey(Course record);
}