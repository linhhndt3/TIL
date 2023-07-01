package _recall_75_questions;

public class _143_ReorderList {

    // TODO
    // 1. fast pointer not correct
    // 2. cycle found when merge 2 list
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
            System.out.println("current fp :" + fastPointer.val);
            if(fastPointer.next == null) { // old size
                slowPointer = slowPointer.next;
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        System.out.println("sl start with val: " + slowPointer.val);
        // 2nd list
        ListNode secondList = slowPointer.next;
        System.out.println("seconlist start with val: " + secondList.val);
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

        System.out.println("currentP1 val: " + head.val);
        System.out.println("currentP2 val: " + pre.val);
        while (pre != null) {
            currentP1 = head;
            currentP2 = pre;

            currentP1.next = currentP2;
            if(currentMergedList != null) {
                currentMergedList.next = currentP1;
                currentMergedList = currentP2;
            } else {
                currentMergedList = currentP2;
            }

            head = head.next;
            pre = pre.next;
        }

        if(head != null) {
            currentMergedList.next = head;
        }
    }
}