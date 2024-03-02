/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_s_p0006;

/**
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 */
public class Fibonacci {

    private int[] sequence;

    /**
     * Constructs a new Fibonacci sequence with the specified number of terms.
     */
    public Fibonacci() {
        int n = 10;
        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = fibonacciSequence(i);
        }
    }

    /**
     * Recursively generates the i th term in the Fibonacci sequence.
     *
     * @param n the term to generate
     * @return the nth term in the Fibonacci sequence
     */
    private int fibonacciSequence(int i) {
        if (i == 0 || i == 1) {
            return i;
        } else {
            //i is the index of value, not its value
            return fibonacciSequence(i - 1) + fibonacciSequence(i - 2);
        }
    }

    /**
     * Prints the generated Fibonacci sequence to the console.
     */
    public void printSequence() {
        int count = 0;
        System.out.println("The 45 sequence Fibonacci:");
        for (int i = 0; i < sequence.length; i++) {
            if (count > 0) {
                System.out.print(", ");
            }
            System.out.print(sequence[i]);
            count++; 
        }
        System.out.println();
    }
}
