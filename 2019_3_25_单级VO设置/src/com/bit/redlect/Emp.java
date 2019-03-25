package com.bit.redlect;

/**
 * @Author: yd
 * @Date: 2019/3/25 19:07
 * @Version 1.0
 */

/**
 * 员工信息类
 *
 *
 */
public class Emp {
    private String name ;
    private String job;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
