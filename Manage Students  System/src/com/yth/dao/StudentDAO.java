package com.yth.dao;

import com.yth.bean.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDAO {
    /*
    *@ClassName StudentDAO
    *@Description 向数据库中插入一条数据
    *@Author deleave
    *@Date 2021/5/10 14:58
    *@Param [conn, student]
    **/
    int insertStudent(Connection conn, Student student);

    /*
    *@ClassName StudentDAO
    *@Description 根据学号从数据库中删除一条数据
    *@Author deleave
    *@Date 2021/5/10 14:58
    *@Param [conn, code]
    **/
    int deleteStudentById(Connection conn,String code);

    /*
    *@ClassName StudentDAO
    *@Description 根据姓名从数据库中删除一条数据
    *@Author deleave
    *@Date 2021/5/10 14:58
    *@Param [conn, name]
    **/
    int deleteStudentByName(Connection conn,String name);

    /*
    *@ClassName StudentDAO
    *@Description 根据学号查询一条记录
    *@Author deleave
    *@Date 2021/5/10 15:01
    *@Param [conn, StudentId]
    **/
    Student getStudentById(Connection conn,String StudentId);

    /*
    *@ClassName StudentDAO
    *@Description 根据姓名查询
    *@Author deleave
    *@Date 2021/5/11 16:48
    *@Param [conn, StudentName]
    **/
    Student getStudentByName(Connection conn,String StudentName);
    /*
    *@ClassName StudentDAO
    *@Description 获取所有学生信息
    *@Author deleave
    *@Date 2021/5/10 15:03
    *@Param [conn]
    **/
    List<Student> getAllStudent(Connection conn);

    /*
    *@ClassName StudentDAO
    *@Description 根据学生id从数据库更新一条数据
    *@Author deleave
    *@Date 2021/5/10 15:02
    *@Param [conn, student]
    **/
    int updateStudent(Connection conn,Student student,String id);

    /*
    *@ClassName StudentDAO
    *@Description 获取所有学生数
    *@Author deleave
    *@Date 2021/5/10 15:04
    *@Param [conn]
    **/
    Long getCount(Connection conn);

    /*
    *@ClassName StudentDAO
    *@Description 将学生排序
    *@Author deleave
    *@Date 2021/5/10 17:18
    *@Param
    **/
    List<Student> sortStudent(Connection conn,String params);


}
