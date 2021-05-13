package com.yth;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //建立学生成绩管理系统
        Manage m1 = new Manage();
        //从文档中读取已有学生的信息
        m1.readFile();
        while(m1.flag){
            m1.meau();
        }
        System.out.println("您已经退出该系统");
    }
}
