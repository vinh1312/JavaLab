/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0002;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        selectionSort s = new selectionSort();

        // Input number of the array
        int n = s.getNumberOfArray();

        // Generate random integer in number range input
        int[] arr = s.createArray(n);

        // Display unsorted array
        s.printUnsortArr(arr);

        // Sort by selection sort
        s.sorting(arr);

        // Display sorted array
        s.printSortedArr(arr);
    }
}