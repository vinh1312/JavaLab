/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0005;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountCharacter count = new CountCharacter(); // Create an instance of CountCharacter
        String s = count.getContent(); // Prompt the user to enter content and store it in 's'
        count.countWord(s); // Count the occurrences of words in 's'
        count.countChar(s); // Count the occurrences of characters in 's'
    }

}
