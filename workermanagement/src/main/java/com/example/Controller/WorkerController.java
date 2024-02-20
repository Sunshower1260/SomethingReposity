package com.example.Controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import com.example.Common.Library;
import com.example.Model.WorkerModel;
import com.example.Model.WorkerSalaryModel;
import com.example.View.Menu;

public class WorkerController extends Menu<String>{
    
    static String[] menuChoice = {"Add worker", "Increase salary", "Decrease salary", "Display"};

    protected Library library;
    Scanner scanner = new Scanner(System.in);
    Function function = new Function();

    public WorkerController() {
        super("WorkerController", menuChoice);
        library = new Library();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                function.addWorker();
                break;
            case 2:
                function.increaseSalary();
                break;
            case 3: 
                function.decreaseSalary();
                break;
            case 4:
                function.displayAdjust();
                break;
            case 5:
                System.exit(0);
        }
    }

    public class Function{

        public HashMap<Integer,WorkerModel> workerMap = new HashMap<>();

        protected ArrayList<WorkerSalaryModel> arrayList = new ArrayList<>();

        public int generateID(){
            return workerMap.size() + 1;
        }

        public void addWorker(){

            System.out.println("Enter worker name");
            String name = scanner.nextLine();
            
            int age;
            do{
            System.out.println("Enter worker age");
            age = Integer.parseInt(scanner.nextLine());
            if( 18 > age || age > 50){
                System.out.println("Invalid age try again");
            }
            }
            while( 18 > age || age > 50);
            
            int salary;
            do{
            System.out.println("Enter worker salary");
            salary = Integer.parseInt(scanner.nextLine());
            if(salary <= 0){
                System.out.println("Invalid salary try again");
            }
            }
            while (salary <= 0);
            
            System.out.println("Enter worker workLocation");
            String workLocation = scanner.nextLine();

            workerMap.put(generateID(), new WorkerModel(generateID(), name, age, salary, workLocation));
        }

        public void increaseSalary(){

            System.out.println("Input worker id");
            int searchId = Integer.parseInt(scanner.nextLine());

            WorkerModel worker = workerMap.get(searchId);

            if (worker != null) {
                int increaseAmount;
                do {
                    System.out.println("Input increase salary:");
                    increaseAmount = Integer.parseInt(scanner.nextLine());
                    if (increaseAmount < 0) {
                        System.out.println("Invalid salary increase amount. Please enter a positive value.");
                    }
                } while (increaseAmount < 0);

                int newSalary = worker.getSalary() + increaseAmount;
                worker.setSalary(newSalary);
                System.out.println("Salary of worker " + searchId + " has been increased to " + newSalary + " $");

                System.out.println("Input date modify : ");
                String date = scanner.nextLine();

                WorkerSalaryModel workerSalary = new WorkerSalaryModel(searchId, worker.getName(), worker.getAge(), newSalary, "UP", date);
                arrayList.add(workerSalary);
            } else {
                System.out.println("Worker not found with ID: " + searchId);
            }
        }

        public void decreaseSalary(){

            System.out.println("Input worker id");
            int searchId = Integer.parseInt(scanner.nextLine());

            WorkerModel worker = workerMap.get(searchId);
            
            if (worker != null) {
                int decreaseAmount;
                do {
                    System.out.println("Input decrease salary:");
                    decreaseAmount = Integer.parseInt(scanner.nextLine());
                    if (decreaseAmount < 0) {
                        System.out.println("Invalid salary increase amount. Please enter a positive value.");
                    }
                } while (decreaseAmount < 0);

                int newSalary = worker.getSalary() - decreaseAmount;
                worker.setSalary(newSalary);
                System.out.println("Salary of worker " + searchId + " has been increased to " + newSalary + " $");

                System.out.println("Input date modify : ");
                String date = scanner.nextLine();

                WorkerSalaryModel workerSalary = new WorkerSalaryModel(searchId, worker.getName(), worker.getAge(), newSalary, "UP", date);
                arrayList.add(workerSalary);
            } else {
                System.out.println("Worker not found with ID: " + searchId);
            }
        }

        public void displayAdjust(){
            System.out.println("Code Name Age Salary Status Date");
            for (WorkerSalaryModel worker : arrayList) {
                System.out.println(worker);
            }
        }
    }
}
