package com.yth;


    //导入包
import java.sql.*;

/*
     * 数据库连接
     */
    public class Conn {
        public static void main(String[] args) {
            Connection con;
            //jdbc驱动
            String driver="com.mysql.cj.jdbc.Driver";
            //这里我的数据库是cxxt
            String url="jdbc:mysql://localhost:3306/manage_school?&useSSL=false&serverTimezone=UTC";
            String user="root";
            String password="4513762";
            try {
                //注册JDBC驱动程序
                Class.forName(driver);
                //建立连接
                con = DriverManager.getConnection(url, user, password);
                PreparedStatement statement=con.prepareStatement("INSERT into students values (?,?,?,?,?,?,?)");
                statement.setString(1,"0512");
                statement.setString(2,"侯永涛");
                statement.setString(3,"男");
                statement.setString(4,"2000-7-18");
                statement.setString(5,"2019-9-1");
                statement.setString(6,"软件工程（卓越工程师）");
                statement.setString(7,"2410");
                if (!con.isClosed()) {
                    System.out.println("数据库连接成功");
                }
                con.close();
            } catch (ClassNotFoundException e) {
                System.out.println("数据库驱动没有安装");

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库连接失败");
            }
        }
    }


