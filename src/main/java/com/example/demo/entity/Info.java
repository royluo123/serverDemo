package com.example.demo.entity;

public class Info {
    private String uid;
    private String nickname;
    private String gender;
    private int age;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void seUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
