package UnionFind;

/*
*
* https://www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph/description?_from=ladder&&fromId=80
*
* Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors.
* (a weak connected component of a directed graph is a maximum subgraph in which any two vertices are connected by direct edge path.)

Sort the elements of a component in ascending order.

Have you met this question in a real interview?
Example
Example 1:

Input: {1,2,4#2,4#3,5#4#5#6,5}
Output: [[1,2,4],[3,5,6]]
Explanation:
  1----->2    3-->5
   \     |        ^
    \    |        |
     \   |        6
      \  v
       ->4


* */

import java.util.*;
public class L432_FindWeakConnectedComponentInDirectedGraph {
 class DirectedGraphNode {
     int label;
     ArrayList<DirectedGraphNode> neighbors;
     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 };

    class UnionSet {
        HashMap<Integer, Integer> parents = new HashMap<Integer, Integer>(); // easier because we don't know # of nodes anyway...

        public UnionSet(HashSet<Integer> hashSet) {
            for(Integer node : hashSet) {
                parents.put(node, node);
            }
        }
        protected int find(int u) {
            int pu =  parents.get(u);
            if (pu != u) {
                parents.put(u, find(pu));
            }

            return parents.get(u);

        }

        void connect(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu != pv)
                // let pv be pu's parent
                parents.put(pu, pv);
        }
    }

    List<List<Integer>>  getWeakConnectedComponent(HashSet<Integer> hashSet, UnionSet u) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<Integer, List <Integer>> hashMap = new HashMap<Integer, List<Integer>>();

        // looping through all nodes
        for (int node : hashSet) {
            int pNode = u.find(node);

            if (!hashMap.containsKey(pNode)) {
                hashMap.put(pNode,  new ArrayList<Integer>());
            }

            hashMap.get(pNode).add(node);
        }

        for (List<Integer> component: hashMap.values()) {
            Collections.sort(component);
            ans.add(component);
        }

        return ans;
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        // get a list of all nodes
        for (DirectedGraphNode node : nodes) {
            hashSet.add(node.label);
            for (DirectedGraphNode neighbour : node.neighbors) {
                hashSet.add(node.label);
            }
        }

        UnionSet u = new UnionSet(hashSet);

        for(DirectedGraphNode node : nodes) {
            for(DirectedGraphNode neighbour : node.neighbors) {
                int pNode = u.find(node.label);
                int pNeighbor = u.find(neighbour.label);

                if (pNode != pNeighbor) {
                    u.connect(node.label, neighbour.label);
                }
            }
        }

        return getWeakConnectedComponent(hashSet , u);
    }
}
