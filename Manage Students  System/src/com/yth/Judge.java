package com.yth;

public class Judge {
    //判断输入学生的数量是否合法,非法返回false
    static boolean judgeNum(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] < 48 | ch[i] > 57)
                return false;
        }
        if (Integer.parseInt(str) < 0 | Integer.parseInt(str) > Manage.N-Manage.n)
            return false;
        return true;
    }
    //判断学号是否合法与重复,保证学号唯一,非法返回false，合法返回true
    static boolean judgeCode(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] < 48 | ch[i] > 57)
                return false;
        }
        for (int i = 0; i < Manage.n; i++) {
            if (str.equals(Manage.getCode(i)))
                return false;
        }
        return true;
    }
    //判断年龄是否正确合法，非法返回false，合法返回true
    static boolean judgeAge(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] < 48 | ch[i] > 57)
                return false;
        }
        if (Integer.parseInt(str) < 0 | Integer.parseInt(str) > 100)
            return false;
        return true;
    }
    //判断分数是否合法，非法返回false，合法返回true
    static boolean judgeScore(String str) {
        char[] ch = str.toCharArray();
        // 第一位不能为小数点
        if (ch[0] == 46)
            return false;
        for (int i = 0; i < ch.length; i++) {
            // 判断是否为小数点
            if (ch[i] != 46) {
                if (ch[i] < 48 | ch[i] > 57)
                    return false;
            }
        }
        return true;
    }
    //判断性别是否合法，非法返回false，合法返回true
    static boolean judgeSex(String str){
        if(str.equals("F") | str.equals("f") | str.equals("M") | str.equals("m"))
            return true;
        return false;
    }
}
