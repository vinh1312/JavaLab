/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0004;

import java.util.Random;
import ultil.IOCE170144;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class BinarySearch {

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
     * Use the principle of bubble sort to sort the array from smallest to
     * largest
     *
     * @param arr is the array that has been generated with random positive
     * numbers
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // Swap array [i] and array [j] if [i] is largest than [j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Used to print out the elements in the array that has been sorted
     *
     * @param arr is the array of random positive numbers have been sorted
     */
    public void printSortedArr(int[] arr) {
        System.out.print("Sorted array: ");
        System.out.print("[");
        // Print the first element [0] to avoid a comma at the end of the print
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("]");
    }

    /**
     * Use binary search algorithm to find the index of an element in a sorted
     * array. If the element is not found in the array, return -1
     *
     * @param arr the input array to be searched
     * @param x the element to be searched for
     * @return the index of the element in the array, or -1 if not found
     */
    public int BinSearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;

        // Browse the array using binary search algorithm
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the middle element of the search segment is equal to x, return the index of that element
            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                left = mid + 1;
            } else { // Otherwise, if the middle element of the search segment is greater than x, skip the last half of the segment
                right = mid - 1;
            }
        }

        // If no element is found in the array, return -1
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