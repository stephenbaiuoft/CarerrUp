package ByMonth.august.March;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Note The solution asks for ITERATIVE solution !!! recursive is trivial!!!!!
public class L94_BTInTraversal_M {
    private Stack<TreeNode> stack = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        TreeNode cur = root;
        addToStack(cur);
        // popping the stack
        while(!stack.isEmpty()) {
            cur = stack.pop();
            // add the value to the list
            list.add(cur.val);
            // add possible right path
            addToStack(cur.right);
        }

        return list;
    }

    // this keeps adding node and it's possible left child!!!!!!!
    private void addToStack(TreeNode cur) {
        while(cur !=null) {
            stack.add(cur);
            cur = cur.left;
        }
    }
}
