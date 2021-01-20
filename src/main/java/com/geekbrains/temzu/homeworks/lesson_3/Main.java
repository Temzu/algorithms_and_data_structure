package com.geekbrains.temzu.homeworks.lesson_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (true) {
                String[] str = reader.readLine().split(" ", 2);
                switch (str[0]) {
                    case "/stop":
                        return;
                    case "/reverse":
                        System.out.println(reverse(str[1]));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String reverse(String str) {
        int len = str.length();
        String result = "";
        Stack stack = new Stack(len);
        for (int i = 0; i < len; i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            result += (char) stack.pop();
        }
        return result;
    }
}
