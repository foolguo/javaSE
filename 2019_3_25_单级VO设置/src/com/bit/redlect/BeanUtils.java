package com.bit.redlect;

import java.lang.reflect.Method;

/**
 * @Author: yd
 * @Date: 2019/3/25 19:30
 * @Version 1.0
 */

public class BeanUtils {
    /**
     *
     * @param obj xxxAction对象  这里是指empaction
     * @param value  要设置的属性名字   emp.name:gaga|emp.name:haha
     */
    public static  void setBeanUtils(Object obj,String value)throws Exception{
        String[] result=value.split("\\|");
        for(int i=0;i<result.length;i++){
            String[] temp=result[i].split(":");
            //属性内容
            String values=temp[1];
            //属性名称
            String attribute=temp[0];
            //对象名称
            String className=attribute.split("\\.")[0];
            //属性名称
            String  ObjectName=attribute.split("\\.")[1];

            //得到Emp类的对象
            Object realObject=getObject(obj,className);
             Class<?> cls=realObject.getClass();
             String name="set"+initCap(ObjectName);
             Method method=cls.getMethod(name,String.class);
             method.invoke(realObject,values);
        }
    }
    //获取xxAction的Class对象目的是获得emp
    private static Object getObject(Object obj,String className)throws Exception{
        Class<?> cls=obj.getClass();
        String name="get"+initCap(className);
        Method m=cls.getMethod(name);
        return m.invoke(obj);
    }
    private static String initCap(String className){
        return className.substring(0,1).toUpperCase()+
                className.substring(1);
    }
}

