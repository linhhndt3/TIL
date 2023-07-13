package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class _138_CloneLinkedListWithRandomPointer {
    Map<Integer,RandomNode> mapIndexAndNewNode = new HashMap();

    public RandomNode copyRandomList(RandomNode head) {
        if(head == null) {
            return null;
        }
        int index = 0;
        RandomNode current = head;
        RandomNode newHead = null;
        RandomNode preOfNewNode = null;

        while(current != null) {
            RandomNode newNode = null;
            if(mapIndexAndNewNode.containsKey(index)) {
                newNode = mapIndexAndNewNode.get(index);
            } else {
                newNode = new RandomNode(current.val);
            }

            if(index == 0) {
                newHead = newNode;
            } else {
                preOfNewNode.next = newNode;
            }

            preOfNewNode = newNode;
            mapIndexAndNewNode.put(index,newNode);

            RandomNode randomNode = current.random;
            if(randomNode == null) {
                newNode.random = null;
            } else {
                int tempIndex = 0;
                RandomNode tempHead = head;
                while(tempHead != randomNode) {
                    tempHead = tempHead.next;
                    tempIndex++;
                }
                if(mapIndexAndNewNode.containsKey(tempIndex)) {
                    newNode.random = mapIndexAndNewNode.get(tempIndex);
                } else {
                    RandomNode newRandomNode = new RandomNode(randomNode.val);
                    newNode.random = newRandomNode;
                    mapIndexAndNewNode.put(tempIndex,newRandomNode);
                }
            }

            current = current.next;
            index++;
        }

        preOfNewNode.next=null;
        return newHead;
    }
}


class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}