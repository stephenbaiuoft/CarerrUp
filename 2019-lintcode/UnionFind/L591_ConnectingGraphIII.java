package UnionFind;

/*
*
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

connect(a, b), an edge to connect node a and node b
query(), Returns the number of connected component in the graph


* */

// 把这个class变成unionset的这样的数据结构
public class L591_ConnectingGraphIII {
    //
    protected int[] parents = null;
    // protected int[] ranks = null;
    protected int count = -1;
    public L591_ConnectingGraphIII(int n) {
        this.count = n;
        parents = new int[n+1]; // 1 - n
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        //ranks = new int[n+1];
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
            count--;
            parents[pb] = pa;
        }
    }


    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return this.count;
    }

}
