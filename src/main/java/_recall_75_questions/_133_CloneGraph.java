package _recall_75_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class _133_CloneGraph {

    private Map<Integer,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);

        for(Node neighbor : node.neighbors) {
            Node clonedNeighbor = cloneGraph(neighbor);
            clonedNode.neighbors.add(clonedNeighbor);
        }
        return clonedNode;
    }
}