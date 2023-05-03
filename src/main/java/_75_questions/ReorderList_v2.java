package _75_questions;

public class ReorderList_v2 {
    public void reorderList(ListNode head) {
         // find the middle of list
         ListNode slow = head;
         ListNode fast = head.next;
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         ListNode second = slow.next;
         slow.next = null;
         ListNode previous = null;

         // reverse the second part
        while(second != null) {
            ListNode next = second.next;
            second.next = previous;
            previous = second;
            second = next;
        }

        ListNode first = head;
        second = previous;
        ListNode tempLast = null; // TODO not necessary anymore, linked directly to temp1
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }
}