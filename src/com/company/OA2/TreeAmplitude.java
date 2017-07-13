package com.company.OA2;

/**
 * Created by stephen on 1/8/17.
 */

/**
 * tree amplitutde:
 * the maximum difference among tree node values of all paths
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
        val = x;
        left = null;
        right = null;
    }
}

// recursion, O ( N^2 ) complexity as every node is recurred
// Try DP with O (N )
public class TreeAmplitude {
    TreeNode root;
    public TreeAmplitude(){
        getAmplitude( root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int getAmplitude( TreeNode node, int max, int min){
        if ( node == null) return max - min;
        max = Integer.max(node.val, max);
        min = Integer.min(node.val, min);

        return Integer.max( getAmplitude(  node.left, max,min),
                getAmplitude(node.right, max, min));
    }


}
