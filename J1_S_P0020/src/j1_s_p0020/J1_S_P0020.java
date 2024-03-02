/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0020;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Activate the function
        Analyze a = new Analyze();
        String s = a.inputString();
        a.getEverything(s);
        a.dislayAllInfo(s);
    }
    
}
