/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0007;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinearSearch lSreaSearch = new LinearSearch();
        // Input number of the array
        int n = lSreaSearch.getNumberOfArray();

        // Input number you wanna find
        int x = lSreaSearch.getNumberToFind();

        // Generate random integer in number range input
        int[] arr = lSreaSearch.createArray(n);

        // Display array
        lSreaSearch.printArr(arr);

        // Using linear search to find the index of value you wanna find
        int result = lSreaSearch.LinSearch(arr, x);
        lSreaSearch.printIndex(result, x);
    }
}
