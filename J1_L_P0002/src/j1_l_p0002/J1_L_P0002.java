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
public class J1_L_P0002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManager s = new StudentManager();
        int n;
        do {
            n = s.printMainMenu(); //Get main menu
            switch (n) {
                case 1: //Create new student object
                    s.createStudent();
                    break;
                case 2: //Find and sort student
                    s.findAndSort();
                    break;
                case 3: //Update or delete student
                    s.updateOrDelete();
                    break;
                case 4: //Report course information of student
                    s.studentReport();
                    break;
                case 5: //End function
                    System.out.println("THANKS FOR USING MY APPLICATION!");
                    break;
            }
        } while (n != 5);
    }
}
