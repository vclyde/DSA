package com.vclyde.dsa.sorting;

/**
 * Bubble sort algorithm
 *
 * @author Clyde Velasquez
 */
public final class BubbleSort {

	private BubbleSort() {
		// Prevent instantiation
	}

	public static <T extends Comparable<T>> void sort(T[] t) {

		for (int i = 0; i < t.length; i++) {
			for (int j = t.length - 1; j > i; j--) {
				// Compare adjacent elements
				if (t[j].compareTo(t[j - 1]) < 0) {
					// Swap
					T temp = t[j - 1];
					t[j - 1] = t[j];
					t[j] = temp;
				}
			}
		}
	}
}
