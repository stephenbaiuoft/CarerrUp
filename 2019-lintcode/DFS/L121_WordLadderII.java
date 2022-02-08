package DFS;

import java.util.*;

public class L121_WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);

        bfs(map, distance, end, dict);

        List<String> path = new ArrayList<String>();

        dfs(ladders, path, start, end, distance, map);

        return ladders;
    }


    private void dfs(List<List<String>> ladders, List<String> path, String cur,
             String end, Map<String, Integer> distance,
             Map<String, List<String>> map) {
        path.add(cur);
        if (cur.equals(end)) {
            ladders.add(new ArrayList<String>(path));
        } else {
            for (String next : map.get(cur)) {
                if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
                    dfs(ladders, path, next, end, distance, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
             String start, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);

        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        while (!q.isEmpty()) {
            String cur = q.poll();

            List<String> nextList = explore(cur, dict);
            for (String neighbor: nextList) {
                map.get(neighbor).add(cur);
                // make sure it's has not been explored
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(cur) + 1);
                    q.offer(neighbor);
                }
            }
        }
    }

    // explore all possible alternative options for a string
    private List<String> explore(String str, Set<String> dict) {
        List<String> neighborList = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != str.charAt(i)) {
                    String changed = str.substring(0, i) + ch
                            + str.substring(i + 1);
                    if (dict.contains(changed)) {
                        neighborList.add(changed);
                    }
                }
            }
        }

        return neighborList;
    }
}
