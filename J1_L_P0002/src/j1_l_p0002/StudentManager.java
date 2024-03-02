/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_l_p0002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class StudentManager {

    private ArrayList<Student> studentList; //Array contains student's information

    /**
     * Constructor to initialize the array and pre-add student objects.
     */
    public StudentManager() {
        studentList = new ArrayList<>();
        studentList.add(new Student("C1", "Do Minh Thien", "Spring-22", "Java"));
        studentList.add(new Student("C2", "Do Quang Hiep", "Summer-22", ".Net"));
        studentList.add(new Student("C3", "Nguyen Xuan Cuong", "Spring-22", "C/C++"));
        studentList.add(new Student("C2", "Do Quang Hiep", "Fall-21", ".Net"));
        studentList.add(new Student("C1", "Do Minh Thien", "Fall-22", "Java"));
        studentList.add(new Student("C6", "Mai Kim Tri", "Summer-22", ".Net"));
        studentList.add(new Student("C3", "Nguyen Xuan Cuong", "Fall-22", "C/C++"));
        studentList.add(new Student("C3", "Nguyen Xuan Cuong", "Summer-22", "C/C++"));
        studentList.add(new Student("C4", "Le Lam Quynh", "Summer-22", ".Net"));
        studentList.add(new Student("C6", "Mai Kim Tri", "Spring-21", "C/C++"));
        studentList.add(new Student("C5", "Do Minh Thien", "Fall-21", "Java"));
        studentList.add(new Student("C5", "Do Minh Thien", "Summer-21", "Java"));
        studentList.add(new Student("C6", "Mai Kim Tri", "Summer-21", "C/C++"));
        studentList.add(new Student("C6", "Mai Kim Tri", "Fall-21", "C/C++"));
    }

    /**
     * Show User Interface.
     *
     * @return an integer equals a function
     */
    public int printMainMenu() {
        System.out.println("\tWELCOME TO STUDENT");
        System.out.println(" 1. Create");
        System.out.println(" 2. Find and Sort");
        System.out.println(" 3. Update/Delete");
        System.out.println(" 4. Report");
        System.out.println(" 5. Exit");
        return IOCE170144.getInteger("Please select a function: ", "Error: The function must be from 1 to 5!", 1, 5);
    }

    /**
     * Display information update menu.
     *
     * @return an integer equals a function
     */
    public int updateMenu() {
        System.out.println("\tWHICH INFORMATION YOU NEED TO UPDATE?");
        System.out.println(" 1. ID");
        System.out.println(" 2. Name");
        System.out.println(" 3. Semester");
        System.out.println(" 4. Course name");
        System.out.println(" 5. Cancel");
        return IOCE170144.getInteger("Please select a function: ", "Error: The function must be from 1 to 5!", 1, 5);
    }

    /**
     * The method used to create a new student object.
     */
    public void createStudent() {
        System.out.println("-------- ADD NEW STUDENT --------");
        String option;
        do {
            option = "n";
            String ID; //ID of student
            String studentName; //Name of student
            do {
                ID = IOCE170144.getCode("Enter student's ID: ", "Error: Invalid ID!");
                studentName = IOCE170144.getName("Enter student's name: ", "Error: Invalid name!");

                //checkStudentID(ID) == true && studentList.get(i).getStudentName().equalsIgnoreCase(studentName) == false
                //Triggered when the user enters the same ID but the name is not the same as the existing ID
                if (checkStudentID(ID) && !studentList.get(getIndexOfStudentByID(ID)).getStudentName().equalsIgnoreCase(studentName)) {
                    System.out.println("Caution: The ID is already exited, please try again!");
                }
                //Loop until the condition is wrong
            } while (checkStudentID(ID) && !studentList.get(getIndexOfStudentByID(ID)).getStudentName().equalsIgnoreCase(studentName));
            String semester = IOCE170144.getSemester("Enter student's semester: ", "Error: Invalid semester!");//Semester of student
            String courseName = IOCE170144.getCourse("Enter student's course name (Java, .Net, C/C++): ", "Error: Only three courses exist, please try again!");//Course name of student

            if (checkDuplicateStudent(ID, studentName, semester, courseName)) { //Check if it has duplicate information, it won't add new student object
                System.out.println("Caution: New student information is duplicated!");
                option = IOCE170144.getYesOrNo("Do you want to continue creating new student? ", "Error: You can only enter Y or N!"); //Ask user to do again or not
            } else {
                studentList.add(new Student(ID, studentName, semester, courseName)); //Add new student object to the array
                System.out.println("Add student success!");
            }
        } while (option.equalsIgnoreCase("y"));
    }

    /**
     * Loop through the array to get the index of the student object.
     *
     * @param ID is the ID of student
     * @return an index of student object
     */
    public int getIndexOfStudentByID(String ID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;//When cannot find any index of student object
    }

    /**
     * Loop though the array to check whenever the ID is exited or not.
     *
     * @param ID is the ID of student
     * @return true if it found and other way
     */
    public boolean checkStudentID(String ID) {
        for (Student s : studentList) {
            if (s.getID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loop though the array to find exactly the student object has duplicate
     * information.
     *
     * @param ID is student's ID
     * @param studentName is student name
     * @param semester is student's semester
     * @param courseName is student's course name
     * @return true if it found and other way
     */
    public boolean checkDuplicateStudent(String ID, String studentName, String semester, String courseName) {
        for (Student s : studentList) {
            if (s.getID().equalsIgnoreCase(ID)
                    && s.getStudentName().equalsIgnoreCase(studentName)
                    && s.getSemester().equalsIgnoreCase(semester)
                    && s.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method to print information of all students in the array list by
     * using dynamic table.
     */
    public void printData() {
        if (studentList.isEmpty()) { //When the array is empty
            System.out.println("Error: The list is emply, please try again!");
        } else {
            ArrayList<String> attributes = new ArrayList<>();
            attributes.add("No.");
            attributes.add("ID");
            attributes.add("Student Name");
            attributes.add("Semester");
            attributes.add("Course Name");
            ArrayList<Boolean> isNumbers = new ArrayList<>();
            isNumbers.add(true);
            isNumbers.add(false);
            isNumbers.add(false);
            isNumbers.add(false);
            isNumbers.add(false);
            CreateTable ct = new CreateTable(attributes, isNumbers);

            ArrayList<ArrayList<String>> dataSet = new ArrayList<>();
            ArrayList<String> no = new ArrayList<>();
            ArrayList<String> id = new ArrayList<>();
            ArrayList<String> studentName = new ArrayList<>();
            ArrayList<String> semester = new ArrayList<>();
            ArrayList<String> courseName = new ArrayList<>();
            int count = 1;
            for (Student s : studentList) {
                no.add(String.valueOf(count++));
                id.add(s.getID());
                studentName.add(s.getStudentName());
                semester.add(s.getSemester());
                courseName.add(s.getCourseName());
            }
            dataSet.add(no);
            dataSet.add(id);
            dataSet.add(studentName);
            dataSet.add(semester);
            dataSet.add(courseName);
            ct.drawTable(dataSet);
        }
    }

    /**
     * The method to find student object, print all of them and sort by
     * student's name.
     */
    public void findAndSort() {
        System.out.println("-------- FIND AND SORT --------");
        if (studentList.isEmpty()) { //When the array is empty
            System.out.println("Error: The list is emply, please try again!");
        } else {
            printData(); //Print all students information before doing other function
            String studentName = IOCE170144.getString("Enter the name of the student you want to find: ", "Error: Invalid name!");
            ArrayList<Student> listFound = studentListFindByName(studentName); //Get student who has the name that contains the input word
            if (listFound.isEmpty()) { //When there are not any student who has the name that contains the input word
                System.out.println("Caution: Couldn't find any students with the same name as the one you just entered!");
            } else {
                Collections.sort(listFound); //Sort the list that contains all students who has the name that contains the input word
                printStudentListFound(listFound); //Print all students who has the name that contains the input word
            }
        }
    }

    /**
     * Loop trough the array to get student who has the name that contains the
     * input word.
     *
     * @param studentName is the input word
     * @return an array that contains all students who have the name that
     * contains the input word
     */
    public ArrayList<Student> studentListFindByName(String studentName) {
        ArrayList<Student> studentIsFound = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(studentName.toLowerCase())) {
                studentIsFound.add(s);
            }
        }
        return studentIsFound;
    }

    /**
     * The method to update or delete the student object.
     */
    public void updateOrDelete() {
        System.out.println("-------- UPDATE / DELETE --------");
        if (studentList.isEmpty()) { //When the array is empty
            System.out.println("Error: The list is emply, please try again!");
        } else {
            printData(); //Print all students information before doing other function
            String ID = IOCE170144.getCode("Enter student's ID you want to find: ", "ID can't be empty");
            ArrayList<Student> listFound = studentListFindByID(ID);//Get student who has the ID that is same as the input ID
            if (listFound.isEmpty()) { //When cannot find any student who has the same ID as the input ID
                System.out.println("Caution: Couldn't find any students with the ID as the one you just entered!");
            } else {
                System.out.println("List student found:");
                printStudentListFound(listFound); //Print all students who have the same ID as the input ID
                String option = IOCE170144.getUpdateOrDelete("Do you want to update (U) or delete (D) student: ", "Error: you must enter (U) or (D)");
                Student studentObject = getStudentObject(listFound, ID);//Get one student in the found array who has the same ID as the input ID
                if (option.equalsIgnoreCase("u")) { //When the option is to update
                    String sID = studentObject.getID(); //Get ID of one student object from the found list
                    String sStudentName = studentObject.getStudentName(); //Get name of one student object from the found list
                    String sSemester = studentObject.getSemester(); //Get semester of one student object from the found list
                    String sCourseName = studentObject.getCourseName(); //Get course name of one student object from the found list

                    switch (updateMenu()) { //Option to update information
                        case 1: //Update ID
                            System.out.println("-------- Update ID --------");
                            String newID;
                            boolean check01 = true;
                            do {
                                newID = IOCE170144.getCode("Enter new student's ID: ", "Error: Invalid ID!");
                                if (checkStudentID(newID)) { //When the ID already exist
                                    System.out.println("Caution: ID already exists, please try again!");
                                }
                            } while (checkStudentID(newID)); //Do again when the ID already exist

                            if (countDuplicateID(ID) > 1) { //Ask for update them all if there is one student with many different imformation
                                String option01 = IOCE170144.getYesOrNo("There are many IDs with the same student, do you want to change them all? ", "Error: You must enter Y or N!");
                                if (option01.equalsIgnoreCase("y")) {
                                    check01 = false;
                                }
                            }
                            if (check01) { //When user chooses to update ID one
                                studentObject.setID(newID);
                                System.out.println("Updated student's ID successfully!");
                            } else { //When user chooses to update ID all
                                for (Student stu : studentList) {
                                    if (stu.getID().equalsIgnoreCase(ID)) {
                                        stu.setID(newID);
                                    }
                                }
                                System.out.println("All sutudent's ID updated successfully!");
                            }
                            break;
                        case 2: //Update name
                            System.out.println("-------- Update name --------");
                            String newStudentName;
                            boolean check02 = true;
                            if (countDuplicateID(ID) > 1) { //Ask for update them all if there is one student with many different imformation
                                String option02 = IOCE170144.getYesOrNo("The ID you entered has many information for the same person,\n"
                                        + "so the name must be the same, do you want to change them all? ", "Error: You must enter Y or N!");
                                if (option02.equalsIgnoreCase("n")) {
                                    System.out.println("Canceled name update!");
                                    check02 = false;
                                }
                            }
                            if (check02) { //When user chooses to update them all or there is only one student who has been found with one information
                                newStudentName = IOCE170144.getName("Enter new student's name: ", "Error: Invalid name!");
                                for (Student stu : studentList) {
                                    if (stu.getID().equalsIgnoreCase(ID)) {
                                        stu.setStudentName(newStudentName);
                                    }
                                }
                                System.out.println("Updated student's name successfully!");
                            }
                            break;
                        case 3: //Update semester
                            System.out.println("-------- Update semester --------");
                            String newSemester;
                            do {
                                newSemester = IOCE170144.getSemester("Enter new student's semester: ", "Error: Invalid semester!");
                                if (checkDuplicateStudent(sID, sStudentName, newSemester, sCourseName)) { //When the new information is duplicated
                                    System.out.println("Caution: Duplicate information, please try again!");
                                }
                            } while (checkDuplicateStudent(sID, sStudentName, newSemester, sCourseName));

                            studentObject.setSemester(newSemester); //Update student's semester
                            System.out.println("Updated semester successfully!");
                            break;
                        case 4: //Update course name
                            System.out.println("-------- Update course name --------");
                            String newCourseName;
                            do {
                                newCourseName = IOCE170144.getCourse("Enter new student's course name (Java, .Net, C/C++): ", "Error: Only three courses exist, please try again!");
                                if (checkDuplicateStudent(sID, sStudentName, sSemester, newCourseName)) { //When the new information is duplicated
                                    System.out.println("Caution: Duplicate information, please try again!");
                                }
                            } while (checkDuplicateStudent(sID, sStudentName, sSemester, newCourseName));

                            studentObject.setCourseName(newCourseName);  //Update student's course name
                            System.out.println("Updated course name successfully!");
                            break;
                        case 5: //Cancel update function
                            System.out.println("Update canceled.");
                            break;
                    }
                    printData(); //Print all student information after updating
                } else { //When the option is to delete
                    boolean checkDelete = true;
                    if (countDuplicateID(ID) > 1) { //Ask for removing all or one student
                        String optionDelete = IOCE170144.getYesOrNo("Do you want to delete all IDs that match the ID you entered? ", "Error: You must enter Y or N!");
                        if (optionDelete.equalsIgnoreCase("y")) {
                            checkDelete = false;
                        }
                    }
                    if (checkDelete) { //User chooses to delete one
                        studentList.remove(studentObject);
                        System.out.println("Information has been successfully deleted!");
                    } else { //User chooses to delete all
                        List<Student> studentsToRemove; //Temporary list to contain all students that user wants to delete
                        studentsToRemove = new ArrayList<>();
                        for (Student stu : studentList) { //Loop through the student list and take all students that user wants to delete
                            if (stu.getID().equalsIgnoreCase(ID)) {
                                studentsToRemove.add(stu);
                            }
                        }
                        studentList.removeAll(studentsToRemove); //Remove them all
                        System.out.println("All information has been successfully deleted!");
                    }
                    printData(); //Print all student information after removing
                }
            }
        }
    }

    /**
     * Loop trough the array to get student who has the ID that is same as the
     * input ID.
     *
     * @param ID is the input ID
     * @return an array that contains all students who have the ID that is same
     * as the input word
     */
    public ArrayList<Student> studentListFindByID(String ID) {
        ArrayList<Student> studentIsFound = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getID().equalsIgnoreCase(ID)) {
                studentIsFound.add(s);
            }
        }
        return studentIsFound;
    }

    /**
     * Print all students who have been found by name or ID by using dynamic
     * table.
     *
     * @param listFound is the array that contains all students who have been
     * found
     */
    public void printStudentListFound(ArrayList<Student> listFound) {
        int count = 1;
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add("No.");
        attributes.add("Student name");
        attributes.add("Semester");
        attributes.add("Course Name");
        ArrayList<Boolean> isNumbers = new ArrayList<>();
        isNumbers.add(true);
        isNumbers.add(false);
        isNumbers.add(false);
        isNumbers.add(false);
        CreateTable ct = new CreateTable(attributes, isNumbers);

        ArrayList<ArrayList<String>> dataSet = new ArrayList<>();
        ArrayList<String> no = new ArrayList<>();
        ArrayList<String> studentName = new ArrayList<>();
        ArrayList<String> semester = new ArrayList<>();
        ArrayList<String> courseName = new ArrayList<>();

        for (Student find : listFound) {
            no.add(String.valueOf(count++));
            studentName.add(find.getStudentName());
            semester.add(find.getSemester());
            courseName.add(find.getCourseName());
        }
        dataSet.add(no);
        dataSet.add(studentName);
        dataSet.add(semester);
        dataSet.add(courseName);
        ct.drawTable(dataSet);
    }

    /**
     * Get a student object from the found array and returns that object.
     *
     * @param listFound is the array that contains all students who have been
     * found
     * @param ID is student ID that user wants to update or remove
     * @return an student object
     */
    public Student getStudentObject(ArrayList<Student> listFound, String ID) {
        if (countDuplicateID(ID) > 1) { //Ask for choosing which student user wants to update or remove if there is more than one student in the found list
            int choice = IOCE170144.getInteger("Enter student you want to U/D: ", "Error: Please input number in rage [" + 1 + ", " + listFound.size() + "]", 1, listFound.size());
            return listFound.get(choice - 1);
        }
        return listFound.get(0); //Immediately returns when there is only one student
    }

    /**
     * Checks to see if more than one student's ID exists in the student list,
     * that means one student has more than one information.
     *
     * @param ID is student ID that user wants to check
     * @return the same number of IDs
     */
    public int countDuplicateID(String ID) {
        int count = 0;
        for (Student s : studentList) {
            if (s.getID().equalsIgnoreCase(ID)) {
                ++count;
            }
        }
        return count;
    }

    /**
     * Method to print a complete report of the number of courses taken by each
     * student in all semesters.
     */
    public void studentReport() {
        System.out.println("-------- STUDENT REPORT --------");
        if (studentList.isEmpty()) { //When the list is empty
            System.out.println("Error: The list is emply, please try again!");
        } else {
            ArrayList<Report> studentReportList = new ArrayList<>(); //The list that contains the report of all number of courses taken by each student in all semesters.
            for (Student stu : studentList) {
                String ID = stu.getID(); //Get student's ID to check
                String studentName = stu.getStudentName(); //Get student's name to check
                String courseName = stu.getCourseName(); //Get student's course name to check
                int index = checkReportExist(studentReportList, ID, studentName, courseName); //Check if a student's course count report already exists in the list or not
                if (index == -1) {
                    studentReportList.add(new Report(ID, studentName, courseName, 1)); //If it doesn't exist, add a new one
                } else {
                    int counter = studentReportList.get(index).getTotalCourse(); //If it already exists, take out the total course and + 1
                    studentReportList.get(index).setTotalCourse(counter + 1); //Set new total course
                }
            }
            //Sort the list by descending (bài phụ)
            Collections.sort(studentReportList, new Comparator<Report>() {
                @Override
                public int compare(Report o1, Report o2) {
                    if (o2.getTotalCourse() > o1.getTotalCourse()) {
                        return 1;
                    } else if (o2.getTotalCourse() < o1.getTotalCourse()) {
                        return -1;
                    } else {
                        return o2.getStudentName().compareTo(o1.getStudentName());
                    }
                }
            });
            //Print out the report by using dynamic table
            ArrayList<String> attributes = new ArrayList<>();
            attributes.add("No.");
            attributes.add("Student name");
            attributes.add("Course Name");
            attributes.add("Total of course");
            ArrayList<Boolean> isNumbers = new ArrayList<>();
            isNumbers.add(true);
            isNumbers.add(false);
            isNumbers.add(false);
            isNumbers.add(true);
            CreateTable ct = new CreateTable(attributes, isNumbers);

            ArrayList<ArrayList<String>> dataSet = new ArrayList<>();
            ArrayList<String> no = new ArrayList<>();
            ArrayList<String> studentName = new ArrayList<>();
            ArrayList<String> courseName = new ArrayList<>();
            ArrayList<String> totalCourse = new ArrayList<>();

            int i = 1;
            for (Report rp : studentReportList) {
                no.add(String.valueOf(i++));
                studentName.add(rp.getStudentName() + (checkSameNameButDifferentID(studentReportList, rp) ? " [" + rp.getID() + "]" : "")); //Add ID if it has student same name but different ID
                courseName.add(rp.getCourseName());
                totalCourse.add(String.valueOf(rp.getTotalCourse()));
            }
            dataSet.add(no);
            dataSet.add(studentName);
            dataSet.add(courseName);
            dataSet.add(totalCourse);
            ct.drawTable(dataSet);
        }
    }

    /**
     * Check if the student's full course report information already exists.
     *
     * @param studentReportList is the list that contains the report of all
     * number of courses taken by each student in all semesters
     * @param ID is the ID that user wants to check
     * @param studentName is the student name that user wants to check
     * @param courseName is the course name user that wants to check
     * @return the index of student's report has been found in the student
     * report list, if there is no information, it will return -1
     */
    public int checkReportExist(ArrayList<Report> studentReportList, String ID, String studentName, String courseName) {
        for (int i = 0; i < studentReportList.size(); i++) {
            if (studentReportList.get(i).getID().equalsIgnoreCase(ID)
                    && studentReportList.get(i).getStudentName().equalsIgnoreCase(studentName)
                    && studentReportList.get(i).getCourseName().equalsIgnoreCase(courseName)) { //Check all information
                return i;
            }
        }
        return -1; //When cannot find any index of report object
    }

    /**
     * Check if the student object has the same name but different ID.
     *
     * @param studentReportList is the list that contains the report of all
     * number of courses taken by each student in all semesters
     * @param rp is the object have to check
     * @return true when it exists and false when it is not
     */
    public boolean checkSameNameButDifferentID(ArrayList<Report> studentReportList, Report rp) {
        for (Report r : studentReportList) {
            if (!r.getID().equalsIgnoreCase(rp.getID()) && r.getStudentName().equalsIgnoreCase(rp.getStudentName())) {
                return true;
            }
        }
        return false;
    }
}
