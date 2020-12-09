package com.vclyde.dsa.sorting;

import java.util.Arrays;

/**
 * @author Clyde Velasquez
 */
public class BubbleSort {

    public static void main(String[] args) {

        System.out.println("Bubble sort");
        long ave = 0;
        for (int i = 0; i < 100000; i++) {
            int[] n = Util.array();
            System.out.println("Before: " + Arrays.toString(n));
            long start = System.nanoTime();
            bubbleSort(n);
            long end = System.nanoTime();
            System.out.println("After:  " + Arrays.toString(n));
            ave += (end - start);
        }
        System.out.println(ave/100000);

        int[] n2 = Util.array();
        System.out.println("Before: " + Arrays.toString(n2));
        bubbleSort2(n2);
        System.out.println("After:  " + Arrays.toString(n2));

        int[] n3 = Util.array();
        System.out.println("Before: " + Arrays.toString(n3));
        bubbleSort3(n3);
        System.out.println("After:  " + Arrays.toString(n3));
    }

    // Example from the book
    public static void bubbleSort(int[] n) {
        int temp;
        for (int i = 0; i < n.length; i++) {
            for (int j = n.length - 1; j > i; j--) {
                if (n[j] < n[j - 1]) {
                    // Swap
                    temp = n[j - 1];
                    n[j - 1] = n[j];
                    n[j] = temp;
                }
            }
        }
    }

    // Geek for geeks
    // https://www.geeksforgeeks.org/bubble-sort/
    public static void bubbleSort2(int[] n) {
        int length = n.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (n[j] > n[j + 1]) {
                    // swap n[j+1] and n[i]
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
        }
    }

    // My own implementation of bubble sort
    public static void bubbleSort3(int[] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 1; j < n.length - i; j++) {
                if (n[j - 1] > n[j]) {
                    // Swap
                    int temp = n[j - 1];
                    n[j - 1] = n[j];
                    n[j] = temp;
                }
            }
        }
    }
}
