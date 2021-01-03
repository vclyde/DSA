package com.vclyde.dsa.queue;

import com.vclyde.dsa.interfaces.Queue;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Clyde Velasquez
 */
public class ArrayQueueTest {

	@Test
	public void testQueue() {

		Queue<Integer> queue = new ArrayQueue<>(10);
		Assert.assertTrue(queue.isEmpty());

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		Assert.assertFalse(queue.isEmpty());
		Assert.assertEquals(6, queue.size());
		Assert.assertEquals(1, queue.dequeue().intValue());
		Assert.assertEquals(2, queue.first().intValue());
		Assert.assertEquals(5, queue.size());

		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		Assert.assertEquals(10, queue.size());

		try {
			queue.enqueue(12);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		Assert.assertEquals(5, queue.first().intValue());
		Assert.assertEquals(7, queue.size());

		System.out.println(queue);
		queue.clear();
		Assert.assertTrue(queue.isEmpty());

	}

}
