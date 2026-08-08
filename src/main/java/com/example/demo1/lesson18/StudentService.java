package com.example.demo1.lesson18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {

    public static final String filePath = "students.txt";
    public static List<Student> students = new ArrayList<Student>();

    public void addNewStudent(Student student) {
        students.add(student);
    }

    public Student fillNewStudentObj() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name:");
        String name = sc.next();
        System.out.println("Age:");
        int age = sc.nextInt();
        return new Student(name,"", age);
    }

//    public void saveAllToFile() {
//        try {
//            FileWriter writer = new FileWriter(filePath);
//            for (Student student : students) {
//                writer.write(student.toString() + "\n");
//            }
//            writer.close();
//            System.out.println("Students added to file successfully!");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    public void loadAllFromFile() {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filePath));
//            String line;
//            while ((line = br.readLine()) != null) {
//                Student st = resolveStudentFromLine(line);
//                addNewStudent(st);
//            }
//            br.close();
//            System.out.println("Students loaded from file successfully!");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

//    private Student resolveStudentFromLine(String line) {
//        String[] data = line.split(",");
//        int id = Integer.parseInt(data[0]);
//        String name = data[1];
//        int age = Integer.parseInt(data[2]);
//        return new Student(name, age);
//    }


}
