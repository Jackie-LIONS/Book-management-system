package com.pratice.通讯录管理系统.校验类;

import java.util.Scanner;
public class Varify {
    Scanner S = new Scanner(System.in);
    /**
     * 校验主菜单
     * @param min
     * @param max
     * @return int
     */
    public int menuVarify(int min,int max){         //菜单选项验证
        String str1 = "\\d";
        while(true){
            System.out.println("最小为"+min+","+"最大为"+max+";"+"请输入您的选择：");
            String input = S.nextLine();
            if(input.matches(str1)){
                int num = Integer.parseInt(input);
                if(num >=min&&num<=max){
                    return num;
                }else{
                    System.out.println("请输入有效数字！！！");
                }
            }else{
                System.out.println("您的输入有误，请重新输入！！！");
            }
        }
    }

    /**
     * 校验名字
     * 汉字或者字母
     * @return name
     */
    public String nameVarity(){
        String str = "[A-Za-z\\u4e00-\\u9fa5]{1,10}";
        while (true){
            System.out.println("请输入您的名字（中文/英文）：");
            String name = S.nextLine();
            if(name.matches(str)){
                return name;
            }else{
                System.out.println("您的输入有误，请重新输入!");
            }
        }
    }

    /**
     *
     * @return
     */
    public int ageVarity(){
        String str = "\\d{0,125}";
        while(true){
            System.out.println("请输入您的年龄：(0-125)");
            String age = S.nextLine();
            if(age.matches(str)){
                return Integer.parseInt(age);
            }else{
                System.out.println("输入有误，请重新输入!");
            }
        }
    }
    public String sexVarity(){
        String str = "[男|女]{1}";
        while(true){
            System.out.println("请输入您的性别：（男/女）");
            String sex = S.nextLine();
            if(sex.matches(str)){
                return sex;
            }else{
                System.out.println("输入有误，请重新输入！");
            }
        }
    }
    public String tellNumVarity(){
        String str = "(\\d{3,4}-\\d{7,8})|([1]{1}\\d{10})";
        while(true){
            System.out.println("请输入电话号码或者座机号码：");
            String inputNum = S.nextLine();
            if(inputNum .matches(str)){
                return inputNum;
            }else{
                System.out.println("您输入的电话号码有误，请重新输入：");
            }
        }
    }
    public String addressVarity(){
        String str = "[a-zA-Z\\u4e00-\\u9fa5]{1,50}";
        while(true){
            System.out.println("请输入地址：字母或者汉字");
            String inputName = S.nextLine();
            if(inputName.matches(str)){
                return inputName;
            }else{
                System.out.println("您输入的地址有误，请重新输入：");
            }
        }
    }
}
