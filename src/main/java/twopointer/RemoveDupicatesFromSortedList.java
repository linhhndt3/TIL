package twopointer;

public class RemoveDupicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode previous = head;
        ListNode next = previous.next;
        while(next != null) {
            if(previous.val == next.val) {
                while(previous.val == next.val) {
                    next = next.next;
                }
                previous.next = next;
                previous = next;
                next = next.next;
            } else {
                ListNode tempNext = next.next;
                previous = next;
                next = tempNext;
            }
        }
        return head;
    }
}
