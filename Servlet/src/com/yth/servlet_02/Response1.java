package com.yth.servlet_02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//请求重定向
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Response1 出事了啦 请转到新的地址");
        /* 请求重定向方法一
        //设置响应状态码302 表示请求重定向
        response.setStatus(302);
        //设置响应头 新的地址
        response.setHeader("Location","http://localhost:4513/Servlet_war_exploded/response2");*/
//方法二
        response.sendRedirect("http://localhost:4513/Servlet_war_exploded/response2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
