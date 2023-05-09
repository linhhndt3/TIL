package _75_questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CloneGraph_v1 {
    public Node cloneGraph(Node node) {
        return cloneGraphHelper(node,new HashSet<>());
    }

    public Node cloneGraphHelper(Node node, Set<Integer> visited ) {
        if(visited.contains(node.val)) {
            return node;
        }
        if(node.neighbors == null || node.neighbors.size() == 0) {
            visited.add(node.val);
            return new Node(node.val);
        }
        List<Node> clonedNeighbors = new ArrayList<>();
        Node clonedNode = new Node(node.val);
        for (Node neighbor : node.neighbors) {
            Node clonedNeighbor = cloneGraphHelper(neighbor,visited);
            clonedNeighbors.add(clonedNeighbor);
        }
        clonedNode.neighbors = clonedNeighbors;
        visited.add(clonedNode.val);
        return clonedNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
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