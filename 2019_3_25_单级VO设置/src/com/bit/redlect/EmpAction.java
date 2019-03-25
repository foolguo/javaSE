package com.bit.redlect;

/**
 * @Author: yd
 * @Date: 2019/3/25 19:26
 * @Version 1.0
 */
public class EmpAction {
    private Emp emp=new Emp();
    public void setValule(String value)throws Exception{
        BeanUtils.setBeanUtils(this,value);
    }

    public Emp getEmp() {
        return emp;
    }
}
