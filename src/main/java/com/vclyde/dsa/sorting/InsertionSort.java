package com.vclyde.dsa.sorting;

/**
 * Insertion sort algorithm
 *
 * @author Clyde Velasquez
 */
public final class InsertionSort {

	private InsertionSort() {

	}

	public static <T extends Comparable<T>> void sort(T[] t) {
		// Declares i and j here
		for (int i = 1; i < t.length; i++) {
			T current = t[i]; // t[1] - starts at index 1

			// j starts at 1
			// condition checks if j is greater than 0 and compares current
			// to its previous element in the array
			int j;
			for (j = i; j > 0 && (current.compareTo(t[j - 1]) < 0); j--) {
				t[j] = t[j - 1];
			}

			// Use j
			t[j] = current;
		}
	}
}
