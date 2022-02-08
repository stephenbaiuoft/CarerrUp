package Graph;


import java.util.*;
/*
* Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them), find edges that can connect all the cities and spend the least amount.
Return the connects if can connect all the cities, otherwise return empty list.

Example
Example 1:

Input:
["Acity","Bcity",1]
["Acity","Ccity",2]
["Bcity","Ccity",3]
Output:
["Acity","Bcity",1]
["Acity","Ccity",2]
Example 2:

Input:
["Acity","Bcity",2]
["Bcity","Dcity",5]
["Acity","Dcity",4]
["Ccity","Ecity",1]
Output:
[]
*
* */

//思路 kruskal algorithm + union find -> checking whether a cycle would exist
public class L629_MinimumSpanningTree {
     class Connection {
        public String city1, city2;
        public int cost;
        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
     }

    class UnionSet {
        private int[] parents = null;
        private int[] ranks = null;

        public UnionSet(int n) {
            parents = new int[n+1];
            ranks = new int[n+1];

            // assign each as its own parent (inital state)
            for(int i = 1; i <= n; i++) {
                this.parents[i] = i;
            }
        }

        private int find(int u){
            // root means parents[pu] would still point to pu
            // by definition
            if (u != parents[u]) {
                parents[u] = find(parents[u]);
            }

            return parents[u];
        }

        private boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return false;
            if(ranks[pu] < ranks[pv]) {
                // make pu's parent to be pv
                parents[pu] = pv;
                ranks[pv]++;
            }
            else {
                parents[pv]=pu;
                ranks[pu]++;
            }

            return true;
        }
    }

    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        if (connections == null || connections.size()== 0) return connections;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> cityName = new HashSet<>();
        Comparator<Connection> comp = new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost)
                    return a.cost - b.cost;
                if (a.city1.equals(b.city1)) {
                    return a.city2.compareTo(b.city2);
                }
                return a.city1.compareTo(b.city1);
            }
        };

        Collections.sort(connections, comp);


        List<Connection> result = new ArrayList<>();
        int index = 1;
        // map index to connection
        for(Connection c: connections) {
            cityName.add(c.city1);
            cityName.add(c.city2);
            if (!map.containsKey(c.city1)) {
                map.put(c.city1, index++);
            }
            if (!map.containsKey(c.city2)) {
                map.put(c.city2, index++);
            }
        }

        UnionSet graph = new UnionSet(cityName.size());
        Connection cur = null;
        while(!connections.isEmpty()) {
            cur = connections.remove(0);
            if (graph.union(map.get(cur.city1), map.get(cur.city2))) {
                result.add(cur);
            }
        }

        // whether all can be connected --> n nodes then you must have n-1 connections
        if (result.size() != cityName.size()-1) {
            return null;
        }
        return result;
    }


}
