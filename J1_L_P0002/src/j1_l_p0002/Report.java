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
public class Report {

    private String ID;
    private String studentName;
    private String courseName;
    private int totalCourse;

    /**
     * The empty constructor
     */
    public Report() {
    }

    /**
     * Constructor
     *
     * @param ID ID of student
     * @param studentName name of student
     * @param courseName student's course
     * @param totalCourse number of course
     */
    public Report(String ID, String studentName, String courseName, int totalCourse) {
        this.ID = ID;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    /**
     * set ID
     *
     * @return ID of student
     */
    public String getID() {
        return ID;
    }

    /**
     * set ID
     *
     * @param ID the student's ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * get name
     *
     * @return name of student
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * set name
     *
     * @param studentName the student's name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * get course
     *
     * @return the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * set the course
     *
     * @param courseName name of course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * get the number of course
     *
     * @return the number of course
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * set the number of course
     *
     * @param totalCourse the number of course
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

}
