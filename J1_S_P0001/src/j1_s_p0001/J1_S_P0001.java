/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0001;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class J1_S_P0001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BubbleSort b = new BubbleSort();

        // Input number of the array
        int n = b.getNumberOfArray();

        // Generate random integer in number range input
        int[] arr = b.createArray(n);

        // Display unsorted array
        b.printUnsortArr(arr);

        // Sort by bubble sort
        b.sorting(arr);

        // Display sorted array
        b.printSortedArr(arr);
    }
}
