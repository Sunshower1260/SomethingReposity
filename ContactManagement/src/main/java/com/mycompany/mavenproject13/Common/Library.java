/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject13.Common;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Library {
    
    protected Scanner scanner;
    
    public Library(){
        scanner = new Scanner(System.in);
    }
    
    public int getInt(String promt, int m, int n) {
        int a = -1; 
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = scanner.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }
}
