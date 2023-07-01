package _recall_75_questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class _21_MergeTwoSortList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        Queue<ListNode> heap = new PriorityQueue<>( (firstNode,secondNode) -> {return firstNode.val - secondNode.val;});

        heap.add(list1);
        heap.add(list2);

        ListNode min = heap.poll();
        ListNode newHead = min;
        if(min.next != null) {
            heap.add(min.next);
        }

        while (!heap.isEmpty()) {
            ListNode nextMin = heap.poll();
            min.next = nextMin;
            min = nextMin;
            if(nextMin.next != null) {
                heap.add(nextMin.next);
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> {return a - b;});
        queue.add(3);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
    }
}