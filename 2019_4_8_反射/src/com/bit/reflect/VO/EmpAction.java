package com.bit.reflect.VO;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: yd
 * @Date: 2019/4/9 16:54
 * @Version 1.0
 */
public class EmpAction {
    private Emp emp=new Emp();
    public void setValue(String value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BeanUtil.setBeanValue(this,value);
    }
    public  Emp getEmp(){
        return emp;
    }
}
