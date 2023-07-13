package _recall_75_questions;

public class _141_CycleList {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer != null) {
            if(fastPointer.next == null || fastPointer.next.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) {
                return true;
            }

        }

        return false;
    }
}