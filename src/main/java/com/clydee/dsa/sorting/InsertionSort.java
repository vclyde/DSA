package com.clydee.dsa.sorting;

import java.util.Arrays;

/**
 *
 * @author Clyde Velasquez
 */
public class InsertionSort {
	
    public static void main(String[] args) {

        int[] n = {11, 7, 9, 1, 2, 23, 5};
        System.out.println("Before: " + Arrays.toString(n));

        // Declares i and j here
        for (int i = 1, j; i < n.length; i++) {
            int current = n[i]; // n[1] - starts at index 1

            // j starts at 1
            // condition checks if j is greater than 0 and compares current
            // to its previous element in the array
            for (j = i; j > 0 && current < n[j - 1]; j--) {
                n[j] = n[j - 1];
            }

            // Use j
            n[j] = current;
        }

        System.out.println("After: " + Arrays.toString(n));
    }
}
