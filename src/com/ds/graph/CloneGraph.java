package com.ds.graph;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node, Node> clonedMap = new HashMap<>();
        clonedMap.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            Node clone = clonedMap.get(poll);
            List<Node> neighbors = poll.neighbors;
            List<Node> children = new ArrayList<>();
            if(neighbors != null) {
                for(Node n: neighbors) {
                    Node clonedG = clonedMap.get(n);
                    if(clonedG == null) {
                        q.add(n);
                        clonedG =new Node(n.val);
                        clonedMap.put(n, clonedG);
                    }
                    children.add(clonedG);
                }
                clone.neighbors = children;
            }
        }
        return clonedMap.get(node);
    }
}
