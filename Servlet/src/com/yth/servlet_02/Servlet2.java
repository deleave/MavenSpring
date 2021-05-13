package com.yth.servlet_02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数（材料）
        String username = request.getParameter("username");
        System.out.println("柜台2请求的参数"+username);
        //查看是否有servlet1的章
        Object key = request.getAttribute("key");
        System.out.println("是否有柜台1的章："+key);
        //处理自己的业务
        System.out.println("柜台2处理自己的业务");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
