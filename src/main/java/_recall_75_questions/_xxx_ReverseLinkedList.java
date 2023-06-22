package _recall_75_questions;

public class _xxx_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null) {
            ListNode tempNext = current.next;
            current.next = previous;
            previous = current;
            current = tempNext;
        }
        return previous;
    }
}

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }