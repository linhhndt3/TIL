package _75_questions;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        while (fp.next != null && fp.next.next != null && sp != null) {
            fp = fp.next.next;
            sp = sp.next;
            if(fp == sp) {
                return true;
            }
        }
        return false;
    }
}