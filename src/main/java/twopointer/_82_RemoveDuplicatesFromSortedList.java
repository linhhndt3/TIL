package twopointer;

public class _82_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        //TODO refactor
        if(head == null) {
            return head;
        }
        ListNode slower = head;
        ListNode faster = slower.next;
        while(faster != null) {
            if(faster.val != slower.val) {

                if(faster.next != null) {
                    if(faster.next.val == faster.val) {
                        while(faster.next!= null && faster.next.val == faster.val) {
                            faster = faster.next;
                        }
                        slower.next = faster.next;
                    } else {
                        slower = faster;
                    }

                }
                faster = faster.next;

            } else {
                while (faster != null && slower.val == faster.val) {
                    slower = faster;
                    faster = faster.next;
                }
                if(slower.val == head.val) {
                    head = faster;

                }
                slower = faster;
                if(faster != null) {
                    faster = faster.next;
                }
            }
            
        }
        return head;
    }
}
