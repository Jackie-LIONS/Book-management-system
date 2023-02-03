package com.pratice.通讯录管理系统.运行;
import com.pratice.通讯录管理系统.校验类.Varify;
import com.pratice.通讯录管理系统.菜单类.Menus;
import com.pratice.通讯录管理系统.运行类.Operation;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Start start = new Start();
        while(true){
            System.out.println("请输入账号（用户名）：");
            String userName = scanner.nextLine();
            System.out.println("请输入密码：");
            String password = scanner.nextLine();
            if(start.login(userName,password)){
                System.out.println("登录成功,欢迎使用!");
                break;
            }else{
                System.out.println("登录失败，请重新登陆!!!");
            }
        }
        start.start();
    }

    public void start(){
        Menus menus = new Menus();
        Varify varify = new Varify();
        Operation operation = new Operation();
        while(true){
            menus.mainMenu();
            int item = varify.menuVarify(1,6);
            switch (item){
                case 1:operation.addMenu();
                    break;
                case 2:operation.searchMenu();
                    break;
                case 3:operation.modifyMenu();
                    break;
                case 4 :operation.deleteMenu();
                    break;
                case 5:operation.orderMenus();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    public boolean login(String userName,String password){
        if("JackieYe".equals(userName)&&"123456".equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
