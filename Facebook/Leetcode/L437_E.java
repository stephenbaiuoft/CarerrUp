package Leetcode;
/*
*
* You are given a binary Tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    The Tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

    Example:

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

    Return 3. The paths that sum to 8 are:

    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11
* */

import java.util.LinkedList;
import java.util.List;

public class L437_E {
    public L437_E() {

        TreeNode root = buildTestRoot();
        int rez = pathSum(root, 8);

    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        //!!!! note pathSum(root.left, sum)!!!!!! INSTEAD OF helper!!!!!!!!
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // return # of path up to this node
    private int pathSumFrom(TreeNode node, int remain) {
        // base case
        if (node == null) return 0;
        // whether this node is the one we look for
        int c = remain == node.val? 1: 0;
        int left = pathSumFrom(node.left, remain - node.val);
        int right = pathSumFrom(node.right, remain - node.val);

        return c + left + right;
    }


    private TreeNode buildTestRoot() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.left.left = new TreeNode(3);

        return root;
    }

/* 下面的fucntion是错误的！！！！！！！！ 因为recurssion 你好好考虑一下！！！！

* */

//private LinkedList<LinkedList<Integer>> result = new LinkedList<>();
//    private int gSum = 0;

//    public int pathSum(common.data.types.TreeNode root, int sum) {
//        gSum = sum;
//        int count = traverse(root, sum, new LinkedList<>());
//        return count;
//    }

    // return # of paths that add up to sum from this node
//    private int traverse(common.data.types.TreeNode node, int remain, LinkedList<Integer> trace) {
//        // base case
//        if (node == null) return 0;
//
//
//        // whether this is a solution
//        int c = 0;
//        if (remain - node.val == 0) {
//            c = 1;
//            trace.add(node.val);
//            result.add(new LinkedList<>(trace));
//            trace.removeLast();
//        }
//
//        // including the current node
//        trace.add(node.val);
//        int left1 = traverse(node.left, remain - node.val, trace);
//        int right1 = traverse(node.right, remain - node.val, trace);
//        // exclusing the current node
//        trace.removeLast();
//
//        int left2 = traverse(node.left, gSum, trace);
//        int right2 =  traverse(node.right, gSum, trace);
//
//        if (node.val == 10){
//            if (remain == 8) {
//                System.out.print("here");
//            }
//            else {
//                System.out.print("not 8");
//            }
//        }
//
//
//
//        return c + left1 + left2 + right1 + right2;
//
//    }
}
