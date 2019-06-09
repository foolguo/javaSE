package com.bit.e_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yd
 * @Date: 2019/6/9 18:19
 * @Version 1.0
 */

/**
 * ServletConText:
 *      作用1-获取全局管理者对象
 *          获取全局参数信息

 */
@WebServlet(name = "ConTextDemo1")
public class ConTextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取全局管理者对象
        ServletContext context=this.getServletContext();
        String encoding=context.getInitParameter("encoding");
        System.out.println(encoding);


    }
}
