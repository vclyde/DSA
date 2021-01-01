package com.vclyde.dsa.list;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class DoublyLinkedListTest {
	
	@Test
	public void test() {
		DoublyLinkedList<String> dll = new DoublyLinkedList<>();
		Assert.assertEquals(0, dll.size());
		
		dll.addFirst("Hello");
		dll.addLast("World");
		Assert.assertEquals(2, dll.size());
		Assert.assertEquals("Hello", dll.first());
		Assert.assertEquals("World", dll.last());
		System.out.println(dll);
		
		dll.addLast("Welcome");
		Assert.assertEquals(3, dll.size());
		Assert.assertEquals("Welcome", dll.removeLast());
		Assert.assertEquals(2, dll.size());
		Assert.assertEquals("Hello", dll.removeFirst());
		Assert.assertEquals(1, dll.size());
		System.out.println(dll);
		
		dll.clear();
		Assert.assertEquals("{}", dll.toString());
	}
}