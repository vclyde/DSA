package com.vclyde.dsa.stack;

import com.vclyde.dsa.interfaces.Stack;
import java.util.Arrays;

/**
 * An array-based implementation of stack with fixed size
 * <p>
 * Last-in, first-out
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public class ArrayStack<E> implements Stack<E> {

	private static final int DEFAULT_CAPACITY = 1000;

	private final Object[] stack;
	private int topIndex;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		stack = new Object[capacity];
		topIndex = -1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return (E) stack[topIndex];
	}

	@Override
	public int size() {
		return topIndex + 1;
	}

	@Override
	public void clear() {
		topIndex = -1;
		Arrays.fill(stack, null);
	}

	@Override
	public void push(E e) {
		if (size() < stack.length) {
			stack[++topIndex] = e;
		} else {
			throw new ArrayIndexOutOfBoundsException("Stack is full! Current size is " + size() + "!");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		
		E result = (E) stack[topIndex];
		stack[topIndex--] = null; // Eliminate obsolete object reference
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Stack").append("\n");
		if (isEmpty()) {
			sb.append("***EMPTY***").append("\n");
		}

		for (int i = topIndex; i > -1; i--) {
			sb.append(stack[i]).append("\n");
		}
		sb.append("-----");

		return sb.toString();
	}

	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}
}
