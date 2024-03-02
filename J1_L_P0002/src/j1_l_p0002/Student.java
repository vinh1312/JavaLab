/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_l_p0002;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class Student implements Comparable<Student> {

    private String ID;
    private String studentName;
    private String semester;
    private String courseName;
    private String name;

    /**
     * Empty constructor.
     */
    public Student() {
    }

    /**
     * Constructor.
     *
     * @param ID student ID
     * @param studentName student name
     * @param semester student semester
     * @param courseName course name
     */
    public Student(String ID, String studentName, String semester, String courseName) {
        this.ID = ID;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Get ID.
     *
     * @return student ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Set the ID.
     *
     * @param ID the student ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Get the student Name.
     *
     * @return the student ID
     */
    public String getStudentName() {
        setName(studentName);
        return studentName;
    }

    /**
     * Set the student name.
     *
     * @param studentName the student name
     */
    public void setStudentName(String studentName) {
        setName(studentName);
        this.studentName = studentName;
    }

    /**
     * Get semester.
     *
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester.
     *
     * @param semester the semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the course name.
     *
     * @param courseName the course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Get Name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name from full name.
     *
     * @param name
     */
    public void setName(String name) {
        String[] fullname = name.split("\\s+");
        this.name = fullname[fullname.length - 1];
        //System.out.println("name="+fullname[fullname.length-1]);
    }

    /**
     * print the student information.
     */
    public void print() {
        System.out.printf("%-20s|%-20s|%-20s\n", studentName, semester, courseName);
    }

    /**
     * Compare name to sort
     *
     * @param s student object
     * @return the order of student
     */
    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }
}
