package com.pratice.通讯录管理系统.用户信息类;

import java.io.Serializable;

public class Users implements Serializable {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String telNum;
    private String address;

    public Users() {
    }
    public Users(String name, int age, String sex, String telNum, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNum = telNum;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\tname: " + name  +
                " age:  " + age  +
                " sex:  " + sex  +
                " telNum:   " + telNum  +
                " address:  " + address  +"\t\t";
    }
}
