package com.company.november;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class SimpleSolutionSet {
    public void run(){

        byte term1 = (byte)0xaa, term2 = (byte)0xba;
        grayCheck test = new grayCheck();
        System.out.println (test.check(term1, term2));
    }

}

class  grayCheck{
        int check(byte term1, byte term2) {
        // XOR operation by bit
        // for gray code there is only one diff between two terms
        byte rst = (byte)(term1 ^ term2);
            System.out.println("value of rst is " + (int) rst);
            if ( (int) rst % 2 == 0){
                // correct
                return 1;
            }
        return 0;
    }
}

// returns shortest path
class PathSum {
    public int Solution( TNode root) {
        if (root == null)   return 0;
        if (root.left != null && root.right == null)
            return Solution(root.left) + root.val;
        if (root.left == null && root.right != null)
            return Solution(root.right) + root.val;
        return Math.min(Solution(root.left), Solution(root.right)) + root.val;
    }
}
class TNode {

        TNode left;
        TNode right;
        int val;

}