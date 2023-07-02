package _recall_75_questions;

public class _143_ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (fastPointer != null) {
            if(fastPointer.next == null) { // even size
                break;
            }
            fastPointer = fastPointer.next;
            if(fastPointer.next == null) { // old size
                slowPointer = slowPointer.next;
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        // 2nd list
        ListNode secondList = slowPointer.next;

        // connect slow pointer to null -> 1st list;
        slowPointer.next = null;

        // reverse secondList -> 2nd list
        ListNode pre = null;
        ListNode current = secondList;
        while (current != null) {
            ListNode tempCurrent = current.next;
            current.next = pre;
            pre = current;
            current = tempCurrent;
        }
        // merge two list
        ListNode currentMergedList = null;
        ListNode currentP1 = head;
        ListNode currentP2 = pre;

        while (pre != null) {
            currentP1 = head;
            currentP2 = pre;

            ListNode tempNextP1 = currentP1.next;
            ListNode tempNextP2 = currentP2.next;

            currentP1.next = currentP2;
            if(currentMergedList != null) {
                currentMergedList.next = currentP1;
                currentMergedList = currentP2;
            } else {
                currentMergedList = currentP2;
            }

            head = tempNextP1;
            pre = tempNextP2;
        }
        if(head != null) {
            currentMergedList.next = head;
        }
    }

}