package com.vclyde.dsa.search;

/**
 * Searching algorithms
 *
 * @author Clyde Velasquez
 */
public final class Searching {

	private Searching() {

	}

	/**
	 * Sequential/Linear search for primitive int arrays
	 *
	 * @param array the array to be searched
	 * @param val the value to be searched for
	 * @return true if found, otherwise false
	 */
	public static boolean sequentialSearch(int[] array, int val) {
		for (int n : array) {
			if (val == n) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sequential/Linear search for generic arrays that implements the
	 * Comparable interface
	 *
	 * @param <T> Generic type that implements the Comparable interface
	 * @param array the array to be searched
	 * @param val the value to be searched for
	 * @return true if found, otherwise false
	 */
	public static <T extends Comparable<T>> boolean sequentialSearch(T[] array, T val) {
		for (T t : array) {
			if (val.compareTo(t) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean binarySearch(int[] array, int val) {
		return binarySearch(array, val, 0, array.length - 1);
	}
	
	/**
	 * Recursive binary search for primitive int array
	 *
	 * @param array the sorted array to be searched
	 * @param val the value to be searched for
	 * @param low start index
	 * @param high end index
	 * @return true if found, otherwise false
	 */ 
	public static boolean binarySearch(int[] array, int val, int low, int high) {
		if (low > high) {
			return false;
		} else {
			int mid = (low + high) / 2;
			if (val == array[mid]) {
				return true;
			} else if (val < array[mid]) {
				return binarySearch(array, val, low, mid - 1);
			} else {
				return binarySearch(array, val, mid + 1, high);
			}
		}
	}

	public static <T extends Comparable<T>> boolean binarySearch(T[] array, T val) {
		return binarySearch(array, val, 0, array.length - 1);
	}

	/**
	 * Recursive binary search for generic type array
	 *
	 * @param <T> Generic type
	 * @param array the sorted array to be searched
	 * @param val the value to be searched for
	 * @param low start index
	 * @param high end index
	 * @return true if found, otherwise false
	 */
	public static <T extends Comparable<T>> boolean binarySearch(T[] array, T val, int low, int high) {
		if (low > high) {
			return false;
		} else {
			int mid = (low + high) / 2;
			if (val.compareTo(array[mid]) == 0) {
				return true;
			} else if (val.compareTo(array[mid]) < 0) {
				return binarySearch(array, val, low, mid - 1);
			} else {
				return binarySearch(array, val, mid + 1, high);
			}
		}
	}
}
