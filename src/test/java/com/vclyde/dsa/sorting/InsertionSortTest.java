package com.vclyde.dsa.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Clyde Velasquez
 */
public class InsertionSortTest {

	@Test
	public void testSort() {
		Integer[] a = TestUtil.unsortedIntegers();
		Assert.assertFalse(Arrays.equals(TestUtil.sortedIntegers(), a));
		InsertionSort.sort(a);
		Assert.assertArrayEquals(TestUtil.sortedIntegers(), a);
	}

}
