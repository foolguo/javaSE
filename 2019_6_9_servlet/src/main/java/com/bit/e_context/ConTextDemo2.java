package com.bit.e_context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yd
 * @Date: 2019/6/9 18:29
 * @Version 1.0
 */
@WebServlet(name = "ConTextDemo2")
public class ConTextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向的原理：
        /*
        * 1.响应头：响应对象setHeader("location","/xxx.html")
        * 2.设置状态码 ：302 进一步请求
        * */
        response.setHeader("location","/hello.html");
        response.setStatus(302);
        System.out.println("页面跳转了....");

        //简写方式
        response.sendRedirect("/hello.html");
        System.out.println("页面跳转了");
    }
}
