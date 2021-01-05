package com.vclyde.dsa.list;

import com.vclyde.dsa.interfaces.List;

/**
 * SinglyLinkedList
 *
 * @param <E> Generic Type
 * @author Clyde Velasquez
 */
public final class SinglyLinkedList<E> implements List<E> {

	private Node<E> head;
	private Node<E> tail;
	private int count;

	public SinglyLinkedList() {
		head = tail = null;
		count = 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		head = tail = null; // Null
		count = 0; // Reset count
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.element;
	}

	@Override
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.element;
	}

	@Override
	public void addFirst(E e) {
		head = new Node<>(e, head);

		if (isEmpty()) { // If list is empty,
			tail = head; // then set new node as head and tail
		}

		++count;
	}

	@Override
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);

		if (isEmpty()) { // If list is empty,
			head = newNode; // then set new node as head and tail
		} else {
			tail.next = newNode;
		}

		tail = newNode;
		++count;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		E element = head.element;
		head = head.next;
		--count;
		// If count is zero then tail is also null
		if (count == 0) {
			tail = null;
		}

		return element;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		E element = tail.element;
		if (head == tail) {
			head = tail = null;
		} else {
			Node<E> current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			tail.next = null;
		}
		--count;
		return element;

	}

	@Override
	public E get(int index) {
		if (isEmpty()) {
			return null;
		}

		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException("Illegal parameter i");
		}
		
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.element;
	}

	@Override
	public void set(int index, E e) {
		if (isEmpty()) {
			throw new NullPointerException("Empty list");
		}

		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException("Illegal parameter i -> " + index);
		}
		
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.element = e;
	}

	@Override
	public void add(int index, E e) {
		if (index > count || index < 0) {
			throw new IllegalArgumentException("Illegal parameter i");
		}

		if (index == 0) {
			addFirst(e);
			return;
		} else if (index == count) {
			addLast(e);
			return;
		}
		
		Node<E> current = head;
		Node<E> prev = null;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		
		assert prev != null;
		prev.next = new Node<>(e, prev.next);
		++count;
	}

	@Override
	public E remove(int index) {

		if (isEmpty()) {
			return null;
		}

		if (index == 0) {
			return removeFirst();
		} else if (index == (count - 1)) {
			return removeLast();
		}

		if (index >= count || index < 0) {
			throw new IllegalArgumentException("Illegal parameter i");
		}
		
		Node<E> current = head;
		Node<E> prev = null;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		
		assert prev != null;
		prev.next = current.next;
		current.next = null;
		--count;

		return current.element;
	}

	@Override
	public void add(E e) {
		addLast(e);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		for (Node<E> current = head; current != null; current = current.next) {
			sb.append(current.element);
			if (current.next != null) {
				sb.append(", ");
			}
		}
		
		sb.append("}");
		return sb.toString();
	}

	private static class Node<E> {

		private E element;
		private Node<E> next;

		public Node(E element) {
			this(element, null);
		}

		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
}
