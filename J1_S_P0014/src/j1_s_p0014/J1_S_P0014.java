/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0014;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0014 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserDataBase u = new UserDataBase();
        //To load the data from the file "user.txt"
        u.loadUsers("user.txt");
        int n;
        do {
            n = u.menu();
            switch (n) {
                case 1:
                    //To add user name and password
                    u.addUsers();
                    break;
                case 2:
                    //To check user name and password if it correct
                    u.loginSystem();
                    break;
                case 3:
                    //End fuction and write down new passwword to the file
                    System.out.println("Thanks for using my application.");
                    u.saveUsers("user.txt");
                    break;
            }
        } while (n != 3);
    }
}
