package com.example.demo1.lesson18;

public class Student {
    private int id;
    private String name;
    private String email;
    private int age;


    public Student(String name, String email, int age) {
        this.id = Utility.generateNewId();
        this.email = email;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
