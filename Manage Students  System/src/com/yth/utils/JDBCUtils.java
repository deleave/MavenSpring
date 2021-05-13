package com.yth.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/10 15:09
 * @Version 1.0
 **/
public class JDBCUtils {


    /*
     *@ClassName JDBCUtils
     *@Description 利用Druid数据库连接池获取连接
     *@Author deleave
     *@Date 2021/5/9 23:33
     *@Param []
     **/
    private static DataSource source;
    static {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {

        Connection conn = source.getConnection();
        return conn;
    }

    @Test
    public void testConnection(){
        Connection conn =null;
        try {
             conn = JDBCUtils.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null,null);
        }

    }

    /*
     *@ClassName JDBCUtils
     *@Description 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
     *@Author deleave
     *@Date 2021/5/10 10:55
     *@Param [conn, ps]
     **/
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
   /*     try {
            DbUtils.close(conn);
            DbUtils.close(ps);
            DbUtils.close(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
//      工具类处理了异常
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }
}
