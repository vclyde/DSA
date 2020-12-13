package com.vclyde.dsa.sorting;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class CountingSortTest {
	
	@Test
	public void testSort() {
		int[] a = Util.unsortedints();
		// Verify if the array is not sorted 
		Assert.assertTrue(!Arrays.equals(Util.sortedints(), a));
		CountingSort.sort(a);
		Assert.assertArrayEquals(Util.sortedints(), a);
	}
	
}
