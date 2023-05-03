package _75_questions;

public class ReorderList_v1 {
    public void reorderList(ListNode head) {
        // TODO refactor how to find the middle of list (fast & slow pointer technique)
        int numberOfNode = 1;
        ListNode orgHead = head;
        while(head.next != null) {
            head = head.next;
            numberOfNode++;
        }

        int numberOfRemainNode = 0;
        ListNode previous = null;
        ListNode current = orgHead;

        while(numberOfRemainNode <= numberOfNode / 2) {
            ListNode point = current.next;
            previous = current;
            current = point;
            numberOfRemainNode++;
        }

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        // previous is old tail. Now the linked list is 1 -> 2 <- 3 <- 4
        int numberOfReorder = 0;
        ListNode node1 = orgHead;
        ListNode node2 = previous;
        ListNode tailOfReorderList = null;
        while(numberOfReorder <= numberOfNode) {
            if(numberOfReorder == numberOfNode-2) {
                tailOfReorderList.next = node1;
                node2.next = null;
            }
            ListNode nextNode1 = orgHead.next;
            ListNode nextNode2 = node2.next;
            node1.next = node2;
            if(tailOfReorderList == null) {
                tailOfReorderList = node2;
            } else {
                tailOfReorderList.next = node1;
                tailOfReorderList = node2;
            }
            node1 = nextNode1;
            node2 = nextNode2;
            numberOfReorder = numberOfNode + 2;
        }
    }
}