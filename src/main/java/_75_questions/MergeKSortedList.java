package _75_questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode listNode : lists ) {
            if(listNode != null) {
                heap.offer(listNode);
            }
        }

        if(heap.size() == 0) {
            return null;
        }
        ListNode rs = heap.poll();
        ListNode org = rs;
        if(rs.next != null) {
            heap.offer(rs.next);
        }
        while(!heap.isEmpty()) {
            ListNode next = heap.poll();
            ListNode nextOfNext = next.next;
            rs.next = next;
            rs = next;
            if(nextOfNext != null) {
                heap.offer(nextOfNext);
            }
        }

        return org;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}