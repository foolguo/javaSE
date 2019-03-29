package com.reflect;

import java.lang.reflect.Method;

/**
 * @Author: yd
 * @Date: 2019/3/29 23:38
 * @Version 1.0
 */

class Person{
    private String name;
    public  Integer age;


}
class Student extends Person{
    private String school;
    public static Integer age;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public static Integer getAge() {
        return age;
    }

    public static void setAge(Integer age) {
        Student.age = age;
    }
}
public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> cls=Class.forName("com.reflect.Student");
        Object obj=cls.newInstance();
        /*Field field1=cls.getDeclaredField("school");
        field1.setAccessible(true);
        field1.set(obj,"hhhh");
        System.out.println(field1.get(obj));
        System.out.println("-------------");
        Field[] field2=cls.getDeclaredFields();
        for(Field i: field2){
            System.out.println(i+" ");
        }*/
        Method method=cls.getDeclaredMethod("setSchool", String.class);
        method.invoke(obj,"hahaha");



    }

}
