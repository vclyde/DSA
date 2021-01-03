package com.vclyde.dsa.sorting;

import java.util.Arrays;

public final class TestUtil {

	// Random numbers ranging from -99 to 100
	// From https://www.random.org
	private final static int[] arrayints = {
			58, 52, 5, -23, -6, 13, 48, -48, 83, -77,
			-5, -76, 46, 84, -20, -46, 7, -31, -17, 23,
			-57, 59, 94, -8, -92, 95, -58, 57, 41, -61,
			-19, -98, -99, 63, 9, 60, 73, -86, -82, -55,
			17, 69, -12, -29, -96, 18, -7, 21, 65, -13
	};
	private final static Integer[] arrayIntegers = {
			58, 52, 5, -23, -6, 13, 48, -48, 83, -77,
			-5, -76, 46, 84, -20, -46, 7, -31, -17, 23,
			-57, 59, 94, -8, -92, 95, -58, 57, 41, -61,
			-19, -98, -99, 63, 9, 60, 73, -86, -82, -55,
			17, 69, -12, -29, -96, 18, -7, 21, 65, -13
	};

	private TestUtil() {
	}

	public static int[] unsortedints() {
		return arrayints.clone();
	}

	public static Integer[] unsortedIntegers() {
		return arrayIntegers.clone();
	}

	public static int[] sortedints() {
		int[] clone = arrayints.clone();
		Arrays.sort(clone);
		return clone;
	}

	public static Integer[] sortedIntegers() {
		Integer[] clone = arrayIntegers.clone();
		Arrays.sort(clone);
		return clone;
	}

}
