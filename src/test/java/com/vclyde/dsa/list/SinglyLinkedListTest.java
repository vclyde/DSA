package com.vclyde.dsa.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Clyde Velasquez
 */
public class SinglyLinkedListTest {

	@Test
	public void linkedListTest() {
		SinglyLinkedList<Integer> intList = new SinglyLinkedList<>();

		Assert.assertEquals(0, intList.size());
		Assert.assertNull(intList.first());
		Assert.assertNull(intList.last());

		Assert.assertNull(intList.removeFirst());
		Assert.assertNull(intList.removeLast());

		intList.addFirst(2020);
		Assert.assertEquals(1, intList.size());
		Assert.assertNotNull(intList.first());
		Assert.assertNotNull(intList.last());

		Integer first = intList.first();
		Integer last = intList.last();
		Assert.assertEquals(2020, first.intValue());
		Assert.assertEquals(2020, last.intValue());

		intList.addLast(50);
		System.out.println(intList);
		last = intList.last();
		assert last != null;
		Assert.assertEquals(50, last.intValue());
		Assert.assertEquals(2, intList.size());

		intList.addFirst(21);
		System.out.println(intList);
		first = intList.first();
		assert first != null;
		Assert.assertEquals(21, first.intValue());
		Assert.assertEquals(3, intList.size());

		Integer remove = intList.removeFirst();
		assert remove != null;
		Assert.assertEquals(21, remove.intValue());
		Assert.assertEquals(2, intList.size());
		System.out.println(intList);

		remove = intList.removeLast();
		assert remove != null;
		Assert.assertEquals(50, remove.intValue());
		System.out.println(intList);

		intList.clear();
		Assert.assertEquals(0, intList.size());
		Assert.assertNull(intList.first());
		Assert.assertNull(intList.last());
	}

}
