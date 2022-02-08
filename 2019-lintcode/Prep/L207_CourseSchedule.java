package Prep;

import java.util.*;

public class L207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological sort classic ->
        // return false;
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        int cur = 0;

        for (int[] req: prerequisites) {
            // req[0] -> depend on req[1]
            indegree.put(req[0], indegree.getOrDefault(req[0], 0)+1);
            if (!map.containsKey(req[1])) {
                map.put(req[1], new ArrayList<>());
            }
            // put all edges that depend on 1
            map.get(req[1]).add(req[0]);
        }

        // insert into q
        for (int i = 0; i < numCourses; i++) {
            if (!indegree.containsKey(i)) {
                q.add(i); // meaning these indices have 0 dependency
            }
        }

        while (!q.isEmpty()) {
            cur = q.poll();
            if (map.get(cur) != null) { // other indice depend on this index
                for (int dependent: map.get(cur)) {
                    //if (indegree.get(dependent) != null) {
                    if (indegree.get(dependent)==1) {
                        indegree.remove(dependent);
                        q.add(dependent);
                    } else {
                        indegree.put(dependent, indegree.get(dependent)-1); // update
                    }
                    //}
                }
            }
        }

        return indegree.size()==0;
    }
}
