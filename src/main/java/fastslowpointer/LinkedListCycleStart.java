package fastslowpointer;

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        // TODO: Write your code here
        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;

        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println(slowPointer.value);
        int lengthOfCycle = 1;

        while (fastPointer.next != slowPointer) {
            lengthOfCycle++;
            fastPointer = fastPointer.next;
        }
        System.out.println(lengthOfCycle);

        slowPointer = head;
        fastPointer = head;
        for(int i = 1; i <= lengthOfCycle; i++) {
            fastPointer = fastPointer.next;
        }
        while (fastPointer != slowPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
