/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0019;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class Student {

    private String name; // Name of student
    private String className; // Class name of student
    private Double math; // Maths mark
    private Double physical; // Physicals mark
    private Double chemistry; // Chemistry mark
    private Double average; // Average mark of 3 subjects
    private char type; // Type of student base on average mark

    /**
     * The empty constructor.
     */
    public Student() {
    }

    /**
     * The constructor for Student
     *
     * @param name Name of student
     * @param className Class name of student
     * @param math Maths mark
     * @param physical Physicals mark
     * @param chemistry Chemistry mark
     * @param average Average mark of 3 subjects
     * @param type Type of student base on average mark
     */
    public Student(String name, String className, Double math, Double physical, Double chemistry, Double average, char type) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.average = average;
        this.type = type;
    }

    /**
     * Get the student's name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the student's name
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the student's class name
     *
     * @return the name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set the student's class name
     *
     * @param className student's class name
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get the student's Maths mark
     *
     * @return Maths mark
     */
    public Double getMath() {
        return math;
    }

    /**
     * Set the student's Maths mark
     *
     * @param math Maths mark
     */
    public void setMath(Double math) {
        this.math = math;
    }

    /**
     * Get the student's Physicals mark
     *
     * @return Physicals mark
     */
    public Double getPhysical() {
        return physical;
    }

    /**
     * Set the student's Physicals mark
     *
     * @param physical Physicals mark
     */
    public void setPhysical(Double physical) {
        this.physical = physical;
    }

    /**
     * Get the student's Chemistry mark
     *
     * @return Chemistry mark
     */
    public Double getChemistry() {
        return chemistry;
    }

    /**
     * Set the student's Chemistry mark
     *
     * @param chemistry Chemistry mark
     */
    public void setChemistry(Double chemistry) {
        this.chemistry = chemistry;
    }

    /**
     * Get the student's average mark
     *
     * @return average mark
     */
    public Double getAverage() {
        return average;
    }

    /**
     * Set the student's average mark
     *
     * @param average average mark
     */
    public void setAverage(Double average) {
        this.average = average;
    }

    /**
     * Get the student's type
     *
     * @return student's type
     */
    public char getType() {
        return type;
    }

    /**
     * Set the student's type
     *
     * @param type student's type
     */
    public void setType(char type) {
        this.type = type;
    }
}
