package com.dsa.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] n = {11, 7, 9, 1, 2, 23, 5, 1, 1, 0, 23};
        System.out.println("Before: " + Arrays.toString(n));
        countingSort(n);
        System.out.println("After: " + Arrays.toString(n));
    }

    // Counting sort for positive int
    public static void countingSort(int[] n) {

        int max = n[0];
        // Find the maximal number
        for (int i = 1; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
            }
        }

        // Create an array of counters
        int[] count = new int[max + 1];

        // Count the frequencies of each number
        for (int value : n) {
            count[value]++;
        }

        int k = 0;
        for (int i = 0; i < max; i++) {

            // Loop each count of number i
            for (int j = 0; j < count[i]; j++) {
                n[k++] = i;
            }
        }
    }
}
