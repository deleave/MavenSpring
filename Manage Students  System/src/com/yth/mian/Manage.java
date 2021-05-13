package com.yth.mian;

import com.yth.bean.Student;
import com.yth.dao.StudentDAOImpl;
import com.yth.utils.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Manage
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/10 15:46
 * @Version 1.0
 **/
public class Manage {
    StudentDAOImpl dao=new StudentDAOImpl();
    Scanner sc = new Scanner(System.in);
    //package 包内可见
    void meau() throws Exception {
        String num;
        System.out.println(" *****************************");
        System.out.println(" =======欢迎进入学生信息管理系统=======");
        System.out.println(" 0.系统帮助及说明");
        System.out.println(" 1.新增学生");
        System.out.println(" 2.修改学生");
        System.out.println(" 3.删除学生");
        System.out.println(" 4.查询学生");
        System.out.println(" 5.显示所有学生信息");
        System.out.println(" 6.排序学生信息");
        System.out.println(" 7.显示系统中共有多少学生");
        System.out.println(" 8.退出该系统");
        System.out.println("******************************    ");
        System.out.println("请选择菜单编号:");
        num=sc.next();
        switch (num) {
            case "0":
                help();
                break;
            case "1":
                insert();
                break;
            case "2":
                updateStudent();
                break;
            case "3":
                delete();
                break;
            case "4":
                queryStudent();
                break;
            case "5":
                display();
                break;
            case "6":
                sort();
                break;
            case "7":
                seek();
                break;
            case "8":
                boolean flag = false;
                sc.close();
                break;
            default:
                System.out.println("请重新在0-8之间选择");
        }
    }


    public void queryStudent() {
        Connection conn=null;
        try {
             conn = JDBCUtils.getConnection();
            System.out.println("请输入查询类型");
            System.out.println("a:按照学号查询");
            System.out.println("b:按照姓名查询");
            String select = sc.next();
            if ("a".equalsIgnoreCase(select)) {

                System.out.println("请输入要查询的学生的id：");
                String id = sc.next();
                Student student = dao.getStudentById(conn, id);
                System.out.println(student);
            }else if ("b".equalsIgnoreCase(select)){
                System.out.println("请输入要查询的学生的姓名");
                String name = sc.next();
                Student student = dao.getStudentByName(conn, name);
                System.out.println(student);
            }else {
                System.out.println("输入不合法!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }



    public void delete(){
        System.out.println("请输入删除类型：");
        System.out.println("a:根据学号删除");
        System.out.println("b:根据姓名删除");
        String select = sc.next();
        if ("a".equalsIgnoreCase(select)){
            deleteById();
        }else if ("b".equalsIgnoreCase(select)){
            deleteByName();
        }else{
            System.out.println("输入有误，请退出程序后重新输入");
        }
    }

    private void deleteByName() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            System.out.println("请输入学生的姓名：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            //先查询指定准考证号的学生
            int deleteCount = dao.deleteStudentByName(conn, name);

            if (deleteCount>0){
                System.out.println("删除成功！");
            }else {
                System.out.println("查无此人！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }


    private void deleteById() {
        Connection conn = null;
        try {
             conn = JDBCUtils.getConnection();
            System.out.println("请输入学生的考号：");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();
            //先查询指定准考证号的学生
            int deleteCount = dao.deleteStudentById(conn, id);

            if (deleteCount>0){
                    System.out.println("删除成功！");
                }else {
                    System.out.println("查无此人！");
                }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }


    public void sort()  {
        Connection conn=null;
        try {
             conn = JDBCUtils.getConnection();
            System.out.println("请输入你要排序的类型：");
            System.out.println("a:按学号排序");
            System.out.println("b:按成绩排序");
            String select = sc.next();
            if ("a".equalsIgnoreCase(select)) {
                List<Student> list = dao.sortStudent(conn, "id");
                list.forEach(System.out::println);
            }else if("b".equalsIgnoreCase(select)){
                System.out.println("请输入根据那门成绩排序：");
                System.out.println("1:依照Java成绩");
                System.out.println("2:依照高数成绩");
                System.out.println("3:依照英语成绩");
                int select1 = sc.nextInt();
                if (1==select1){
                    List<Student> list = dao.sortStudent(conn, "scoreOfJava");
                    list.forEach(System.out::println);
                }else if (2==select1){
                    List<Student> list = dao.sortStudent(conn, "scoreOfMath");
                    list.forEach(System.out::println);
                }else {
                    List<Student> list = dao.sortStudent(conn, "scoreOfEnglish");
                    list.forEach(System.out::println);
                }
            }else {
                System.out.println("输入不合法!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }


    public void display()  {
        Connection conn=null;
        try {
             conn = JDBCUtils.getConnection();
            List<Student> allStudent = dao.getAllStudent(conn);
//            System.out.println(allStudent);
            allStudent.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }


    public void seek()  {
        Connection conn=null;
        try {
             conn = JDBCUtils.getConnection();
            Long count = dao.getCount(conn);
            System.out.println("当前共有"+count+"名学生");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }



    public void updateStudent()  {
        Connection conn=null;
        try {
             conn = JDBCUtils.getConnection();
            System.out.println("请输入要修改的学生的学号");
            String id = sc.next();
            System.out.println("请输入修改的学生的姓名");
            String name = sc.next();
            System.out.println("请输入修改的学生的性别");
            String gender = sc.next();
            System.out.println("请输入修改的学生的年龄");
            int age = sc.nextInt();
            System.out.println("请输入修改的学生的Java课程成绩");
            int scoreOfJava = sc.nextInt();
            System.out.println("请输入添加的学生的高数成绩");
            int scoreOfMath = sc.nextInt();
            System.out.println("请输入添加的学生的英语成绩");
            int scoreOfEnglish = sc.nextInt();
            Student student = new Student( id,name, gender, age, scoreOfJava, scoreOfMath, scoreOfEnglish);
            int updateCount = dao.updateStudent(conn,student,id);

            if (updateCount>0){
                System.out.println("修改成功！");
            }else {
                System.out.println("修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }
    }

    void help() {
        System.out.println("0.欢迎使用系统帮助！");
        System.out.println("1.初次进入系统后,请先选择增加学生信息;");
        System.out.println("2.按照菜单提示键入数字代号;");
        System.out.println("3.增加学生信息后,切记保存;");
        System.out.println("4.谢谢您的使用！");
    }


    public void insert()  {
        Connection conn=null;
        try {
             conn = JDBCUtils.getConnection();

            System.out.println("请输入添加的学生的学号");
            String id = sc.next();
            System.out.println("请输入添加的学生的姓名");
            String name = sc.next();
            System.out.println("请输入添加的学生的性别");
            String gender = sc.next();
            System.out.println("请输入添加的学生的年龄");
            int age = sc.nextInt();
            System.out.println("请输入添加的学生的Java课程成绩");
            int scoreOfJava = sc.nextInt();
            System.out.println("请输入添加的学生的高数成绩");
            int scoreOfMath = sc.nextInt();
            System.out.println("请输入添加的学生的英语成绩");
            int scoreOfEnglish = sc.nextInt();
            Student student=new Student(id,name,gender,age,scoreOfJava,scoreOfMath,scoreOfEnglish);
            int updateCount = dao.insertStudent(conn, student);
            if (updateCount>0){
                System.out.println("添加成功！");
            }else {
                System.out.println("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null,null);
        }

    }


}
