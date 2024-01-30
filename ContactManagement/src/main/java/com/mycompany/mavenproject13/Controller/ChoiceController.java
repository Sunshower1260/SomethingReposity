/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject13.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.mavenproject13.Model.Contact;

/**
 *
 * @author ADMIN
 */
class ChoiceController {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Contact> contactList;

    public ChoiceController(){
        contactList = new ArrayList<>();
    }

    public int generateId(){

        int Id = contactList.size() + 1;

        return Id;
    }

    public void addContact() {

        System.out.println("Enter full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter group:");
        String group = scanner.nextLine();
        
        System.out.println("Enter address:");
        String address = scanner.nextLine();

        System.out.println("Enter phone:");
        String phone = scanner.nextLine();

        String phoneNumber = formatPhoneNumber(phone);

        /*======================================*/
        int idx = fullName.lastIndexOf(' ');
            if (idx == -1)
                throw new IllegalArgumentException("Only a single name: " + fullName);
        String firstName = fullName.substring(0, idx);
        String lastName  = fullName.substring(idx + 1);
        /*======================================*/

        contactList.add(new Contact(generateId(), fullName, group, address, phoneNumber, lastName, firstName));    
    }

    public void displayAll() {

        System.out.println("ID\tName\t\t\tFirst Name\tLast Name\tGroup\tAddress\tPhone");

            for (Contact contact : contactList) {
                System.out.printf("%d\t%-25s%-15s%-15s%-8s%-8s%s%n",
                        contact.getId(),
                        contact.getFullName(),
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getGroup(),
                        contact.getAddress(),
                        contact.getPhone());
        }
    }

    public void deleteContact() {

        System.out.println("Enter Id contact you want to delete");
        int Id = Integer.parseInt(scanner.nextLine());

        for (Contact contact : contactList) {

            if  (contact.getId() == Id){
                contactList.remove(contact);
                return;
            }
        }
    }
    private static String formatPhoneNumber(String phoneNumber) {
        String cleanedPhoneNumber = phoneNumber.replaceAll("[^\\d]", "");

        if (cleanedPhoneNumber.length() == 10) {

            return String.format("%s-%s-%s",
                    cleanedPhoneNumber.substring(0, 3),
                    cleanedPhoneNumber.substring(3, 6),
                    cleanedPhoneNumber.substring(6));
        } else {
            
            return phoneNumber;
        }
    }
}

