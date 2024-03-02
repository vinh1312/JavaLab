/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0019;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class StudentManagement {

    // The array to contain student's information
    private ArrayList<Student> studentList;
    // The hash map to contain the student's rank
    private HashMap<String, Double> percentTypeStudent;

    /**
     * The constructor of Student Management.
     */
    public StudentManagement() {
        studentList = new ArrayList<>();
        percentTypeStudent = new HashMap<>();
    }

    /**
     * Create student's information and add it to the array.
     */
    public void createStudent() {
        String option;
        do {
            String name = IOCE170144.getName("Enter student's name: ", "Error: Invalid name!");
            String className = IOCE170144.getString("Enter student's class name: ", "Error: Class name can't be empty!");
            double math = IOCE170144.getDouble("Enter student's math point: ", "Error: The point must be from 0 to 10", 0, 10.0);
            double physical = IOCE170144.getDouble("Enter student's physical point: ", "Error: The point must be from 0 to 10", 0, 10.0);
            double chemistry = IOCE170144.getDouble("Enter student's chemistry point: ", "Error: The point must be from 0 to 10", 0, 10.0);
            double average = (math + physical + chemistry) / 3;
            char type;
            if (average > 7.5) {// When Average greater than 7.5
                type = 'A';
            } else if (average >= 6 && average <= 7.5) { // When Average from 6 to 7.5
                type = 'B';
            } else if (average >= 4 && average < 6) { // When Average from 4 to less than 6
                type = 'C';
            } else { // When Average less than 4
                type = 'D';
            }
            studentList.add(new Student(name, className, math, physical, chemistry, average, type));
            // Ask for doing this again
            option = IOCE170144.getYesOrNo("Do you want to enter more student information?(Y/N): ", "Error:You must enter Y or N!");
        } while ("Y".equalsIgnoreCase(option));// Ask user for enter another student
    }

    /**
     * Display all student information in the list.
     */
    public void displayStudent() {
        int i = 0;
        for (Student s : studentList) {
            System.out.println("------ Student" + (++i) + " Info ------");
            System.out.println("Name: " + s.getName());
            System.out.println("Classes: " + s.getClassName());
            System.out.printf("AVG: %.1f\n", s.getAverage());
            System.out.println("Type: " + s.getType());
        }
    }

    /**
     * Get percent of student's rank.
     */
    public void getPercentTypeStudent() {
        int totalStudent = studentList.size();
        double typeA = 0; // Number of type A students
        double typeB = 0; // Number of type B students
        double typeC = 0; // Number of type C students
        double typeD = 0;
        for (Student s : studentList) {// Access everey student
            if (s.getType() == 'A') {// When type of student is A
                ++typeA;
            }
            if (s.getType() == 'B') {// When type of student is B
                ++typeB;
            }
            if (s.getType() == 'C') {// When type of student is C
                ++typeC;
            }
            if (s.getType() == 'D') {// When type of student is D
                ++typeD;
            }
        }
        percentTypeStudent.put("A", typeA / totalStudent * 100);
        percentTypeStudent.put("B", typeB / totalStudent * 100);
        percentTypeStudent.put("C", typeC / totalStudent * 100);
        percentTypeStudent.put("D", typeD / totalStudent * 100);

        //Show the classification information
        DecimalFormat DFormat = new DecimalFormat("0.00"); //Format the number
        for (String s : percentTypeStudent.keySet()) {
            String formattedPercentage = DFormat.format(percentTypeStudent.get(s));
            System.out.println(s + ": " + formattedPercentage + "%");
        }
    }

    /**
     * Activate the function.
     */
    public void displayFunction() {
        System.out.println("====== Management Student Program ======");
        createStudent();
        displayStudent();
        System.out.println("-------- Classification Info --------");
        getPercentTypeStudent();
    }
}
