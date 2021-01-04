package com.vclyde.dsa.interfaces;

/**
 * Collection interface
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public interface Collection<E> {

	// Returns the size of collection
	int size();

	// Removes all values from the collection
	void clear();

	// Returns boolean if the collection is empty
	boolean isEmpty();
}
