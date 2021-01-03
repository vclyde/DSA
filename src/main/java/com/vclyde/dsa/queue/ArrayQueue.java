package com.vclyde.dsa.queue;

import com.vclyde.dsa.interfaces.Queue;

import java.util.Arrays;

/**
 * An array-based implementation of queue with fixed size (Circular buffer)
 * https://en.wikipedia.org/wiki/Circular_buffer
 * First-in, first-out
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public class ArrayQueue<E> implements Queue<E> {

	private static final int DEFAULT_CAPACITY = 1000;

	private final Object[] queue;
	private int count;
	private int front;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int capacity) {
		queue = new Object[capacity];
		count = 0;
		front = 0;
	}

	@Override
	public void enqueue(E e) {
		if (count == queue.length) {
			throw new ArrayIndexOutOfBoundsException("Queue is full!");
		}
		int next = (front + count) % queue.length;
		queue[next] = e;
		count++;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E dequeue() {

		if (isEmpty()) {
			return null;
		}

		E element = (E) queue[front];
		front = (front + 1) % queue.length;
		count--;
		return element;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		count = 0;
		front = 0;
		Arrays.fill(queue, null);
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E first() {
		return (E) queue[front];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		int ctr = 0;
		int index = front;
		while (ctr < count) {
			sb.append(queue[index]);
			index = (index + 1) % queue.length;
			ctr++;
			if (ctr < count) {
				sb.append(", ");
			}
		}

		sb.append("]");
		return sb.toString();
	}
}
