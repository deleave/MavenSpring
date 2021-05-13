package com.yth.servlet_01;

import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);//
        getServletConfig();
    }

    public HelloServlet2() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法被调用");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig servletConfig = super.getServletConfig();
        System.out.println("初始化参数username是："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数username是："+servletConfig.getInitParameter("hyt"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法被调用");
    }
}
