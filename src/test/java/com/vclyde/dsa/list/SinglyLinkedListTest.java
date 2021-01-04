package com.vclyde.dsa.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Clyde Velasquez
 */
public class SinglyLinkedListTest {

	@Test
	public void test() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		Assert.assertTrue(list.isEmpty());

		// Test addFirst
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		Assert.assertEquals(3, list.size());
		Assert.assertEquals(Integer.valueOf(3), list.first());

		// Test addLast
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		Assert.assertEquals(6, list.size());
		Assert.assertEquals(Integer.valueOf(6), list.last());

		// Test removeFirst
		list.removeFirst();
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(Integer.valueOf(2), list.first());

		// Test removeLast
		list.removeLast();
		Assert.assertEquals(4, list.size());
		Assert.assertEquals(Integer.valueOf(5), list.last());

		// Test add and remove from the front of the list
		list.add(0, 100);
		Assert.assertEquals(Integer.valueOf(100), list.first());
		Assert.assertEquals(Integer.valueOf(100), list.get(0));
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(Integer.valueOf(100), list.remove(0));

		// Test add and remove from the rear of the list
		list.add(4, 89);
		Assert.assertEquals(Integer.valueOf(89), list.last());
		Assert.assertEquals(Integer.valueOf(89), list.get(4));
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(Integer.valueOf(89), list.remove(4));

		// Test add and remove in the middle of the list
		list.add(2, 1000);
		Assert.assertEquals(Integer.valueOf(1000), list.get(2));
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(Integer.valueOf(1000), list.remove(2));

		list.clear();
		Assert.assertTrue(list.isEmpty());
		Assert.assertNull(list.first());
		Assert.assertNull(list.last());
		Assert.assertNull(list.get(1));
	}
}
