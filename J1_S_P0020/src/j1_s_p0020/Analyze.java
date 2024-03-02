/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0020;

import java.util.ArrayList;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class Analyze {

    private ArrayList<Integer> listPerfectSquare; // To contain perfect square number
    private ArrayList<Integer> listOdd; // To contain odd number
    private ArrayList<Integer> listEven; // To contain even number
    private ArrayList<Integer> listAll; // To contain all number

    /**
     * The constructor of Analyze.
     */
    public Analyze() {
        listPerfectSquare = new ArrayList<>();
        listOdd = new ArrayList<>();
        listEven = new ArrayList<>();
        listAll = new ArrayList<>();
    }

    /**
     * The function to get String.
     *
     * @return a String
     */
    public String inputString() {
        System.out.println("===== Analysis String program =====");
        return IOCE170144.getString("Input String: ", "Error: String can't be empty!");
    }

    /**
     * Get the number in the String and add it into the list.
     *
     * @param input the string inputed
     */
    public void getEverything(String input) {
        //"+" represents repetition of one or more previous characters, so "\\D+" 
        //corresponds to a sequence of one or more consecutive non-digit characters.
        //"abc123def456ghi789" -> ",123,456,789"
        //ahds12 23fjs@aqu89,55 -> ,12,23,89,55
        String number = input.replaceAll("\\D+", ",");

        //If the number string contain only one "," then cannnot use the function
        if (!",".equals(number)) {
            if (number.charAt(0) == ',') { // Remove "," at the begin of the string
                number = number.substring(1);
            }
            if (number.charAt(number.length() - 1) == ',') { // Remove "," at the end of the string
                number = number.substring(0, number.length() - 1);
            }
            //Ex: 123 987 or 548 in the listNumber
            String[] listNumber = number.split(",");

            for (String listNum : listNumber) {
                int numberCheck;
                try {
                    numberCheck = Integer.parseInt(listNum);
                } catch (NumberFormatException e) {
                    System.out.println("Error: The number in string is greater than an integer!");
                    return;
                }
                if (numberCheck % 2 != 0) { // when it is a odd number
                    listOdd.add(numberCheck);
                }
                if (numberCheck % 2 == 0) { // when it is an even number
                    listEven.add(numberCheck);
                }
                if (checkSquareNumber(numberCheck)) { // when it is a square number
                    listPerfectSquare.add(numberCheck);
                }
                listAll.add(numberCheck);
            }
        }
    }

    /**
     * Check for the square number.
     *
     * @param n integer need to check
     * @return true if it's a square number
     */
    public boolean checkSquareNumber(int n) {
        //return true
        return (int) Math.sqrt(n) * (int) Math.sqrt(n) == n;
    }

    /**
     * Display the request of the function and convert other character.
     *
     * @param input the string inputed
     */
    public void dislayAllInfo(String input) {

        System.out.println("------Result Analysis------ ");

        System.out.println("Perfect Square Numbers: " + listPerfectSquare);

        System.out.println("Odd Numbers: " + listOdd);

        System.out.println("Even Numbers: " + listEven);

        System.out.println("All Numbers: " + listAll);

        // The expression \\W stands for any non-alphanumeric character, or underscore (stands for spacial character).
        System.out.println("Uppercase: " + input.replaceAll("\\W|[0-9]|[a-z]", ""));

        // [0-9] stands for number, [A-Z] stands for upercase, [a-z] stands for lowercase
        System.out.println("Lowercase: " + input.replaceAll("\\W|[0-9]|[A-Z]", ""));

        // The expression \\w stands for any letter, digit, or underscore (stands for normal character).
        System.out.println("Special: " + input.replaceAll("\\w", ""));

        // The expression \\d stands for to any digit.
        System.out.println("All Character: " + input.replaceAll("\\d", ""));
    }
}
