package ByMonth.august.March;

import java.util.LinkedList;
import java.util.List;

public class L113_PathSumII_M {
    public List<List<Integer>> rez = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> l = new LinkedList<>();
        helper(root, sum, l);
        return rez;
    }

    public void helper(TreeNode root, int sum, LinkedList<Integer> l) {
        //base case
        if(root ==null) return;

        // CHOOOOOOOSE
        l.add(root.val);

        // EXPLORE
        if(root.left == null && root.right == null ) {
            if(root.val == sum) {
                // create a new copy for the list
                rez.add(new LinkedList<>(l));
                // remove the last element !! important
                l.removeLast();
                return;
            }
        }
        // go left or right
        else {
            helper(root.left, sum - root.val, l);
            helper(root.right, sum - root.val, l);
        }


        // UNCHOSE!!!!!!!!
        // backtracking!!!!!! IMPORTANT
        l.removeLast();
    }
}
