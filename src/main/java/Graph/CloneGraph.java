package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.neighbors.add(second);
        first.neighbors.add(third);
        second.neighbors.add(first);
        second.neighbors.add(third);
        third.neighbors.add(second);
        CloneGraph c = new CloneGraph();
        Node deepCopy = c.cloneGraphUsingHashMap(first);
        System.out.println(deepCopy.val);
    }


    public Node cloneGraph(Node node) {
        List<Node> visited = new ArrayList<>(100);
        for(int i = 0; i < 100; i ++){
            visited.add(null);
        }
        return cloneGraphHelper(node, visited);
    }

    private Node cloneGraphHelper(Node node, List<Node> visited) {
        // base case
        if (node == null) {
            return null;
        }
        Node isVisited = visited.get(node.val - 1);
        if (isVisited != null) {
            return visited.get(node.val - 1);
        } else {
            Node copy = new Node(node.val);
            visited.add(copy.val - 1, copy);
            for (Node neighbor : node.neighbors) {
                Node neighborCopy = cloneGraphHelper(neighbor, visited);
                if (neighborCopy != null) {
                    copy.neighbors.add(neighborCopy);
                }
            }
            return copy;
        }
    }

    public Node cloneGraphUsingHashMap(Node node) {
        Map<Node, Node> oldToNewNodeMappings = new HashMap<Node, Node>();
        return cloneGraphHelperUsingHashMap(node, oldToNewNodeMappings);
    }

    private Node cloneGraphHelperUsingHashMap(Node node, Map<Node, Node> visited) {
        // base case
        if (node == null) {
            return null;
        }
        Node isVisited = visited.getOrDefault(node, null);
        if (isVisited != null) {
            return isVisited;
        } else {
            Node copy = new Node(node.val);
            visited.put(node, copy);
            for (Node neighbor : node.neighbors) {
                Node neighborCopy = cloneGraphHelperUsingHashMap(neighbor, visited);
                if (neighborCopy != null) {
                    copy.neighbors.add(neighborCopy);
                }
            }
            return copy;
        }
    }
}


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

