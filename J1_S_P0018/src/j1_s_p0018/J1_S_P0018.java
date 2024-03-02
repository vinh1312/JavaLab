/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0018;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VaLidateProgram v = new VaLidateProgram();
        System.out.println("====== Validate Program ======");
        //Function to check phone number
        v.getPhoneNumber();
        //Function to check email
        v.getEmail();
        //Function to check date
        v.getDate();
    }
}
