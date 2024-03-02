/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0005;

import java.util.HashMap;
import java.util.StringTokenizer;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class CountCharacter {

    private HashMap<String, Integer> wordCountMap; // Map to store word counts
    private HashMap<Character, Integer> charCountMap; // Map to store character counts

    /**
     * Default constructor for the CountCharacter class. Initializes the
     * wordCountMap and charCountMap.
     */
    public CountCharacter() {
        wordCountMap = new HashMap<>();
        charCountMap = new HashMap<>();
    }

    /**
     * Method to get the content from the user.
     *
     * @return The content entered by the user.
     */
    public String getContent() {
        return IOCE170144.getString("Enter your content: ", "Invalid content: ");
    }

    /**
     * Method to count the occurrences of words in the given content.
     *
     * @param str The content to be counted.
     */
    public void countWord(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (wordCountMap.containsKey(word)) {
                //get() will return the value of that key and give it to temp value
                int count = wordCountMap.get(word);
                //put() will overwrite (ghi đè) on the key that has exited or put new if it doesn't exit
                wordCountMap.put(word, count + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        System.out.print("{");
        int time = 0;
        //keySet() will return all keys that exiting in hashmap
        for (String word : wordCountMap.keySet()) {
            int count = wordCountMap.get(word);
            if (time > 0) {
                System.out.print(", ");
            }
            System.out.print(word + "=" + count);
            time++;
        }
        System.out.println("}");
    }

    /**
     * Method to count the occurrences of characters in the given content.
     *
     * @param str The content to be counted.
     */
    public void countChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCountMap.containsKey(c)) {
                int count = charCountMap.get(c);
                charCountMap.put(c, count + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        System.out.print("{");
        int time = 0;
        for (char c : charCountMap.keySet()) {
            int count = charCountMap.get(c);
            if (c != ' ') {
                if (time > 0) {
                    System.out.print(", ");
                }
                System.out.print(c + "=" + count);
                time++;
            }
        }
        System.out.println("}");
    }
}
