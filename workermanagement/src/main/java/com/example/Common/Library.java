package com.example.Common;

import java.util.Scanner;

public class Library {

    public int getInt(String prompt, int m, int n) {
        int a = -1;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt + ": ");
            try {
                String s = scanner.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }
}
