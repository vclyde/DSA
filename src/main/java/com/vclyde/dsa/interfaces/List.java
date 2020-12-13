package com.vclyde.dsa.interfaces;

/**
 *
 * @author Clyde Velasquez
 * @param <E>
 */
public interface List<E> extends Collection<E> {
	
	void add(E e);
	
	E remove(int position);
}
