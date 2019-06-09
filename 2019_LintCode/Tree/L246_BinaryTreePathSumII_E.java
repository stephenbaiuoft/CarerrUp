package Tree;

import common.data.types.TreeNode;

import java.util.*;

public class L246_BinaryTreePathSumII_E {
    public L246_BinaryTreePathSumII_E() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        //root.left.left = new TreeNode(4);

        List<List<Integer>> result = binaryTreePathSum2(root, 1);
    }

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        if (root == null)
            return results;
        findSum(root, target, buffer, 0, results);
        return results;
    }

    public void findSum(TreeNode head, int sum, ArrayList<Integer> path, int level, List<List<Integer>> results) {
        if (head == null) return;
        int tmpSum = sum;
        path.add(head.val);
        // 这里的order相当于 到每一层 先执行一次这个操作 按照visited的path
        for (int i = level;i >= 0; i--) { // notice it's reverse order
            tmpSum -= path.get(i); // check from the newly added node value, and list order is {first, 2nd, 3rd, ...}
            // adding from last to the first with every new element added in
            if (tmpSum == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j <= level; ++j) // this is the new path, starting from the current i until level
                    temp.add(path.get(j));
                results.add(temp);
            }
        }
        findSum(head.left, sum, path, level + 1, results);
        findSum(head.right, sum, path, level + 1, results);
        path.remove(path.size() - 1);
    }
    /*
    * if (node == null) { // no more to explore
            return;
        }
        // add node value to path
        // explore
        path.add(node.val);
        if (remain == node.val) {
            // base case, found 1 solution
            result.add(new ArrayList<>(path));
        }
        dfs(node.left, remain - node.val, target,
                path, result);
        dfs(node.right, remain - node.val, target,
                path, result);

        path.remove(path.size()-1);

        // case starting from the node
        dfs(node.left, target, target, new ArrayList<>(), result );
        dfs(node.right, target, target, new ArrayList<>(), result );
    * */
}
