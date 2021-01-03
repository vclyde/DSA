package com.vclyde.dsa.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Clyde Velasquez
 */
public class ArrayStackTest {

	@Test
	public void testStack() {

		ArrayStack<Integer> stack = new ArrayStack<>(10);
		Assert.assertTrue(stack.isEmpty());

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		Assert.assertFalse(stack.isEmpty());
		Assert.assertEquals(10, stack.size());

		try {
			stack.push(-1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		stack.pop();
		stack.pop();
		stack.pop();
		Assert.assertEquals(7, stack.size());

		stack.pop();
		stack.pop();
		stack.pop();
		Assert.assertEquals(4, stack.top().intValue());

		stack.clear();
		Assert.assertEquals(0, stack.size());

		System.out.println(stack);
	}
}
