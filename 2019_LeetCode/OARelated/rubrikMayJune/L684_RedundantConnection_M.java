package OARelated.rubrikMayJune;

public class L684_RedundantConnection_M {
    public int[] findRedundantConnection(int[][] edges) {
        // # of edges there are
        UnionFindSet uSet = new UnionFindSet(edges.length);

        for(int[] edge: edges) {
            if(!uSet.union(edge[0], edge[1])) {
                return edge;
            }
        }

        // not found so null
        return null;

    }

    // with n edges in total, assuming the number goes from 1 to n
    class UnionFindSet {
        // 1 to n for parents and ranks in order to manage find and union
        private int[] parents = null;
        private int[] ranks = null;

        public UnionFindSet(int n) {
            parents = new int[n+1];
            ranks = new int[n+1];

            // assign each as its own parent (inital state)
            for(int i = 1; i <= n; i++) {
                this.parents[i] = i;
            }
        }

        // along with compression
        private int find(int u){
            // root means parents[pu] would still point to pu
            // by definition
            if (u != parents[u]) {
                parents[u] = find(parents[u]);
            }

            return parents[u];
        }

        // union edge u and v, and mark their parents
        private boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            // these two edges are already connected
            if(pu == pv) return false;

            // now comparing ranks
            if(ranks[pu] < ranks[pv]) {
                // make pu's parent to be pv
                parents[pu] = pv;
                ranks[pv]++;
            }
            else {
                parents[pv] = pu;
                ranks[pu]++;
            }

            // now successfully unioned
            return true;
        }
    }
}
