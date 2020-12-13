package com.vclyde.dsa.sorting;

/**
 * Selection sort algorithm
 *
 * @author Clyde Velasquez
 */
public final class SelectionSort {

	private SelectionSort() {

	}

	public static <T extends Comparable<T>> void sort(T[] t) {

		for (int i = 0, minimal; i < t.length - 1; i++) {
			minimal = i;
			for (int j = i + 1; j < t.length; j++) {
				if (t[j].compareTo(t[minimal]) < 0) {
					minimal = j;
				}
			}

			// Swap values
			T temp = t[i];
			t[i] = t[minimal];
			t[minimal] = temp;
		}
	}
}
