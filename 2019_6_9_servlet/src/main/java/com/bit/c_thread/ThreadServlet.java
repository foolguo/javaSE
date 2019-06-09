package com.bit.c_thread;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yd
 * @Date: 2019/6/9 16:10
 * @Version 1.0
 */
@WebServlet(name = "ThreadServlet")
public class ThreadServlet extends HttpServlet {
    int count=1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
        //单实例多线程
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=uft-8");
        synchronized (this) {
            response.getWriter().write("当前访客是" + count + "个");
            count++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
