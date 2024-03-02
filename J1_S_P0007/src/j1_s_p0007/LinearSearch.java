/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0007;

import java.util.Random;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class LinearSearch {

    /**
     * Allow user to enter the length of the array and check the condition
     *
     * @return a positive integer that satisfies the given condition
     */
    public int getNumberOfArray() {
        //IOCE170144.getInteger is the function to check the input condition
        return IOCE170144.getInteger("Enter number of array: ", "The number must be a positive integer!", 1, Integer.MAX_VALUE);
    }

    /**
     * Allow user to enter the number to find in binary searching
     *
     * @return an integer that you wanna find
     */
    public int getNumberToFind() {
        //IOCE170144.getInteger is the function to check the input condition
        return IOCE170144.getInteger("Enter search value: ", "The number must be a positive integer!", 0, Integer.MAX_VALUE);
    }

    /**
     * Create an array with random positive number
     *
     * @param n is the length of the array and also the range of random numbers
     * for the array
     * @return an array of random numbers
     */
    public int[] createArray(int n) {
        //Create an array
        int[] arr = new int[n];
        //Use the random function to generate random numbers to enter the array
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(n);
        }
        return arr;
    }

    /**
     * This method prints the contents of an integer array to the console
     *
     * @param arr The integer array to be printed
     */
    public void printArr(int[] arr) {
        System.out.print("The array: ");
        System.out.print("["); // print opening bracket
        System.out.print(arr[0]); // print first element
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]); // print a comma and the next element
        }
        System.out.println("]"); // print closing bracket and newline
    }

    /**
     * This method searches for an integer element in an integer array using
     * linear search algorithm
     *
     * @param arr The integer array to be searched
     * @param x The integer element to search for in the array
     * @return The index of the element in the array, or -1 if the element is
     * not found
     */
    public int LinSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method prints the index of the target element in the array
     *
     * @param result The index of the target element in the array
     * @param x The target element that was searched for in the array
     */
    public void printIndex(int result, int x) {
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Found " + x + " at index: " + result);
        }
    }
}
