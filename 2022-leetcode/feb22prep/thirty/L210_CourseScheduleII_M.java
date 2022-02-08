package feb22prep.thirty;

import java.util.*;

public class L210_CourseScheduleII_M {
    // https://www.youtube.com/watch?v=Qqgck2ijUjU&t=133s&ab_channel=HuaHua
    public static void main(String[] args) {
        // https://leetcode.com/problems/cheapest-flights-within-k-stops/

        L210_CourseScheduleII_M p = new L210_CourseScheduleII_M();
    }

    public L210_CourseScheduleII_M() {
        int[][] courses = new int[0][0];


        findOrder(4, courses);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // build graph
        // contructed dfs
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        LinkedList<Integer> trace = new LinkedList<>();
        int[] visited = new int[numCourses];

        for (int[] edge: prerequisites) {
            if (graph.get(edge[1]) == null) {
                List<Integer> l = new LinkedList<>();
                graph.put(edge[1], l);
            }

            List<Integer> tmp = graph.get(edge[1]);
            tmp.add(edge[0]);
        }

        // Iterate through every node
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i, trace)) return new int[0];
        }
        int[] traceAry = trace.stream().mapToInt(i->i).toArray();
        return traceAry;
    }

    // dfs --> but return true if cycle, false otherwise
    // trace to record the backtrack process
    public boolean dfs(HashMap<Integer, List<Integer>> graph, int[] visited, int curNode, LinkedList<Integer> trace) {
        // base case
        if (visited[curNode] == 1) return true; // visiting, and we saw it again, cycle
        if (visited[curNode] == 2) return false; // already visited, return false

        // Not visited, let's explore
        // Mark as visiting
        visited[curNode] = 1;

        // If still can go further
        if (graph.get(curNode) != null) {
            // Let's curNode neghbors?
            for (int node : graph.get(curNode)) {
                // if node found a cycle, then it's a cycle, return
                if (dfs(graph, visited, node, trace)) return true;
            }
        }
        // Mark as done visiting
        visited[curNode] = 2;
        // Always add to head, as the most basic one will be always the first
        trace.addFirst(curNode);
        return false;
    }

}
