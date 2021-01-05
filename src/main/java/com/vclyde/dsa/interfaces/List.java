package com.vclyde.dsa.interfaces;

/**
 * List interface
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public interface List<E> extends Deque<E> {

	// Returns the element at the specified index
	E get(int index);

	// Set the value of the element at the specified index
	void set(int index, E e);
	
	// Add new element
	void add(E e);

	// Add new element at a specific index
	void add(int index, E e);

	// Returns and removes the element at a specific index
	E remove(int index);
}
