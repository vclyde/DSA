package com.vclyde.dsa.sorting;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class SelectionSortTest {

	@Test
	public void testSort() {
		Integer[] a = Util.unsortedIntegers();
		Assert.assertTrue(!Arrays.equals(Util.sortedIntegers(), a));
		SelectionSort.sort(a);
		Assert.assertArrayEquals(Util.sortedIntegers(), a);
	}
}
