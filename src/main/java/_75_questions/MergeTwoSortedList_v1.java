package _75_questions;

public class MergeTwoSortedList_v1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TODO what is point? step by step pls
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode current1 = list1.val <= list2.val ? list1 : list2;
        ListNode current2 = current1 == list1 ? list2 : list1;
        ListNode sortedListNode = current1;

        ListNode nextC1 = current1.next;
        ListNode nextC2 = current2;
        ListNode current = current1;
        while(nextC1 != null || nextC2 != null) {
            if(nextC1 == null) {
                current.next = nextC2;
                return sortedListNode;
            }
            if(nextC2 == null) {
                current.next = nextC1;
                return sortedListNode;
            }
            if(nextC1.val <= nextC2.val) {
                current.next = nextC1;
                current = nextC1;
                nextC1 = nextC1.next;
            } else {
                current.next = nextC2;
                current = nextC2;
                nextC2 = nextC2.next;
            }
        }
        return sortedListNode;
    }
}