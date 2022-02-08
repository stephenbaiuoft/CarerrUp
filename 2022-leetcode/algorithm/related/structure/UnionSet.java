package algorithm.related.structure;

// union find classic man!
public class UnionSet {
    // ranking from [1-n] inclusively
    private int[] parents = null;
    private int[] ranks = null;

    public UnionSet(int n) {
        this.parents = new int[n+1];
        this.ranks = new int[n+1];
        // init parents to itself at the beginning
        for (int i = 1; i <=n; i++) {
            parents[i] = i;
        }
    }

    // recursively find and updates i parents
    private int findParent(int i) {
        if (i != parents[i]) {
            parents[i] = findParent(parents[i]);
        }
        // return i'th parent
        return parents[i];
    }

    // union set i and set j
    private boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        // same parent already, it's false
        if (pu == pv) {
            return false;
        }

        if (ranks[pu] < ranks[pv]) {
            parents[pu] = pv;
            ranks[pv]++;
        } else{
            parents[pv] = pu;
            ranks[pu]++;
        }

        return true;
    }
}
