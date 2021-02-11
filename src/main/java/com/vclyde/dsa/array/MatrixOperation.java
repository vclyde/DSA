package com.vclyde.dsa.array;

import java.util.Arrays;

/**
 *
 * @author Clyde Velasquez
 */
public final class MatrixOperation {

	private MatrixOperation() {
	}

	public static int[][] add(int[][] x, int[][] y) {

		int rows = x.length;
		int cols = x[0].length;

		if (rows != y.length) {
			throw new IllegalArgumentException("Rows of the first matrix is " + rows + " while the second matrix is " + y.length);
		}

		if (cols != y[0].length) {
			throw new IllegalArgumentException("Columns of the first matrix is " + cols + " while the second matrix is " + y[0].length);
		}

		int[][] output = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				output[row][col] = x[row][col] + y[row][col];
			}
		}

		return output;
	}

	// Matrix-Scalar multiplication
	public static int[][] multiply(int[][] x, int y) {

		int rows = x.length;
		int cols = x[0].length;
		int[][] output = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				output[row][col] = x[row][col] * y;
			}
		}

		return output;
	}

	// Matrix-Matrix multiplication 
	public static int[][] multiply(int[][] x, int[][] y) {

		int m = x.length; // Number of rows of the output 
		int n = x[0].length;
		int o = y[0].length; // Number of columns of the output

		if (n != y.length) {
			throw new IllegalArgumentException("Columns of the first matrix must equal the number "
				+ "of rows of the second matrix!");
		}

		int[][] output = new int[m][o];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < o; col++) {
				output[row][col] = 0;
				for (int k = 0; k < n; k++) {
					output[row][col] += x[row][k] * y[k][col];
				}
			}
		}

		return output;
	}

	public static String toString(int[][] x) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : x) {
			sb.append(Arrays.toString(row)).append("\n");
		}
		return sb.toString();
	}

	// Checks if 2 matrix are equal
	public static boolean equals(int[][] x, int[][] y) {

		// Bounds check
		if (x.length != y.length) {
			return false;
		}

		if (x[0].length != y[0].length) {
			return false;
		}

		for (int row = 0; row < x.length; row++) {
			if (!Arrays.equals(x[row], y[row])) {
				return false;
			}
		}

		return true;
	}
}
