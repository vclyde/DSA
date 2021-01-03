package com.vclyde.dsa.sorting;

/**
 * Counting sort algorithm
 *
 * @author Clyde Velasquez
 */
public final class CountingSort {

	private CountingSort() {

	}

	// Counting sort
	public static void sort(int[] n) {

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

		// Count the occurrences/frequency of numbers
		for (int value : n) {
			if (value >= 0) {
				pos[value]++;
			} else {
				neg[value * -1]++;
			}
		}

		int k = 0;
		// For negative numbers if there are any
		for (int i = neg.length - 1; i >= 0; i--) {
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