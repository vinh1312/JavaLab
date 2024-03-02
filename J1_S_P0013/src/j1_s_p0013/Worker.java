/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0013;

import java.util.Date;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class Worker implements Comparable<Worker> {

    private String ID; // Worker ID
    private String name; // Worker name
    private int age; // Worker age
    private double salary; // Worker salary
    private String workLocation; // Worker's work location
    private String status; // Worker status
    private java.util.Date dateCreated; // Date the worker object was created

    /**
     * Default constructor.
     */
    public Worker() {
    }

    /**
     * Constructor with name, age, salary, and work location.
     *
     * @param name          Worker's name
     * @param age           Worker's age
     * @param salary        Worker's salary
     * @param workLocation  Worker's work location
     */
    public Worker(String name, int age, double salary, String workLocation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.dateCreated = new java.util.Date();
    }

    /**
     * Constructor with ID, name, age, salary, and status.
     *
     * @param ID            Worker ID
     * @param name          Worker's name
     * @param age           Worker's age
     * @param salary        Worker's salary
     * @param status        Worker's status
     */
    public Worker(String ID, String name, int age, double salary, String status) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.dateCreated = new java.util.Date();
    }

    /**
     * Constructor with all attributes.
     *
     * @param ID            Worker ID
     * @param name          Worker's name
     * @param age           Worker's age
     * @param salary        Worker's salary
     * @param workLocation  Worker's work location
     * @param status        Worker's status
     * @param dateCreated   Date the worker object was created
     */
    public Worker(String ID, String name, int age, double salary, String workLocation, String status, Date dateCreated) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.status = status;
        this.dateCreated = new java.util.Date();
    }

     /**
     * Get the Worker ID.
     *
     * @return Worker ID
     */
    public String getID() {
        return ID;
    }

     /**
     * Set the Worker ID.
     *
     * @param ID Worker ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Get the Worker's name.
     *
     * @return Worker's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Worker's name.
     *
     * @param name Worker's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the Worker's age.
     *
     * @return Worker's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the Worker's age.
     *
     * @param age Worker's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the Worker's salary.
     *
     * @return Worker's salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set the Worker's salary.
     *
     * @param salary Worker's salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Get the Worker's work location.
     *
     * @return Worker's work location
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Set the Worker's work location.
     *
     * @param workLocation Worker's work location
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

     /**
     * Get the Worker's status.
     *
     * @return Worker's status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the Worker's status.
     *
     * @param status Worker's status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the date the Worker object was created.
     *
     * @return Date the Worker object was created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Set the date the Worker object was created.
     *
     * @param dateCreated Date the Worker object was created
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int compareTo(Worker wrk) {
        return this.getID().compareTo(wrk.getID());
    }

    /**
     * Display the Worker's information.
     */
    public void showInfo() {
        System.out.printf("| %-5s | %-15s | %-5d | %-7.2f | %-6s | %-15tD |\n",
                ID, name, age, salary, status, dateCreated);
    }
}
