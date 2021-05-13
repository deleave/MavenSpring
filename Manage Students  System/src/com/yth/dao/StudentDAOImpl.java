package com.yth.dao;

import com.yth.bean.Student;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName StudentDAOImpl
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/10 15:06
 * @Version 1.0
 **/
public class StudentDAOImpl extends BaiscDAO<Student> implements StudentDAO{
    @Override
    public int insertStudent(Connection conn, Student student) {
        String sql="insert into manage_student.students(id,name,gender,age, scoreOfJava, scoreOfMath, scoreOfEnglish)values(?,?,?,?,?,?,?) ";
        int updateCount = update(conn, sql, student.getId(), student.getName(), student.getGender(), student.getAge(), student.getScoreOfJava(), student.getScoreOfMath(), student.getScoreOfEnglish());
        return updateCount;
    }


    @Override
    public int deleteStudentById(Connection conn, String Id) {
        String sql="delete from manage_student.students where id=?";
        int updateCount = update(conn, sql, Id);
        return updateCount;
    }

    @Override
    public int deleteStudentByName(Connection conn, String name) {
        String sql="delete from manage_student.students where name=?";
        int updateCount = update(conn, sql, name);
        return updateCount;
    }

    @Override
    public Student getStudentById(Connection conn, String StudentId) {
        String sql="select id,name,gender,age, scoreOfJava, scoreOfMath, scoreOfEnglish " +
                "from manage_student.students where id=?";
        Student stu =  getBean(conn, sql, StudentId);
      return stu;
    }

    @Override
    public Student getStudentByName(Connection conn, String StudentName) {
        String sql="select id,name,gender,age, scoreOfJava, scoreOfMath, scoreOfEnglish " +
                " from manage_student.students where name=?";
        Student stu = getBean(conn, sql, StudentName);
        return stu;
    }

    @Override
    public List<Student> getAllStudent(Connection conn) {
        String sql="select id,name,gender,age, scoreOfJava, scoreOfMath, scoreOfEnglish from manage_student.students ";
        List<Student> list =  getBeanList(conn,sql);
        return list;

    }

    @Override
    public int updateStudent(Connection conn, Student student,String id) {
        String sql="update manage_student.students set  name=?,gender=?,age=?, scoreOfJava=?, scoreOfMath=?, scoreOfEnglish=? where id=?";
        int updateCount = update(conn, sql,student.getName(), student.getGender(), student.getAge(),
                student.getScoreOfJava(), student.getScoreOfMath(), student.getScoreOfEnglish(),id);
        return updateCount;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select Count(*) from manage_student.students";
        Long count = (Long) getValue(conn, sql);
        return count;
    }

    @Override
    public List<Student> sortStudent(Connection conn,String params) {
        String sql="select id,name,gender,age, scoreOfJava, scoreOfMath, scoreOfEnglish from manage_student.students order by "+params;
        List<Student> list = getBeanList(conn, sql);
        return list;
    }

}
