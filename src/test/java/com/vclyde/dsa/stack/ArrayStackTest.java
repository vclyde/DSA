package com.vclyde.dsa.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class ArrayStackTest {

	@Test
	public void testStack() {

		ArrayStack<Integer> stack = new ArrayStack<>();
		Assert.assertTrue(stack.isEmpty());
		
		stack.push(12);
		stack.push(25);
		stack.push(1993);
		Assert.assertEquals(3, stack.size());
		
		Integer expected = 1993;
		Integer actual = stack.pop();
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(2, stack.size());
		
		stack.push(2020);
		expected = 2020;
		Assert.assertEquals(expected, stack.top());
		Assert.assertEquals(3, stack.size());
		
		stack.push(2021);
		stack.push(10);
		stack.push(12);
		stack.push(1999);
		Assert.assertEquals(7, stack.size());
		
		stack.clear();
		Assert.assertTrue(stack.isEmpty());
	}
}
