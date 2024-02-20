package com.example.Model;

public class WorkerSalaryModel {

    private int code;
    private String name;
    private int age;
    private int salary;
    private String status;
    private String date;

    public WorkerSalaryModel(int code, String name, int age, int salary, String status, String date) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "| " + code + " | " + name + " | " + age + " | " + salary
                + " | " + status + " | " + date + " |";
    }
}
