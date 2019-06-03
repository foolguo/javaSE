package com.bite.a_hello;

/**
 * @Author: yd
 * @Date: 2019/6/3 21:43
 * @Version 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义类继承自HttpServlet
 */
public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //响应解决乱码
        resp.setContentType("text/html;charset=utf-8");
        //向浏览器输出内容
        resp.getWriter().print("这时我的第一个Servlet");

    }
}
