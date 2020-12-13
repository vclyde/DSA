package com.vclyde.dsa.interfaces;

/**
 *
 * @author Clyde Velasquez
 * @param <E>
 */
public interface Stack<E> extends Collection<E> {
	
	// Add element to the top of the stack
	void push(E e);
	// Removes an element from the top of the stack
	E pop();

}
