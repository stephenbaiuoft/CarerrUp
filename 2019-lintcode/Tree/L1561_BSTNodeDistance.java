package Tree;

import common.data.types.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class L1561_BSTNodeDistance {
    public int bstDistance(int[] numbers, int v1, int v2) {
        // Write your code here

        HashSet<Integer> set = new HashSet<Integer>(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
        if (!set.contains(v1) || !set.contains(v2)) {
            return -1;
        }

        TreeNode root = buildTree(numbers);
        TreeNode parent = getLCA(root, v1, v2);

        return getDist(parent, v1) + getDist(parent, v2);
    }

    private int getDist(TreeNode root,  int value) {
        int count = 0;
        while (root.val != value) {
            if ( value < root.val) {
                root = root.left;
            } else if (value > root.val){
                root = root.right; // node.val > root
            } else {
                return count;
            }
            count++;
        }

        return count;
    }

    private TreeNode getLCA(TreeNode root, int v1, int v2)  {
        if (root == null || root.val == v1 || root.val == v2) {
            return root;
        }

        TreeNode left = getLCA(root.left, v1, v2);
        TreeNode right = getLCA(root.right, v1, v2);

        if (left != null && right!= null) {
            return root; // current one
        }

        return left != null? left: right;
    }


    private TreeNode buildTree(int[] numbers) {
        TreeNode root = new TreeNode(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            insert(root, numbers[i]);
        }

        return root;
    }

    private void insert(TreeNode root, int value) {
        while (root != null ){
            if (value < root.val) {
                if (root.left == null ) { // insert here as root.left is null
                    root.left = new TreeNode(value);
                    return;
                } else {
                    root = root.left;   // go left and continue
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(value);
                    return;
                } else {
                    root = root.right;  // go right and continue
                }
            }
        }

    }
}
