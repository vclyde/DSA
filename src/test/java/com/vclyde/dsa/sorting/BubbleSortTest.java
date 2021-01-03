package com.vclyde.dsa.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Clyde Velasquez
 */
public class BubbleSortTest {

	@Test
	public void testSort() {
		Integer[] a = TestUtil.unsortedIntegers();
		Assert.assertFalse(Arrays.equals(TestUtil.sortedIntegers(), a));
		BubbleSort.sort(a);
		Assert.assertArrayEquals(TestUtil.sortedIntegers(), a);
	}

}
