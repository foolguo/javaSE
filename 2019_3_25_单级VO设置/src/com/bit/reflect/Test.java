package com.bit.reflect;

/**
 * @Author: yd
 * @Date: 2019/3/25 20:08
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args)throws Exception {
        String str="emp.name:xx|emp.job:xx|emp.age:xx";
        EmpAction empAction=new EmpAction();
        empAction.setValue(str);
        System.out.println(empAction.getEmp());
    }
}
