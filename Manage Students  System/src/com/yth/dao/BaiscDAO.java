package com.yth.dao;

import com.yth.bean.Student;
import com.yth.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BaiscDAO
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/10 14:24
 * @Version 1.0
 **/
public abstract class BaiscDAO <T>{
    private QueryRunner queryRunner=new QueryRunner();
    // 定义一个变量来接收泛型的类型
    private Class<T> clazz;
 
            //反射机制，获取对应的对象
            @SuppressWarnings("unchecked")
            public BaiscDAO() {//构造函数的作用：获取对应的实体类对象
               // this——表示当前类（UserDao）
               // this.getClass()——当前运行类的字节码（UserDao.class）
               // this.getClass().getGenericSuperclass()——当前运行类的父类(BaseDao<T>，以为User为例，那就是BaseDao<User>)
                Type type = this.getClass().getGenericSuperclass(); // generic 泛型
                if(type instanceof ParameterizedType){
                       // 强制转化“参数化类型”
                       ParameterizedType parameterizedType = (ParameterizedType) type;
                       // 参数化类型中可能有多个泛型参数
                       Type[] types = parameterizedType.getActualTypeArguments();
                       // 获取数据的第一个元素(User.class)
                       clazz = (Class<T>) types[0]; // com.oa.shore.entity.User.class 
                   }
           }

    /*
    *@ClassName BaiscDAO 
    *@Description 通用增删改操作
    *@Author deleave
    *@Date 2021/5/10 14:37
    *@Param [conn, sql, params]
    **/
    public int update(Connection conn,String sql,Object...params) {
        int count = 0;
        try {
            //影响了几条数据 调用了dbUtils类库
            count = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /*
    *@ClassName BaiscDAO
    *@Description 通过查询表中数据获取一个对象
     *@Author deleave
    *@Date 2021/5/10 14:37
    *@Param 
    **/
    public T getBean(Connection conn,String sql,Object...params){
        T t=null;
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<T>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    /*
    *@ClassName BaiscDAO
    *@Description 通过查询表中数据获取多个个对象
    *@Author deleave
    *@Date 2021/5/10 14:41
    *@Param
    **/
    public List<T> getBeanList(Connection conn,String sql, Object... args) {
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(clazz),
                    args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    /*
    *@ClassName BaiscDAO
    *@Description 调用sql函数返回值
    *@Author deleave
    *@Date 2021/5/10 14:43
    *@Param
    **/
    public Object getValue(Connection conn,String sql,Object...params){
        Object count=null;
        try {
            count = queryRunner.query(conn, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /*
    *@ClassName BaiscDAO
    *@Description 实现sort返回一组数据
    *@Author deleave
    *@Date 2021/5/10 21:25
    *@Param
    **/
    public List<Student> getSortedBeanList(Connection conn,String sql,Object...params){

//        queryRunner.query(conn,sql,)
        return null;
    }
}
