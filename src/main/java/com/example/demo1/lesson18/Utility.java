package com.example.demo1.lesson18;

public class Utility {

    static int idIndex = 1;

    public static int generateNewId() {
        int id = ++idIndex;
        return id;
    }

}
