package com.vclyde.dsa.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class MatrixOperationTest {

	@Test(expected = IllegalArgumentException.class)
	public void test() {

		int[][] x = {
			{2, 3},
			{4, 5}
		};

		int[][] y = {
			{1, 2},
			{3, 4}
		};

		Assert.assertFalse(MatrixOperation.equals(x, y));
		Assert.assertTrue(MatrixOperation.equals(x, x));
		Assert.assertTrue(MatrixOperation.equals(MatrixOperation.add(x, y), 
			new int[][]{
				{3, 5}, 
				{7, 9}
			}));

		x = new int[][]{
			{2, 3},
			{4, 5}, 
			{6, 7}
		};
		
		y = new int[][]{
			{1, 3, 5, 7},
			{2, 4, 6, 8}
		};
		Assert.assertTrue(MatrixOperation.equals(MatrixOperation.multiply(x, y), 
			new int[][]{
				{8, 18, 28, 38}, 
				{14, 32, 50, 68},
				{20, 46, 72, 98}
			}));
		
		// This will throw an exception
		MatrixOperation.add(x, y); 
		MatrixOperation.multiply(x, x); 
	}
}
