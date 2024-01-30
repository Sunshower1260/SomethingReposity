/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject13.View;

import com.mycompany.mavenproject13.Common.Library;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public abstract class Menu<String> {
    
    public String title;
    public ArrayList<String> menuChoice;
    Library library = new Library();
    protected Scanner scanner;
    
    public Menu(){
        scanner = new Scanner(System.in);
        menuChoice = new ArrayList<>();
    }
    
    public Menu(String title, String[] func){
        menuChoice = new ArrayList<>();
        for (String function : func){
            menuChoice.add(function);
        }
    }
    
    public void display(){
        System.out.println(title);
        System.out.println("======================");
        for (int i = 0; i < menuChoice.size();i++){
            System.out.println((i + 1) + "." + menuChoice.get(i));
        }
    }

    public int limitation(){
        display();
        return library.getInt("Enter your choice",1,menuChoice.size());
    }

    public abstract void execute(int num);

    public void run() {
        while (true) {
            int num = limitation();
            execute(num);
            if (num > menuChoice.size()) {
                break;
            }
        }
    }  
}
