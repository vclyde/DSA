package com.vclyde.dsa.interfaces;

/**
 * Deque(Double-Ended Queue) interface
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public interface Deque<E> extends Collection<E> {

	// Returns the first element without removing it
	E first();

	// Returns the last element without removing it
	E last();

	// Adds a new element to the front of the list
	void addFirst(E e);

	// Adds a new element to the end of the list
	void addLast(E e);

	// Returns and removes the first element of the list
	E removeFirst();

	// Returns and removes the first element of the list
	E removeLast();

}
