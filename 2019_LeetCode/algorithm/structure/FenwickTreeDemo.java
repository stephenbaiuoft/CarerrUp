package algorithm.structure;

public class FenwickTreeDemo {
    public FenwickTreeDemo() {
        FenwickTree fTree = new FenwickTree(8);
        for (int i = 1; i <= 8; i++) {
            // update 1st with value of 1, 2nd with value of 2, and etc
            fTree.update(i, i);
        }

        fTree.show();

        // update 5 with 30 more
        fTree.update(5, 30);
        fTree.show();

    }

    class FenwickTree {
        private int[] sum = null;
        private int n = 0;
        public FenwickTree(int n) {
            // must be n+1 ---> this is because of 1-n example, and the lowBit delta property, we must
            // start from 1
            sum = new int[n+1];
            this.n = n;
        }
        // update i index with delta change
        public void update(int i, int delta) {
            // update starting from index
            while(i <= n) {
                sum[i] += delta;
                i += getLowBit(i);
            }
        }

        // query
        public int query(int i) {
            int tot = 0;
            while(i > 0) {
                tot += sum[i];
                i -= getLowBit(i);
            }
            return tot;
        }

        // helper to get lowBit
        private int getLowBit(int x) {
            // given -x = ~x + 1;
            return x& (-x); // this will give the right-most sig one with 0s
            // 0x01110 -> 0x10
            // 0x0000100001 -> 0x01
        }

        private void show() {
            System.out.println("the tree starting");
            for(int i = 1; i <= n; i++) {
                // sum.length > n yeah!!
                System.out.println(sum[i]);
            }
            System.out.println("the tree ending");

            for (int i = 1; i<=n; i++) {
                System.out.println( "up to " + i + " is:" + query(i));
            }
        }
    }

}
