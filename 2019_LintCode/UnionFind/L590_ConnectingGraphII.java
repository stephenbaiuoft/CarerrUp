package UnionFind;

/*
*
* Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

connect(a, b), an edge to connect node a and node b
query(a), Returns the number of connected component nodes which include node a.

* */
public class L590_ConnectingGraphII {
    protected int[] parents = null;
    protected int[] size = null;
    public L590_ConnectingGraphII(int n) {
        parents = new int[n+1]; // 1 - n
        size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    private int findParents(int u) {
        int pu = parents[u];
        if (pu != u) {
            parents[u] = findParents(parents[u]);
        }

        return parents[u];
    }

    public void connect(int a, int b) {
        // write your code here
        int pa = findParents(a);
        int pb = findParents(b);
        if (pa != pb) {
            if (size[pa] < size[pb]) {
                parents[pa] = pb;
                size[pb] += size[pa];
            } else {
                parents[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }


    /**
     * @return: An integer
     */
    public int query(int node) {
        // write your code here
        int pnode = findParents(node);
        return size[pnode];
    }
}
