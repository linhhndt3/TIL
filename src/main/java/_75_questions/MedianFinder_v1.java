package _75_questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder_v1 {

    private Queue<Integer> maxHeap  = new PriorityQueue<>();
    private Queue<Integer> minHeap  = new PriorityQueue<>((a,b) -> {return b-a;});

    public MedianFinder_v1() {

    }

    public void addNum(int num) {
        // TODO review step by step (hint: 2 different way to compare( if(num >= maxHeap.peek()) and  num >= minHeap.peek() ) in the same algorithm)
        if(maxHeap.size() > minHeap.size()) {
            if(num >= maxHeap.peek()) {
                int minOfMaxHeap = maxHeap.poll(); // remove first element(the minimum number) in the maxHeap;
                minHeap.add(minOfMaxHeap);
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        } else {
            if((maxHeap.size() == 0 && minHeap.size() == 0) || num >= minHeap.peek()) {
                maxHeap.add(num);
            } else {
                int maxOfMinHeap = minHeap.poll();
                maxHeap.add(maxOfMinHeap);
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
         Queue<Integer> minHeap  = new PriorityQueue<>((a,b) -> {return b-a;});
         minHeap.add(3);
         minHeap.add(5);
         minHeap.add(2);
        System.out.println(minHeap.peek());
        System.out.println(minHeap);
    }
}