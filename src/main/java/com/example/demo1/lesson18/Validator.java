package com.example.demo1.lesson18;

public class Validator {

    public static boolean isValidName(String name) {
        return name != null
                && !name.isBlank()
                && name.length() >= 2;
    }

    public static boolean isValidSurname(String surname) {
        return surname != null
                && !surname.isBlank()
                && surname.length() >= 2;
    }

    public static boolean isValidAge(int age) {
        return age >= 16 && age <= 100;
    }

    public static boolean isValidEmail(String email) {
        return email != null
                && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}