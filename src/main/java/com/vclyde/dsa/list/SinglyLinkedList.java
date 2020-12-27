package com.vclyde.dsa.list;

import com.vclyde.dsa.interfaces.List;

/**
 * SinglyLinkedList
 *
 * @author Clyde Velasquez
 * @param <E> Generic Type
 */
public final class SinglyLinkedList<E> implements List<E> {

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
}
