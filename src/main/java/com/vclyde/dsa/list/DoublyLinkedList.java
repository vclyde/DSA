package com.vclyde.dsa.list;

import com.vclyde.dsa.interfaces.List;

/**
 * DoublyLinkedList
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public class DoublyLinkedList<E> implements List<E> {

	private final Node<E> header; // header sentinel
	private final Node<E> trailer; // trailer sentinel
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
		// Newest must be after the header sentinel so set predecessor to header
		addBetween(e, this.header, this.header.next);
	}

	@Override
	public void addLast(E e) {
		// Newest node must be before the trailer sentinel so set successor to trailer
		addBetween(e, this.trailer.prev, this.trailer);
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		return remove(this.header.next);
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		return remove(this.trailer.prev);
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
	public void add(E e) {
		addLast(e);
	}

	@Override
	public E get(int index) {
		if (index >= 0 && index < count) {
			Node<E> current = this.header.next;

			for (int i = 0; i < index; i++) {
				current = current.next;
			}

			return current.element;
		} else {
			throw new IndexOutOfBoundsException("Index is out of bounds! List size is " + count);
		}
	}

	@Override
	public void set(int index, E e) {
		if (index >= 0 && index < count) {
			Node<E> current = this.header.next;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.element = e;
		} else {
			throw new IndexOutOfBoundsException("Index is out of bounds! List size is " + count);
		}
	}

	@Override
	public void add(int index, E e) {
		if (index >= 0 && index <= count) {
			Node<E> current = this.header.next;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			addBetween(e, current.prev, current);
		} else {
			throw new IndexOutOfBoundsException("Index is out of bounds! List size is " + count);
		}
	}

	@Override
	public E remove(int index) {
		if (index >= 0 && index < count) {
			Node<E> current = this.header.next;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			remove(current);

			return current.element;
		} else {
			throw new IndexOutOfBoundsException("Index is out of bounds! List size is " + count);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		for (Node<E> current = this.header.next; current != this.trailer; current = current.next) {
			sb.append(current.element);
			if (current.next != this.trailer) {
				sb.append(", ");
			}
		}

		sb.append("}");

		// In reverse order
//		sb.append("\n");
//		sb.append("{");
//		for (Node<E> current = this.trailer.prev; current != this.header; current = current.prev) {
//			sb.append(current.element);
//			if (current.prev != this.header) {
//				sb.append(", ");
//			}
//		}
//		sb.append("}");
		return sb.toString();
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {

		Node<E> newest = new Node<>(e, predecessor, successor);

		predecessor.next = newest;
		successor.prev = newest;

		++count;
	}

	private E remove(Node<E> node) {

		Node<E> predecessor = node.prev;
		Node<E> successor = node.next;

		predecessor.next = successor;
		successor.prev = predecessor;

		--count;

		return node.element;
	}

	private static class Node<E> {

		private E element;
		private Node<E> next;
		private Node<E> prev;

		public Node(E e) {
			this(e, null, null);
		}

		public Node(E e, Node<E> previous, Node<E> next) {
			this.element = e;
			this.prev = previous;
			this.next = next;
		}
	}
}
