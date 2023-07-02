package _recall_75_questions;

import java.util.HashMap;
import java.util.Map;

public class _133_CloneGraph_v1 {
    Map<Integer,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clonedNode = new Node(node.val);
        map.put(node.val,clonedNode);

        for(Node nb : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(nb));
        }

        return clonedNode;
    }
}