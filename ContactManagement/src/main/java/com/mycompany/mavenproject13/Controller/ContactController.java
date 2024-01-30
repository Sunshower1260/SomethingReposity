/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject13.Controller;

import com.mycompany.mavenproject13.View.Menu;

/**
 *
 * @author ADMIN
 */
public class ContactController extends Menu{

    static String[] menuChoice = {"Add a Contact","Display all Contact","Delete a Contact","Exit"};
    
    ChoiceController choiceController = new ChoiceController();
    
    public ContactController(){
        super("Contact management", menuChoice);
    }
    
    @Override
    public void execute(int num){
        switch(num){
            case 1:
                choiceController.addContact();
                break;
            case 2:
                choiceController.displayAll();
                break;
            case 3:
                choiceController.deleteContact();
                break;
            case 4:
                System.exit(0);
        }
    }
}
