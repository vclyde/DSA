package com.vclyde.dsa.list;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Clyde Velasquez
 */
public class DoublyLinkedListTest {

	@Test
	public void test() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		Assert.assertTrue(list.isEmpty());
		
		// Test add first
		list.addFirst('A');
		list.addFirst('B');
		list.addFirst('C');
		Assert.assertFalse(list.isEmpty());
		Assert.assertNotNull(list.first());
		Assert.assertNotNull(list.last());
		Assert.assertEquals(Character.valueOf('C'), list.first());
		Assert.assertEquals(Character.valueOf('A'), list.last());
		Assert.assertEquals(3, list.size());
		
		// Test add last
		list.addLast('D');
		list.addLast('F');
		list.addLast('G');
		list.addLast('H');
		Assert.assertEquals(7, list.size());
		Assert.assertEquals(Character.valueOf('H'), list.last());
		
		// Test remove first
		Assert.assertEquals(Character.valueOf('C'), list.removeFirst());
		Assert.assertEquals(6, list.size());
		
		// Test remove last
		Assert.assertEquals(Character.valueOf('H'), list.removeLast());
		Assert.assertEquals(5, list.size());
		
		// Test get
		Assert.assertEquals(Character.valueOf('A'), list.get(1));
		
		// Test remove
		Assert.assertEquals(Character.valueOf('A'), list.remove(1));
		
		// Test set
		list.set(1, 'E');
		Assert.assertEquals(Character.valueOf('E'), list.get(1));
		
		// Test add
		list.add(0, 'z');
		Assert.assertEquals(Character.valueOf('z'), list.get(0));
		
		// Clear
		list.clear();
		Assert.assertTrue(list.isEmpty());
		Assert.assertNull(list.first());
		Assert.assertNull(list.last());		
	}
}