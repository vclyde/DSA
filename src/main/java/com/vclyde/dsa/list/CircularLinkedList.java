package com.vclyde.dsa.list;

import com.vclyde.dsa.interfaces.List;

/**
 * CircularLinkedList
 *
 * @param <E> Generic type
 * @author Clyde Velasquez
 */
public class CircularLinkedList<E> implements List<E> {

	private Node<E> tail;
	private int count;

	public CircularLinkedList() {
		tail = null;
		count = 0;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return tail.next.element;
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
		if (tail == null) {
			tail = new Node<>(e);
			tail.next = tail;
		} else {
			tail.next = new Node<>(e, tail.next);
		}
		++count;
	}

	@Override
	public void addLast(E e) {
		addFirst(e);
		tail = tail.next;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		Node<E> head = tail.next;
		if (head == tail) {
			tail = null;
		} else {
			tail.next = head.next;
		}
		--count;

		return head.element;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		E el = tail.element;
		Node<E> head = tail.next;
		if (head == tail) {
			tail = null;
		} else {
			Node<E> i = head;
			while (i.next != tail) {
				i = i.next;
			}
			i.next = tail.next;
			tail = i;
		}
		--count;

		return el;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		tail = null;
		count = 0;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	public void rotate() {
		if (tail != null) {
			tail = tail.next;
		}
	}

	@Override
	public void add(E e) {
		addFirst(e);
		tail = tail.next;
	}

	@Override
	public E get(int index) {
		if (index >= 0 && index < count) {
			Node<E> current = tail.next; // head
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
			Node<E> current = tail.next;
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

		if (index == 0) {
			addFirst(e);
			return;
		} else if (index == count) {
			addLast(e);
			return;
		}

		if (index > 0 && index < count) {

			Node<E> prev = tail;
			Node<E> current = tail.next;
			for (int i = 0; i < index; i++) {
				prev = current;
				current = current.next;
			}

			prev.next = new Node<>(e, current);
			++count;
		} else {
			throw new IndexOutOfBoundsException("Index is out of bounds! List size is " + count);
		}
	}

	@Override
	public E remove(int index) {
		if (index >= 0 && index < count) {

			Node<E> prev = tail;
			Node<E> current = tail.next;

			for (int i = 0; i < index; i++) {
				prev = current;
				current = current.next;
			}

			prev.next = current.next;
			if (index == (count - 1)) {
				tail = prev;
			}
			--count;

			return current.element;
		} else {
			throw new IndexOutOfBoundsException("Index is out of bounds! List size is " + count);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		if (tail != null) {
			Node<E> current = tail.next; // Starts at the head
			do {
				sb.append(current.element);
				current = current.next;
				if (current != tail.next) {
					sb.append(", ");
				}
			} while (current != tail.next);
		}
		sb.append("}");
		return sb.toString();
	}

	public static class Node<E> {

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
