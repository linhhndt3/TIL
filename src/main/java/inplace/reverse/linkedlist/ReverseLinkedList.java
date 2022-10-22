package inplace.reverse.linkedlist;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        // TODO pls recall(encapsulate knowledge)
        // TODO recall the felling that is uncomfortable when you are panic
        ListNode pre = null;
        ListNode next = head;
        while (next != null) {
            ListNode curNext = next;
            ListNode tempNext = next.next;
            curNext.next = pre;
            pre = next;
            next = tempNext;
        }

        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
