package clydee.dsa.sorting;

import java.util.Arrays;

/**
 *
 * @author Clyde Velasquez
 */
public class BubbleSort {
	
    public static void main(String[] args) {
		
		// 610, 790, 687, 528, 141, 584, 378, 637, 798, 647, 739, 890, 810, 462, 202, 1000, 532, 468, 991, -75, 172, 614, -98, 115, 348, 535, 996, 869, 705, 28, 916, 550, 122, 796, 901, 423, 394, 167, 534, 981, 714, 396, 128, 706, -95, 266, 156, 97, 892, 773, 6, 330, 290, 152, 668, 683, 666, 342, -27, 868, 594, 716, 27, 418, 109, -30, 799, 854, 519, 774, 46, 81, 158, 129, 863, 199, 575, 635, 803, -84, 71, 335, 48, 939, 929, 663, 31, 86, 885, 980, 301, 551, 508, 906, 882, 621, 41, 467, 557, -100
        int[] n = {11, 7, 9, 1, 2, 23, 5, 1, -1, -5, 0, -1};
        System.out.println("Before: " + Arrays.toString(n));
		long start = System.nanoTime();
        bubbleSort(n);
		long end = System.nanoTime();
        System.out.println("After:  " + Arrays.toString(n));
		System.out.println(start + " " + end);
		System.out.println("Running time: " + (end - start));

//        int[] n2 = {3, 1, 13, 2, 7, 19, 0, 9, 17, 5};
//        System.out.println("Before: " + Arrays.toString(n2));
//        bubbleSort2(n2);
//        System.out.println("After:  " + Arrays.toString(n2));
//
//        int[] n3 = {3, 1, 13, 2, 7, 19, 0, 9, 17, 5};
//        System.out.println("Before: " + Arrays.toString(n3));
//        bubbleSort3(n3);
//        System.out.println("After:  " + Arrays.toString(n3));
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
