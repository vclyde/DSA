package com.vclyde.dsa.stack;

import com.vclyde.dsa.interfaces.Stack;

/**
 *
 * An array-based implementation of stack
 *
 * @author Clyde Velasquez
 * @param <E> Generic type
 */
public class ArrayStack<E> implements Stack<E> {

	private static final int GROW_SIZE = 20;

	private Object[] stack;
	private int count;
	private int topIndex;

	public ArrayStack() {
		this(GROW_SIZE);
	}

	public ArrayStack(int initialSize) {
		stack = new Object[initialSize];
		count = 0;
		topIndex = -1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E top() {
		if (topIndex > -1) {
			return (E) stack[topIndex];
		} else {
			throw new ArrayIndexOutOfBoundsException("Stack is empty!");
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		count = 0;
		topIndex = -1;
	}

	@Override
	public void push(E e) {
		if (count <= stack.length && (topIndex + 1) < stack.length) {
			stack[++topIndex] = e;
			count++;
		} else {
			Object[] newStack = new Object[stack.length + GROW_SIZE];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			stack = newStack;
			push(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public E pop() {
		if (count > 0) {
			count--;
			return (E) stack[topIndex--];
		} else {
			throw new ArrayIndexOutOfBoundsException("Stack is empty!");
		}
	}

	@Override
	public String toString() {
		System.out.println("array size: " + stack.length);
		StringBuilder sb = new StringBuilder();

		sb.append("Stack").append("\n");
		if (count == 0) {
			sb.append("***EMPTY***").append("\n");
		}

		for (int i = count - 1; i > -1; i--) {
			sb.append(stack[i]).append("\n");
		}
		sb.append("-----");

		return sb.toString();
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}
}
