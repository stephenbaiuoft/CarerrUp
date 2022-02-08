package algorithm.related.structure;

public class NumArray {
    private SegTreeNode root = null;

    public NumArray() {
        int[] nums = new int[]{1,3,5};
        // build the segment Tree
        root = buildTree(nums, 0, nums.length-1);

        int val  = sumRange(0,2);
        System.out.println(val);
        update(1,2);

        val = sumRange(0,2);
        System.out.println(val);
    }

    public void update(int i, int val) {
        updateTree(root, i, val);
    }

    public int sumRange(int i, int j) {
        return queryRange(root, i, j);
    }

    private SegTreeNode buildTree(int[] nums, int start, int end) {
        if (start == end) {
            SegTreeNode node = new SegTreeNode(start, end, nums[start], null, null);
            return node;
        }

        int mid = (start + end)/2;
        SegTreeNode left = buildTree(nums, start, mid);
        SegTreeNode right = buildTree(nums, mid+1, end);

        SegTreeNode parent = new SegTreeNode(start, end, left.sum + right.sum, left, right);
        return parent;
    }

    private int queryRange(SegTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = (root.start + root.end)/2;
        if (end <= mid) {
            return queryRange(root.left, start, end);
        } else if (start > mid) {
            return queryRange(root.right, start, end);
        } else {
            // have to slice them 
            return queryRange(root.left, start, mid)
                    + queryRange(root.right, mid+1, end);
        }
    }

    // update a particular index
    private void updateTree(SegTreeNode node, int i, int newVal) {
        if (node.start == node.end && node.start == i) {
            node.sum = newVal;
            return;
        }

        int mid = (node.start + node.end)/2;
        if (i <= mid) {
            updateTree(node.left, i, newVal);
        } else {
            updateTree(node.right, i, newVal);
        }

        // back propagate the value
        node.sum = node.left.sum + node.right.sum;
    }

    class SegTreeNode {
        int start;
        int end;
        int sum;
        SegTreeNode left;
        SegTreeNode right;
        public SegTreeNode(int s, int e, int val, SegTreeNode left, SegTreeNode right) {
            start = s;
            end = e;
            sum = val;
            this.left = left;
            this.right = right;
        }
    }



}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */