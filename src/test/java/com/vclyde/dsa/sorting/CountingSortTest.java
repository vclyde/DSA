package com.vclyde.dsa.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Clyde Velasquez
 */
public class CountingSortTest {

	@Test
	public void testSort() {
		int[] a = TestUtil.unsortedints();
		// Verify if the array is not sorted
		Assert.assertFalse(Arrays.equals(TestUtil.sortedints(), a));
		CountingSort.sort(a);
		Assert.assertArrayEquals(TestUtil.sortedints(), a);
	}

}
