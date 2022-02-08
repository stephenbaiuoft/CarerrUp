package ByMonth.august.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L95_UniqueBST_M {
    public List<TreeNode> generateTrees(int n) {

        if ( n < 1) {
            List<TreeNode> list = new LinkedList<>();
            return list;
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(start>end){  trees.add(null); return trees;}

        for(int rootValue=start;rootValue<=end;rootValue++){
            List<TreeNode> leftSubTrees=generateTrees(start,rootValue-1);
            List<TreeNode> rightSubTrees=generateTrees(rootValue+1,end);

            for(TreeNode leftSubTree:leftSubTrees){
                for(TreeNode rightSubTree:rightSubTrees){
                    TreeNode root=new TreeNode(rootValue);
                    root.left=leftSubTree;
                    root.right=rightSubTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
