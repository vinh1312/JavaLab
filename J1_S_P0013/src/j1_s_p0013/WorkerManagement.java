/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class WorkerManagement {

    private HashMap<String, Worker> workerList; // Save the list of workers
    private ArrayList<Worker> history; // Save the list of workers who has salary changed

    /**
     * Constructor for the WorkerManagement class.
     */
    public WorkerManagement() {
        workerList = new HashMap<>();
        history = new ArrayList<>();
    }

    /**
     * Displays the menu and returns the user's selected option.
     *
     * @return The selected option.
     */
    public int Menu() {
        System.out.println("======== Worker Management =========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit.");
        return IOCE170144.getInteger(">Selecet function: ", "Error: Function must be from 1 to 5! Try again.", 1, 5);
    }

    /**
     * Adds a new worker to the workerList.
     */
    public void addWorker() {
        System.out.println("--------- Add Worker ----------");
        String ID = IOCE170144.getString("Enter the worker's ID: ", "Error: You must enter at least one character!");
        //If the ID already exists
        if (workerList.containsKey(ID)) {
            System.out.println("Caution: ID already exists, please try again!");
        } else {
            String name = IOCE170144.getName("Enter the worker's name: ", "Error: Invalid name!");
            int age = IOCE170144.getInteger("Enter the worker's age: ", "Error: Invalid age, age must be in range 18 to 50!", 18, 50);
            double salary = IOCE170144.getDouble("Enter the worker's salary: ", "Error: Invalid salary, salary must be greater than 0", 1, Double.MAX_VALUE);
            String workLocation = IOCE170144.getLocationWork("Enter the worker's workLocation: ", "Error: You must enter at least one, and no unknown character!");
            //"ID" = key and "new Worker" = value
            workerList.put(ID, new Worker(name, age, salary, workLocation));
            System.out.println("The worker's information has been added successfully!");
        }
    }

    /**
     * Changes the salary of a worker.
     *
     * @param status Determines whether the salary should be up or down.
     */
    public void changeSalary(boolean status) {
        System.out.println("------- Up/Down Salary --------");
        if (workerList.isEmpty()) {
            System.out.println("Error: List is empty, please try again later!");
        } else {
            String ID = IOCE170144.getString("Enter the ID of the worker you want to change the price: ", "Error: You must enter at least one character!");
            if (!workerList.containsKey(ID)) {
                System.out.println("Caution: ID does not exist in the system, please try again!");
            } else {
                Double salary;
                do {
                    salary = IOCE170144.getDouble("Enter salary: ", "Error: Invalid salary! Please try again!", 0, Double.MAX_VALUE);
                    if (!status && workerList.get(ID).getSalary() - salary <= 0) {
                        System.out.println("Caution: Salary can't be a negative number!");
                    }
                    //status == false && (workerList.get(ID).getSalary() - salary) <= 0
                } while (!status && workerList.get(ID).getSalary() - salary <= 0);
                String sta;
                if (status) { // when satus is UP (status == true)
                    sta = "UP";
                    workerList.get(ID).setSalary(workerList.get(ID).getSalary() + salary);
                } else { // when satus is DOWN (status === false)
                    sta = "DOWN";
                    workerList.get(ID).setSalary(workerList.get(ID).getSalary() - salary);
                }
                history.add(new Worker(ID, workerList.get(ID).getName(), workerList.get(ID).getAge(), workerList.get(ID).getSalary(), sta));
                System.out.println("Salary has been updated successfully!");
            }
        }
    }

    /**
     * Displays information about salary changes for workers.
     */
    public void getInfomationSalary() {
        if (history.isEmpty()) {
            System.out.println("Error: There is not any history of price changes, please try again!");
        } else {
            //Sort the history acsending
            Collections.sort(history);
            System.out.println("+--------------------Display Information Salary------------------------+");
            System.out.printf("| %-6s| %-16s| %-6s| %-8s| %-7s| %-16s|\n", "ID", "Name", "Age", "Salary", "Status", "Date");
            for (Worker w : history) {
                w.showInfo();
            }
        }
    }
}
