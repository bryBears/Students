package cn.bear;

import java.io.*;
import java.util.*;

import static cn.bear.FileOperation.menu;
import static cn.bear.FileOperation.readFile;

public class Test {
    static Map<String, Double> room = new HashMap<>();


    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\data2.txt");
        readFile(file);
        menu();

    }
}
