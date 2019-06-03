package com.bite.b_life;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yd
 * @Date: 2019/6/3 22:31
 * @Version 1.0
 */
@WebServlet(name = "LifeServlet")
/**
 * servlet的生命周期
 *      初始化  public void init(ServletConfig config)
 *      服务方法：public void service(ServletRequest req, ServletResponse res)
 * 	throws ServletException, IOException;
 *
 */
public class LifeServlet extends HttpServlet {
    public LifeServlet() {
        System.out.println("servlet对象被创建了...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet对象呗初始化了");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了Service的服务方法");
    }

    //post方式提交
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    //默认get方式提交
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用service的服务方法");
    }
}
