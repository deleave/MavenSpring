package com.yth.dao;

import com.yth.bean.Student;
import com.yth.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {

    StudentDAOImpl dao=new StudentDAOImpl();
    @org.junit.jupiter.api.Test
    void insertStudent() {
        Connection conn=null;
        try {

            conn = JDBCUtils.getConnection();
            Student student = new Student("201924100512", "侯永涛", "男", 20, 88, 87, 99);
            int updateCount = dao.insertStudent(conn, student);
            if (updateCount>0)
            System.out.println("添加成功");
            else
                System.out.println("添加失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }

    @org.junit.jupiter.api.Test
    void deleteStudentById() {
    }

    @org.junit.jupiter.api.Test
    void deleteStudentByName() {
    }

    @org.junit.jupiter.api.Test
    void getStudentById() {
    }

    @org.junit.jupiter.api.Test
    void getAllStudent() {
    }

    @org.junit.jupiter.api.Test
    void updateStudent() {
    }

    @org.junit.jupiter.api.Test
    void getCount() {
    }
}