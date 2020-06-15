package com.dsa.stack;


public class ArrayStack {

    private int[] stack = new int[10]; // Initial size
    private int count = 0;

    public ArrayStack() {
    }

    public void push(int value) {

        if (count < stack.length) {
            stack[count] = value;
        } else {
            int[] newStack = new int[stack.length * 2];
            newStack[count] = value;
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        count++;
    }

    public int pop() {
        count--;
        if (count < 0) {
            count = 0;
            System.out.println("Empty Array!");
            return 0;
        }
        return stack[count];
    }

    public void empty() {
        count = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < count; i++) {
            sb.append(stack[i]);

            if(i + 1 < count) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); // Empty array
        stack.pop(); // Empty array
        System.out.println(stack);
        stack.push(26);
        stack.push(0);
        stack.push(-1);
        stack.pop();
        stack.push(-99);
        System.out.println(stack);
        stack.empty();
        System.out.println(stack);
    }
}
