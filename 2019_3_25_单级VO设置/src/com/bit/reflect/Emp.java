package com.bit.reflect;

/**
 * @Author: yd
 * @Date: 2019/3/25 20:09
 * @Version 1.0
 */
public class Emp {
    private String name;
    private String job;
    private String sge;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sge='" + sge + '\'' +
                '}';
    }

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

    public String getSge() {
        return sge;
    }

    public void setSge(String sge) {
        this.sge = sge;
    }
}
