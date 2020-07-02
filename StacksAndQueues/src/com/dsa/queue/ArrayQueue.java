package com.dsa.queue;

/**
 * Using Circular Buffer
 *
 */
public class ArrayQueue {

    private final int[] queue;
    private int head;
    private int tail;
    private int count;

    private final int n;

    public static void main(String[] args) {

        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println(q);
        q.enqueue(5);
        System.out.println(q);
        q.enqueue(1000);
        System.out.println(q);
        q.enqueue(48);
        System.out.println(q);
        q.dequeue();
        System.out.println(q);

    }

    public ArrayQueue(int length) {
        queue = new int[length];
        head = tail = 0;
        n = length;
        count = 0;
    }

    public void enqueue(int value) {
        if (count <  n) {
            queue[tail] = value;
            tail = (tail + 1) % n;
            count++;
        } else {
            System.out.println("Queue is full!");
        }
    }

    public int dequeue() {
        if ((count - 1) < 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        head = head % n;
        count--;
        return queue[head++];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h = head;
        for (int i = 0; i < count; i++) {
            sb.append(queue[(h++ % n)]).append(" ");
        }
        return sb.toString();
    }
}
