package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

public class NameService {

    public static List<String> names = new ArrayList<String>();

    public void addNewName(String name) {
        names.add(name);
    }


    public void deleteName(String name) {
        names.remove(name);
    }

    public List<String> getNames() {
        return names;
    }

}
