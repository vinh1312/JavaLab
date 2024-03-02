/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0003;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0003 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        insertionSort i = new insertionSort();

        // Input number of the array
        int n = i.getNumberOfArray();

        // Generate random integer in number range input
        int[] arr = i.createArray(n);

        // Display unsorted array
        i.printUnsortArr(arr);

        // Sort by bubble sort
        i.sorting(arr);

        // Display sorted array
        i.printSortedArr(arr);
    }
}