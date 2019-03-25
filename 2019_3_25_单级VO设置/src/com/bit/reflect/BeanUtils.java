package com.bit.reflect;

/**
 * @Author: yd
 * @Date: 2019/3/25 20:13
 * @Version 1.0
 */

import java.lang.reflect.Method;

/**
 * 真正设置值的；类， 只要传入参数是规定的都可以就行操作
 */
public class BeanUtils {
    /**
     *
     * @param obj
     * @param setValue   传入数据类型的形式是  emp.name:haha|emp.job:xx|emp.age:xx
     */
    public static void setBeanUtils(Object obj,String setValue)throws Exception{
        String[] temp=setValue.split("\\|");
        for (int i=0;i<temp.length;i++){
            String[] result=temp[i].split(":");
            //真正要传入的值
            String realValue=result[1];
            //真实类名
            String className=result[0].split("\\.")[0];
            //真实属性名
            String attName=result[0].split("\\.")[1];
            Object realObj=getRealObject(obj,className);
            Class<?> cls=realObj.getClass();
            String realAttName="set"+initCap(attName);
            Method method=cls.getMethod(realAttName,String.class);
            method.invoke(realObj,realValue);

        }
    }

    /**
     *
     * @param obj
     * @param className
     * @return
     * @throws Exception
     */
    private static Object getRealObject(Object obj,String className)throws Exception{
        Class<?> cls=obj.getClass();
        String realAtr="get"+initCap(className);
        Method method=cls.getMethod(realAtr);
        return method.invoke(obj);

    }
    private static String initCap(String className){
        return className.substring(0,1).toUpperCase()+
                className.substring(1);

    }
}
