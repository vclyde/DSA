package com.dsa.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] n = {11, 7, 9, 1, 2, 23, 5, 1, -1, -5, 0, -1};
        System.out.println("Before: " + Arrays.toString(n));
        countingSort(n);
        System.out.println("After : " + Arrays.toString(n));
    }

    // Counting sort for positive int
    public static void countingSort(int[] n) {

        int max = n[0], min = 0;
        // Find the maximal number and minimal number
        for (int i = 1; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
            }

            if (n[i] < min) {
                min = n[i];
            }
        }

        // Create an array of counters
        int[] pos = new int[max + 1];
        int[] neg = new int[(min * -1) + 1];

        // pos the frequencies of each number
        for (int value : n) {
            if (value >= 0) {
                pos[value]++;
            } else {
                neg[value * -1]++;
            }
        }

        int k = 0;
        // For negative numbers if there are any
        for (int i = 0; i < neg.length; i++) {
            for (int j = 0; j < neg[i]; j++) {
                n[k++] = -i;
            }
        }

        // For positive numbers
        for (int i = 0; i < pos.length; i++) {
            // Loop each pos of number i
            for (int j = 0; j < pos[i]; j++) {
                n[k++] = i;
            }
        }
    }
}
