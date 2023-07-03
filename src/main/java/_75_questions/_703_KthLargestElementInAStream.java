package _75_questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class _703_KthLargestElementInAStream {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int size;

    public _703_KthLargestElementInAStream(int k, int[] nums) {
        this.size = k;
        for(int num : nums) {
            minHeap.add(num);
        }
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        if(minHeap.size() < this.size) {
            minHeap.add(val);
            return  minHeap.peek();
        }

        if(minHeap.peek() < val) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        System.out.println(minHeap.peek());
    }
}