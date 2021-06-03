package com.yth.servlet_02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//请求的获取
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        i.   getRequestURI()        获取请求的资源路径
        System.out.println("URI: "+request.getRequestURI());
//        ii.    getRequestURL()         取请求的统一资源定位符（绝对路径）
//        URL=ip地址+端口号+URI
        System.out.println("URL: "+request.getRequestURL());
//        iii.   getRemoteHost()        获取客户端的 ip 地址
        /*
        * 利用真实的ip访问客户端服务器   得到ip地址为本机的ip地址         192.168.0.15
        * */
        System.out.println("客户端ip地址："+request.getRemoteHost());
//        iv.    getHeader()             获取请求头
        System.out.println("获取请求头："+request.getHeader("User-Agent"));

//        vii.   getMethod()            获取请求的方式 GET 或 POST
        System.out.println("获取请求方式："+request.getMethod());
//        viii.  setAttribute(key, value); 设置域数据
//        ix.    setAttribute(key);      获取域数据
//        x.     getRequestDispatcher()   获取请求转发对象


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //请求读取URL标志的信息的首部
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

}
