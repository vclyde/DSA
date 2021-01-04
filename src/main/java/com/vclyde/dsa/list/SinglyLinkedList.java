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
			Node<E> i = head;
			while (i.next != tail) {
				i = i.next;
			}
			tail = i;
			tail.next = null;
		}
		--count;
		return element;

	}

	@Override
	public E get(int i) {
		if (isEmpty()) {
			return null;
		}

		if (i >= count || i < 0) {
			throw new IllegalArgumentException("Illegal parameter i");
		}

		Node<E> iterator = head;
		E el = iterator.element;
		int pos = 0;
		while (pos < i) {
			pos++;
			iterator = iterator.next;
			el = iterator.element;
		}

		return el;
	}

	@Override
	public void set(int i, E e) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Empty list");
		}

		if (i >= count || i < 0) {
			throw new IllegalArgumentException("Illegal parameter i -> " + i);
		}

		Node<E> iterator = head;
		int pos = 0;
		while (pos < i) {
			pos++;
			iterator = iterator.next;
		}
		iterator.element = e;
	}

	@Override
	public void add(int i, E e) {
		if (i > count || i < 0) {
			throw new IllegalArgumentException("Illegal parameter i");
		}

		if (i == 0) {
			addFirst(e);
			return;
		} else if (i == count) {
			addLast(e);
			return;
		}

		Node<E> iterator = head;
		Node<E> prev = iterator;
		int pos = 0;
		while (pos < i) {
			prev = iterator;
			pos++;
			iterator = iterator.next;
		}

		prev.next = new Node<>(e, prev.next);
		++count;
	}

	@Override
	public E remove(int i) {

		if (isEmpty()) {
			return null;
		}

		if (i == 0) {
			return removeFirst();
		} else if (i == (count - 1)) {
			return removeLast();
		}

		if (i >= count || i < 0) {
			throw new IllegalArgumentException("Illegal parameter i");
		}

		Node<E> iterator = head;
		Node<E> prev = iterator;
		int pos = 0;
		while (pos < i) {
			prev = iterator;
			pos++;
			iterator = iterator.next;
		}

		E el = iterator.element;
		prev.next = iterator.next;
		iterator.next = null;
		--count;

		return el;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Node<E> i = head; i != null; i = i.next) {
			sb.append(i.element);
			if (i.next != null) {
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
