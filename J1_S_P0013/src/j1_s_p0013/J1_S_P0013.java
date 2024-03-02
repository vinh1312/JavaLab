/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0013;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0013 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Activate the function
        WorkerManagement w = new WorkerManagement();
        int n;
        do {
            n = w.Menu();
            switch (n) {
                //Add new worker
                case 1:
                    w.addWorker();
                    break;
                //Increase price
                case 2:
                    w.changeSalary(true);
                    break;
                //Descrease price
                case 3:
                    w.changeSalary(false);
                    break;
                //Show history
                case 4:
                    w.getInfomationSalary();
                    break;
                //End
                case 5:
                    System.out.println("Thanks for using my application.");
                    break;
            }
        } while (n != 5);
    }

}
