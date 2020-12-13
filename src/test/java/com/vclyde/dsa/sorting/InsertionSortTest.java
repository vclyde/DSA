package com.vclyde.dsa.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class InsertionSortTest {

	@Test
	public void testSort() {
		Integer[] a = Util.unsortedInteger();
		InsertionSort.sort(a);
		Assert.assertArrayEquals(Util.sortedInteger(), a);
	}
	
}
