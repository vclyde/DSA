package com.dsa.queue;

/**
 * https://codility.com/media/train/5-Stacks.pdf
 */
public class GroceryStore {

    public static void main(String[] args) {
        int[] line = {0, 1, 0, 1, 0, 1, 1};
        System.out.println(groceryStore(line));
    }

    public static int groceryStore(int[] a) {
        int size = 0;
        int result = 0;

        for (int value : a) {
            if (value == 0) {
                size++;
            } else {
                size--;
                result = Math.max(result, -size);
            }
        }

        return result;
    }
}
