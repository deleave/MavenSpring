package com.yth.servlet_01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
//    什么是ServletContext？
//    1.ServletContext是一个接口，它表示Servlet上下文对象。
//    2.一个web工程，只有一个ServletContext对象实例
//    3.ServletContext对象是一个域对象
//    4.ServletContext会在web部署启动的时候创建，在web工程停止的时候销毁

//    什么是域对象？
//    域对象是可以像Map一样存取数据的对象。
//    域指的是存取数据的操作范围，范围是整个web工程
//             存数据             取数据             删除数据
//    Map       put()            get()             remove()
//    域对象     setAttribute()   getAttribute()    removeAttribute()

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    ServletContext四个作用
//    1.获取web.xml配置中的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username=context.getInitParameter("username");
        System.out.println("context-param参数username的值是："+username);
        System.out.println("context-param参数context的值是："+context.getInitParameter("context"));
//    2.获取当前的工程路径， 格式：/工程路径
        System.out.println("获取当前的工程路径是："+context.getContextPath());
//    3.获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("获取工程部署后在服务器硬盘上的绝对路径:"+context.getRealPath("/"));
//    4.向Map一样存取数据
        context.setAttribute("key1","value");
        System.out.println("key2中的数据："+context.getAttribute("key2"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
