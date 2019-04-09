package com.bit.reflect.VO;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: yd
 * @Date: 2019/4/9 16:47
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String str="name:托尼|job:造型师";
      EmpAction empAction=new EmpAction();
      empAction.setValue(str);
        System.out.println(empAction.getEmp());

    }
}


