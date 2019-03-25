package com.bit.redlect;

/**
 * @Author: yd
 * @Date: 2019/3/25 19:55
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args)throws Exception {
        String str="emp.name:yuisama|emp.job:Coder|emp.age:20";
        EmpAction empAction=new EmpAction();
        empAction.setValule(str);
        System.out.println(empAction.getEmp());
    }
}
