package com.pratice.通讯录管理系统.运行类;
import com.pratice.通讯录管理系统.储存信息.DoubleLinkedList;
import com.pratice.通讯录管理系统.存储.IoUtil;
import com.pratice.通讯录管理系统.校验类.Varify;
import com.pratice.通讯录管理系统.用户信息类.Users;
import com.pratice.通讯录管理系统.菜单类.Menus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Operation {
    private DoubleLinkedList<Users> list;
    private static final String File_Name = "express.txt";
    static {
        File file = new File(File_Name);
        if(!file.exists()){
            try {
                if(file.createNewFile()){
                    System.out.println("第一次启动项目，创建存储文件成功");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Operation() {
        this.list = new DoubleLinkedList<>();
        try {
            Object object =  IoUtil.readFile(File_Name);
            if(object != null &&object instanceof DoubleLinkedList){
                list = (DoubleLinkedList<Users>) object;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addMenu(){
        System.out.println("-*-*-*-*-*-*-*-增加信息-*-*-*-*-*-*-*-");
        Menus menus = new Menus();
        Varify varify = new Varify();
        while (true) {
            menus.addMenu();
            int item = varify.menuVarify(1,3);
            switch (item){
                case 1:
                    try {
                        this.addOperation();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2: this.showAll();
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * 添加用户信息
     */
    public void addOperation() throws IOException {
        System.out.println("添加新用户信息：");
        Varify varify = new Varify();
        String name = varify.nameVarity();
        int    age = varify.ageVarity();
        String sex = varify.sexVarity();
        String tellNum = varify.tellNumVarity();
        String address = varify.addressVarity();
        Users users = new Users(name,age,sex,tellNum,address);
        list.add(users);
        users.setId(list.getSize());
        IoUtil.writeFile(list,File_Name);      //存进文件
    }

    /**
     * 展示全部内容
     */
    public void showAll(){
        System.out.println("展示全部用户信息：");
        if(this.list.getSize() == 0){
            System.out.println("记录为空！！！");
            return;
        }else{
            for(int i = 0;i<list.getSize();i++){
                System.out.println(this.list.get(i));
            }
        }
    }
    public void searchMenu(){
        System.out.println("-----------查询子菜单----------");
        Menus menus = new Menus();
        Varify varify = new Varify();
        while(true){
            menus.searchMenu();
            int item = varify.menuVarify(1,7);
            switch (item){
                case 1: this.searchByName();
                    break;
                case 2: this.searchByAge();
                    break;
                case 3:this.searchBySex();
                    break;
                case 4:this.searchByTellNum();
                    break;
                case 5:this.searchByAdd();
                    break;
                case 6:this.showAll();
                    break;
                default:return;
            }
        }
    }

    /**
     * 按姓名查找
     */
    public void searchByName(){
        System.out.println("按姓名查找：");
       Varify varify = new Varify();
        String name = varify.nameVarity();
        boolean flag = true;
        for(int i = 0;i<this.list.getSize();i++){
            if(name.equals(list.get(i).getName()))
                System.out.println(this.list.get(i));
            flag = false;
        }
        if(flag){
            System.out.println("无此人数据！！！");
        }
    }

    /**
     * 按年龄查找
     */
    public  void searchByAge(){
        System.out.println("按年龄查找：");
        Varify varify = new Varify();
        int age = varify.ageVarity();
        boolean flag = true;
        for(int i = 0;i<this.list.getSize();i++){
            if(age == (this.list.get(i).getAge())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("无此人数据！！！");
        }
    }
    /**
     * 按性别查询记录
     */
    public void searchBySex(){
        System.out.println("按性别查找：");
       Varify varify = new Varify();
        String sex = varify.sexVarity();
        boolean flag = true;
        for(int i = 0;i<this.list.getSize();i++){
            if(sex.equals(this.list.get(i).getSex())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("无此人数据！！！");
        }
    }
    /**
     * 按电话号码前查询记录
     */
    public void searchByTellNum(){
        System.out.println("按电话号码查询：");
        Varify varify = new Varify();
        String tellNum = varify.tellNumVarity();
        boolean flag = true;
        for(int i = 0;i<this.list.getSize();i++){
            if(tellNum.equals(this.list.get(i).getTelNum())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(false){
            System.out.println("无此人数据！！！");
        }
    }
    /**
     * 按地址查询记录
     */
    public void searchByAdd(){
        Varify varify = new Varify();
        String address = varify.addressVarity();
        boolean flag = true;
        for(int i = 0;i<this.list.getSize();i++){
            if(address.equals(this.list.get(i).getAddress())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(false){
            System.out.println("无此人数据！！！");
        }
    }
  public void deleteMenu(){
      System.out.println("删除子菜单");
        Menus menus = new Menus();
        Varify varify = new Varify();
        while(true){
            menus.deleteMenu();
            int item = varify.menuVarify(1,4);
            switch (item){
                case 1: this.showAll();
                    break;
                case 2:
                    try {
                        this.deleteOperation();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        this.deleteAllOperation();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    return;
            }
        }
  }
    /**
     * 删除指定记录
     */
    public void deleteOperation() throws IOException {
       Varify varify = new Varify();
        System.out.println("请输入记录序号：");
        int itemNum = varify.menuVarify(1,this.list.getSize());
        this.list.remove(itemNum-1);        //删除记录
        for(int i = 0;i<this.list.getSize();i++){
            (this.list.get(i)).setId(i+1);
        }
        IoUtil.writeFile(list,File_Name);
        System.out.println("删除记录成功，请继续操作！！！");
    }

    /**
     * 删除全部记录
     */
    public void deleteAllOperation() throws IOException {
        this.list.removeAll();
        IoUtil.writeFile(list,File_Name);
        System.out.println("已清除所有记录,请继续操作!");
    }
    public void modifyMenu(){
        System.out.println("---------修改子菜单--------");
        Menus menus = new Menus();
        Varify varify = new Varify();
        while(true){
            menus.modifyMenu();
            int item = varify.menuVarify(1,3);
            switch (item){
                case 1:this.showAll();
                    break;
                case 2:
                    try {
                        this.modifyOperation();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:return ;
            }
        }
    }
    /**
     * 修改指定记录
     */
    public void modifyOperation() throws IOException {
        System.out.println("修改指定记录：");
        Varify  varify = new Varify();
        Menus menus = new Menus();
        System.out.println("请输入记录的序号：");
        int item = varify.menuVarify(1,this.list.getSize());//对被修改的记录的序号进行验证，可以使用对菜单项验证的方法来完成
       menus.subModifyMenu();
        int menuItem = varify.menuVarify(1,6);
        switch (menuItem){
            case 1:String name = varify.nameVarity();
                (this.list.get(item-1)).setName(name);
                IoUtil.writeFile(list,File_Name);
                break;
            case 2:int age = varify.ageVarity();
                (this.list.get(item-1)).setAge(age);
                IoUtil.writeFile(list,File_Name);
                break;
            case 3:String sex = varify.sexVarity();
                (this.list.get(item)).setSex(sex);
                IoUtil.writeFile(list,File_Name);
                break;
            case 4:String tellNum = varify.tellNumVarity();
                (this.list.get(item)).setTelNum(tellNum);
                IoUtil.writeFile(list,File_Name);
                break;
            case 5:String address = varify.addressVarity();
                (this.list.get(item)).setAddress(address);
                IoUtil.writeFile(list,File_Name);
                break;
            case 6:return;
        }
    }
    public void orderMenus(){
        System.out.println("------排序菜单-------");
        Varify varify = new Varify();
        Menus menus = new Menus();
        while(true){
            menus.orderMenu();
            int item = varify.menuVarify(1,5);
            switch (item){
                case 1: this.orderName();
                    break;
                case 2:  this.orderAge();
                    break;
                case 3:this.orderSex();
                    break;
                case 4: this.showAll();
                    break;
                default:return;
            }
        }
    }
    public void orderAge()  {
        List<Users> list = new ArrayList<>();
        for(int i = 0;i<this.list.getSize();i++){
           list.add(this.list.get(i));
        }
        Collections.sort(list,new OderByAge());
        for(int i = 0;i<list.size();i++){
            list.get(i).setId(i+1);
        }
       for(int i = 0;i<list.size();i++){
           System.out.println(list.get(i));
       }
    }
    /**
     * 按年龄排序的比较器
     */
    class OderByAge implements Comparator<Users> {

        @Override
        public int compare(Users o1, Users o2) {
            return Integer.valueOf(o1.getAge()).toString().toString().compareTo(Integer.valueOf(o2.getAge()).toString().toString());
        }
    }
    /**
     * 按用户性别排序记录
     */
    public void orderName(){
        List<Users> list = new ArrayList<>();
        for(int i = 0;i<this.list.getSize();i++){
            list.add(this.list.get(i));
        }
        Collections.sort(list,new OderByName());
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    class OderByName implements Comparator<Users>{
        @Override
        public int compare(Users o1,Users o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public void orderSex(){
        List<Users> list = new ArrayList<>();
        for(int i = 0;i<this.list.getSize();i++){
            list.add(this.list.get(i));
        }
        Collections.sort(list,new OderBySex());
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * 按性别排序的比较器
     */
    class OderBySex implements Comparator<Users>{

        @Override
        public int compare(Users o1, Users o2) {
            return o1.getSex().compareTo(o2.getSex());
        }
    }
}
