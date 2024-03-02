/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0004;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BinarySearch bSearch = new BinarySearch();
        
        // Input number of the array
        int n = bSearch.getNumberOfArray();

        // Input number you wanna find
        int x = bSearch.getNumberToFind();

        // Generate random integer in number range input
        int[] arr = bSearch.createArray(n);
        
        // Sort by bubble sort
        bSearch.bubbleSort(arr);
        
        // Display sorted array
        bSearch.printSortedArr(arr);

        // Using binary search to find the index of value you wanna find
        //result = index of x
        int result = bSearch.BinSearch(arr, x);
        bSearch.printIndex(result, x);
    }
}
