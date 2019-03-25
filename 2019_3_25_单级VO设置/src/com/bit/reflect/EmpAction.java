package com.bit.reflect;

/**
 * @Author: yd
 * @Date: 2019/3/25 20:10
 * @Version 1.0
 */

/**
 *让用户真实操作的类
 */
public class EmpAction {
    private Emp emp=new Emp();
    /**
     * 设置值
     */
    public void setValue(String value)throws Exception{
        BeanUtils.setBeanUtils(this,value);

    }

    public Emp getEmp() {
        return emp;
    }
}
