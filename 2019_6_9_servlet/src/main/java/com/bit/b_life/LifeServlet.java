package com.bit.b_life;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yd
 * @Date: 2019/6/9 15:11
 * @Version 1.0
 */
/*
* servlet的生命周期
*   1.初始化  init
*   2.服务方法：service
*   3.销毁方法：destory
* */
public class LifeServlet extends HttpServlet {

    //创建：new LifeServlet

    public LifeServlet() {
        System.out.println("Servlet对象被创建了");
    }

    //servlet初始化方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet对象被初始化了");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet的服务方法");
    }
    //post方式提交
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
    //get方式提交
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("默认调用servlet方法");
    }

}
