package _75_questions;

import java.util.*;

public class CloneGraph_v2 {
    public Node cloneGraph(Node node) {
        Map<Integer,Node> map = new HashMap<>();
        return cloneGraphHelper(node,map);
    }

    public Node cloneGraphHelper(Node node, Map<Integer,Node> map) {
        // TODO miss the 3rd step(rough idea = intuition)
        if(node == null) {
            return null;
        }

        if(map.get(node.val) != null) {
            return map.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<Node>());
        map.put(clonedNode.val, clonedNode);
        for (Node neighbor : node.neighbors) {
            Node clonedNeighbor = cloneGraphHelper(neighbor,map);
            clonedNode.neighbors.add(clonedNeighbor);
        }

        return clonedNode;
    }
}