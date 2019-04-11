package com.bit.reflect.VO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: yd
 * @Date: 2019/4/9 17:01
 * @Version 1.0
 */
public class BeanUtil {
    public static void setBeanValue(Object obj,String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] result=str.split("\\|");
        for(int i=0;i<result.length;i++){
            String name=result[i].split(":")[0];
            String value=result[i].split(":")[1];
            //获取类对象EMP-通过EmpAction调用
            Object currentObj=getObject(obj,name);
            //调用真实类的setter类
            setValue(currentObj,value,name);
        }
    }
    public static Object getObject(Object obj,String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName="getEmp";
        Class cls=obj.getClass();
        Method method=cls.getMethod(methodName);
        return method.invoke(obj);
    }
    public static void setValue(Object obj,String value,String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName="set"+intiCap(name);
        Class cls=obj.getClass();
        Method method=cls.getMethod(methodName,String.class);
        method.invoke(obj,value);

    }
    public static String intiCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

}
