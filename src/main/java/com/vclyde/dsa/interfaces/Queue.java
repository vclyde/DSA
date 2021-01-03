package com.vclyde.dsa.interfaces;

/**
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public interface Queue<E> extends Collection<E> {

	// Adds element e to the back of the queue
	void enqueue(E e);

	// Removes and returns the first element from the queue
	E dequeue();

	// Returns the first element of the queue without removing it
	E first();
}