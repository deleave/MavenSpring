package com.yth.servlet_02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//表单参数获取
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //        v.     getParameter()           获取请求的参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //        vi.    getParameterValues()    获取请求的参数（多个值的时候使用）
      List hobby= Arrays.asList(request.getParameterValues("hobby"));
        String sex=request.getParameter("sex");
        System.out.println("用户名："+username);
        System.out.println("密码：："+password);
        System.out.println("兴趣爱好："+hobby.toString());
        System.out.println("性别："+sex);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //        v.     getParameter()           获取请求的参数
        //post请求不能出现中文，需要设置请求体的字符串集(**需要放在doPost的第一行才有用**)
       request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //        vi.    getParameterValues()    获取请求的参数（多个值的时候使用）
        List hobby= Arrays.asList(request.getParameterValues("hobby"));
        String sex=request.getParameter("sex");
        System.out.println("用户名："+username);
        System.out.println("密码：："+password);
        System.out.println("兴趣爱好："+hobby.toString());
        System.out.println("性别："+sex);
    }
}
