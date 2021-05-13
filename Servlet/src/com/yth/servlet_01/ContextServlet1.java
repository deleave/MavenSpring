package com.yth.servlet_01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       ServletContext context=getServletContext();//直接获取ServletContext对象
        System.out.println("context中获取域数据key1的值："+context.getAttribute("key1"));//未创建获取不到
        context.setAttribute("key1","value1");
        System.out.println("context中获取域数据key1的值："+context.getAttribute("key1"));
        context.setAttribute("key2","value2");
    }

}
