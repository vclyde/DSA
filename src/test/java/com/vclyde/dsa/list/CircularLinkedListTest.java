package com.vclyde.dsa.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Clyde Velasquez
 */
public class CircularLinkedListTest {

	@Test
	public void test() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		Assert.assertTrue(list.isEmpty());

		// Add first
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(0);
		Assert.assertEquals(4, list.size());
		Assert.assertEquals(Integer.valueOf(0), list.first());

		// Add last
		list.addLast(-1);
		list.addLast(-2);
		list.addLast(-3);
		Assert.assertEquals(7, list.size());
		Assert.assertEquals(Integer.valueOf(-3), list.last());

		// Remove first
		list.removeFirst();
		Assert.assertEquals(6, list.size());
		Assert.assertEquals(Integer.valueOf(1), list.first());

		// Remove last
		list.removeLast();
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(Integer.valueOf(-2), list.last());

		// Rotate
		list.rotate();
		Assert.assertEquals(Integer.valueOf(2), list.first());

		// Get
		Assert.assertEquals(Integer.valueOf(2), list.get(0));
		Assert.assertEquals(Integer.valueOf(1), list.get(list.size() - 1));
		Assert.assertEquals(Integer.valueOf(-1), list.get(2));

		// Set
		list.set(2, 7);
		Assert.assertEquals(Integer.valueOf(7), list.get(2));

		// Add
		list.add(-4);
		Assert.assertEquals(Integer.valueOf(-4), list.last());

		// Remove
		Assert.assertEquals(Integer.valueOf(2), list.remove(0));
		Assert.assertEquals(Integer.valueOf(-4), list.remove(list.size() - 1));
		Assert.assertEquals(Integer.valueOf(7), list.remove(1));
		Assert.assertEquals(3, list.size());

		// Add with index
		list.add(0, 0);
		Assert.assertEquals(Integer.valueOf(0), list.get(0));
		list.add(list.size(), -999);
		Assert.assertEquals(Integer.valueOf(-999), list.get(list.size() - 1));
		list.add(1, -5);
		Assert.assertEquals(Integer.valueOf(-5), list.get(1));
		list.add(list.size() - 1, -1);
		Assert.assertEquals(Integer.valueOf(-1), list.get(list.size() - 2));

		// When list is empty
		list.clear();
		list.add(0, 1);
		System.out.println(list);
	}
}