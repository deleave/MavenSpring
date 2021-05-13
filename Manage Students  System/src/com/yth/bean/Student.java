package com.yth.bean;

/**
 * @ClassName Studengt
 * @Description
 * @Author deleave
 * @Date 2021/5/10 14:15
 * @Version 1.0
 **/
public class Student {
    private String id;
    private String name;
    private String gender;
    private int age;
    private int scoreOfJava;
    private int scoreOfMath;
    private int scoreOfEnglish;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", scoreOfJava=" + scoreOfJava +
                ", scoreOfMath=" + scoreOfMath +
                ", scoreOfEnglish=" + scoreOfEnglish +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScoreOfJava(int scoreOfJava) {
        this.scoreOfJava = scoreOfJava;
    }

    public void setScoreOfMath(int scoreOfMath) {
        this.scoreOfMath = scoreOfMath;
    }

    public void setScoreOfEnglish(int scoreOfEnglish) {
        this.scoreOfEnglish = scoreOfEnglish;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getScoreOfJava() {
        return scoreOfJava;
    }

    public int getScoreOfMath() {
        return scoreOfMath;
    }

    public int getScoreOfEnglish() {
        return scoreOfEnglish;
    }

    public Student(String id, String name, String gender, int age, int scoreOfJava, int scoreOfMath, int scoreOfEnglish) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.scoreOfJava = scoreOfJava;
        this.scoreOfMath = scoreOfMath;
        this.scoreOfEnglish = scoreOfEnglish;
    }

    public Student() {
    }
}
