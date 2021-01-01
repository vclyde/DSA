package com.vclyde.dsa.list;

import com.vclyde.dsa.interfaces.List;

/**
 * DoublyLinkedList
 *
 * @author Clyde Velasquez
 * @param <E> Generic type
 */
public class DoublyLinkedList<E> implements List<E> {

	private static class Node<E> {

		private E element;
		private Node<E> next;
		private Node<E> prev;

		public Node(E e) {
			this.element = e;
			this.next = null;
			this.prev = null;
		}

		public Node(E e, Node<E> previous, Node<E> next) {
			this.element = e;
			this.prev = previous;
			this.next = next;
		}
	}

	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int count;

	public DoublyLinkedList() {
		this.header = new Node<>(null);
		this.trailer = new Node<>(null, header, null);
		this.header.next = this.trailer;
		this.count = 0;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return this.header.next.element;
	}

	@Override
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return this.trailer.prev.element;
	}

	@Override
	public void addFirst(E e) {
		// Previous -> header
		// Next -> header.next
		Node<E> newest = new Node<>(e, this.header, this.header.next);

		// this.header.next.prev = newest;
		// this.header.next = newest;
		this.header.next = newest;
		newest.next.prev = newest;
		++count;
	}

	@Override
	public void addLast(E e) {
		// Previous -> trailer.prev
		// Next -> trailer
		Node<E> newest = new Node<>(e, this.trailer.prev, this.trailer);

		// this.trailer.prev.next = newest;
		// this.trailer.prev = newest;
		this.trailer.prev = newest;
		newest.prev.next = newest;
		++count;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		// The node after the header sentinel
		Node<E> removed = this.header.next;
		// removed.prev.next = removed.next;
		// removed.next.prev = removed.prev;

		this.header.next = removed.next;
		removed.next.prev = this.header;
		--count;

		return removed.element;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		
		// The node before the trailer sentinel
		Node<E> removed = this.trailer.prev;
		this.trailer.prev = removed.prev;
		removed.prev.next = this.trailer;
		--count;
		
		return removed.element;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		this.count = 0;
		this.header.next = this.trailer;
		this.trailer.prev = this.header;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node<E> i = this.header.next;
		while (i != this.trailer) {
			sb.append(i.element);

			i = i.next;
			if (i != this.trailer) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Display in reverse order
	 *
	 * @return String in reverse order
	 */
	public String reverse() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node<E> i = this.trailer.prev;
		while (i != this.header) {
			sb.append(i.element);

			i = i.prev;
			if (i != this.header) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
