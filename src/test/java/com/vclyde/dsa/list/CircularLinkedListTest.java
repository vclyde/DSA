package com.vclyde.dsa.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Clyde Velasquez
 */
public class CircularLinkedListTest {

	@Test
	public void test() {
		CircularLinkedList<String> clist = new CircularLinkedList<>();
		Assert.assertTrue(clist.isEmpty());
		Assert.assertEquals(0, clist.size());
		Assert.assertNull(clist.first());
		Assert.assertNull(clist.last());

		clist.addFirst("Hello");
		clist.addLast("World");
		Assert.assertEquals(2, clist.size());
		Assert.assertNotNull(clist.first());
		Assert.assertNotNull(clist.last());
		Assert.assertEquals("Hello", clist.first());
		Assert.assertEquals("World", clist.last());
		System.out.println(clist);

		clist.addFirst("Welcome");
		Assert.assertEquals("Welcome", clist.first());
		System.out.println(clist);
		clist.rotate();
		Assert.assertEquals("Hello", clist.first());
		System.out.println(clist);
		clist.rotate();
		Assert.assertEquals("World", clist.first());
		Assert.assertEquals("Hello", clist.last());
		clist.clear();

		Assert.assertTrue(clist.isEmpty());
	}

}
