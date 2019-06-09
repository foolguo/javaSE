package com.bit.a_hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yd
 * @Date: 2019/6/9 16:07
 * @Version 1.0
 */
public class MyfirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //解决乱码
        resp.setContentType("text/html;charset=utf-8");
        //向终端输出内容
        resp.getWriter().print("这是我的第一个servlet");
    }
}
