package com.vclyde.dsa.search;

import com.vclyde.dsa.sorting.TestUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class SearchingTest {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test() {

		Assert.assertTrue(Searching.sequentialSearch(TestUtil.unsortedints(), 73));
		Assert.assertFalse(Searching.sequentialSearch(TestUtil.unsortedints(), 74));

		Assert.assertTrue(Searching.sequentialSearch(TestUtil.unsortedIntegers(), 73));
		Assert.assertFalse(Searching.sequentialSearch(TestUtil.unsortedIntegers(), 74));

		int[] sorted = TestUtil.sortedints();
		Assert.assertTrue(Searching.binarySearch(sorted, 73));
		Assert.assertFalse(Searching.binarySearch(sorted, 74));

		Integer[] iSorted = TestUtil.sortedIntegers();
		Assert.assertTrue(Searching.binarySearch(iSorted, 73));
		Assert.assertFalse(Searching.binarySearch(iSorted, 74));

		Searching.binarySearch(new int[0], 10, -1, 1);

	}

}
