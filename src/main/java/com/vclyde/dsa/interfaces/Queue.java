package com.vclyde.dsa.interfaces;

/**
 *
 * @author Clyde Velasquez
 * @param <E>
 */
public interface Queue<E> extends Collection<E> {
	
	// Add new element to the 
	void enqueue(E item);
	
	// Removes element
	E dequeue();
}