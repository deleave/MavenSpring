package com.yth.servlet_02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//1.从浏览器中访问Servlet1
//2.Servlet1将请求转发至Servlet2
/*
* 请求转发特点
* 1.浏览器地址栏不变
* 2.它们是一次请求
* 3.它们共享request中的数据
* 4.可以通过转发请求访问WEB-INF的内容
* 5.不可以访问工程外的资源
* */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取请求参数(材料)
        String username = request.getParameter("username");
        System.out.println("柜台1请求的参数"+username);
       //完成 加盖一个章
        request.setAttribute("key","柜台1的章");
        //请求调度 目标地址为servlet2
        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");//路径不能错否则会报错404
        //请求转发
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
