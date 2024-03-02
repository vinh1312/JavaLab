/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0015;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        // Load file to get data
        d.readFromFile("vocabulary.txt");
        int n;
        do {
            // Get the menu
            n = d.menu();
            switch (n) {
                // Add new vocabulary
                case 1:
                    d.addVocabulary();
                    break;
                // Remove the vocabulary
                case 2:
                    d.removeVocabulary();
                    break;
                // Translate meaning
                case 3:
                    d.translate();
                    break;
                case 4:
                    // End fuction and save data to the file
                    d.writeToFile("vocabulary.txt");
                    System.out.println("Thanks for using my application.");
                    break;
            }
        } while (n != 4);
    }
}
