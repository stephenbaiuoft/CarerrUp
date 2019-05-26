package Codebase.BFS;

import java.util.*;

public class L137_CloneGraph {
    class UndirectedGraphNode {
       int label;
       ArrayList<UndirectedGraphNode> neighbors;

       UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
   };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return node;

        List<UndirectedGraphNode> oldNodeSet = getNodes(node);

        // use mapping to do the linking
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        // old --> new deeply copied node
        for (UndirectedGraphNode od: oldNodeSet) {
            // create
            map.put(od, new UndirectedGraphNode(od.label));
        }

        for (UndirectedGraphNode od: oldNodeSet) {
            UndirectedGraphNode newNode = map.get(od);
            for (UndirectedGraphNode oNeighbor: od.neighbors) {
                // add to newNode and update
                newNode.neighbors.add(map.get(oNeighbor));
            }
        }

        // return the new copied node
        return map.get(node);
    }

    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        visited.add(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode neighbor: cur.neighbors) {
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return new ArrayList<>(visited);
    }
}
