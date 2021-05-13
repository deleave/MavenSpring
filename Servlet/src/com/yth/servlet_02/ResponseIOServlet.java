package com.yth.servlet_02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//HttpServletResponse对象与HttpServletRequest一样 每当请求进入时
// Tomcat就会创建的一个响应对象传递给Servlet去使用
// HttpServletRequest表示请求信息
// HttpServletResponse 表示响应信息
//可以通过HttpServletResponse类 来设置返回给客户端的信息
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //常用数据流的形式返回信息
       // 字节流  getOutputStream（）  常用于下载（传二进制数据）
        // 字符流 getWriter（）        常用于回传字符（常用）
        // ***二者不能同时使用 会报错
//        System.out.println( response.getCharacterEncoding());// 默认ISO-8859-1 不支持中文
        response.setCharacterEncoding("UTF-8");//只设置了服务器使用UTF-8
        //方法一  设置响应头 同时设置了服务器客户端浏览器的字符集
//        response.setHeader("Content-Type","text/html; charset=UTF-8");
        //方法二 与方法一一样 但要在输出流设置前
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("已经忘了你的名字，就在那座寂静星石。");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
