package com.vclyde.dsa.interfaces;

/**
 *
 * @author Clyde Velasquez
 * @param <E> Generic type
 */
public interface Stack<E> extends Collection<E> {

	// Adds element to the top of the stack
	void push(E e);
	// Removes an element from the top of the stack
	E pop();
	// Returns the top element of the stack without removing it
	E top();
}
