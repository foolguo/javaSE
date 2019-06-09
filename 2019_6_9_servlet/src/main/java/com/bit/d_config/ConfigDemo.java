package com.bit.d_config;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.Enumeration;

/**
 * @Author: yd
 * @Date: 2019/6/9 17:36
 * @Version 1.0
 */
public class ConfigDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * 在doGet方法中获取ServletConfig对象
         *  在配置文件中配置<param-name>
         *
         *  HttpServlet的父类中声明了  ServletConfig对象
         * */
        /*
         * HttpServletRequest：封装一些方法：会话技术有关
         *      getSession():获取Session域对象
         *      getCookies():获取cookie数组(cookie信息)
         * */
        ServletConfig servletConfig=super.getServletConfig();
        //获取Servlet中的初始化参数
        //通过初始化参数名称获取参数值

        //优点作为了配置文件，可以在配置文件直接修改
       String path=servletConfig.getInitParameter("path");

        BufferedReader br=new BufferedReader(new FileReader(path));
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }







     /*   //读取磁盘上的内容  e:/aa.txt:将内容输出到控制台
        BufferedReader br=new BufferedReader(new FileReader("e:/aaa.txt"));
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        上面这种方法的弊端是如果路径一变要不停的变更路径*/



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
