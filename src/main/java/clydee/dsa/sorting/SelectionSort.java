package clydee.dsa.sorting;

import java.util.Arrays;

/**
 *
 * @author Clyde Velasquez
 */
public class SelectionSort {
	
    public static void main(String[] args) {

        int[] n = {11, 7, 9, 1, 2, 23, 5};
        System.out.println("Before: " + Arrays.toString(n));
        for (int i = 0, j, minimal; i < n.length - 1; i++) {
            for (j = i + 1, minimal = i; j < n.length; j++) {
                if (n[j] < n[minimal]) {
                    minimal = j;
                }
            }
            // Swap values
            int temp = n[i];
            n[i] = n[minimal];
            n[minimal] = temp;
        }
        System.out.println("After: " + Arrays.toString(n));
    }
}
