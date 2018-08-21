package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class L207_M {
    // save visited nodes so far with dfs
    // save iterations
    public HashSet<Integer> dfsMap = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 ) return false;
        LinkedList<LinkedList<Integer>> map = new LinkedList<>();
        // create the map
        for (int i = 0; i < numCourses; i++) {
            map.add(new LinkedList<Integer>());
        }
        for (int[] pair: prerequisites) {
            map.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> visited = new HashSet<>();
            if (containCycle(map, visited, i)) {
                return false;
            }
        }

        return true;
    }


    // traverse through v iterative with dfs
    private boolean containCycle(LinkedList<LinkedList<Integer>>map, HashSet<Integer> visited, int v) {
        // dfsMap already traversed, then
        if (dfsMap.contains(v) && !visited.contains(v)) {
            return false;
        }
        // cycle detected
        else if (visited.contains(v)) {
            return true;
        }

        visited.add(v);
        LinkedList<Integer> l = map.get(v);
        for (Integer neighbor: l) {
            if (containCycle(map, visited, neighbor)) {
                return true;
            }
        }

        visited.remove(v);
        // add v to dfsMap
        dfsMap.add(v);
        // cycle not detected
        return false;
    }
}
