package UnionFind;

public class L178_GraphValidTree {

    class UnionSet {
        protected int[] parents = null;
        public UnionSet(int n) {
            parents = new int[n]; // 1 - n
            for (int i = 0; i < n; i++) {
                parents[i] = i;
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
            if (pa != pb)
                parents[pa] = pb;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0 || n - 1 != edges.length) {
            return false;
        }

        UnionSet u = new UnionSet(n);

        for (int[]e: edges) {
            // if pu == pv here --> means
            int pu = u.findParents(e[0]);
            int pv = u.findParents(e[1]);
            if (pu == pv) {
                return false;
            }

            // we can connect here now
            u.connect(e[0], e[1]);
        }

        return true;
    }
}
