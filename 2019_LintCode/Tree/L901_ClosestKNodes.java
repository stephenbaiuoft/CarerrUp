package Tree;

import common.data.types.TreeNode;
import common.helpermethods.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L901_ClosestKNodes {
    public void runTest() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        List<Integer> rez = closestKValues(root, 3.71, 3);
        Helper.printList(rez);
    }

    public void runTest1() {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(90);
        root.right = new TreeNode(110);
        root.left.left = new TreeNode(80);
        root.left.right = new TreeNode(95);

        List<Integer> rez = closestKValues(root, 111, 4);
        Helper.printList(rez);
    }

    public void runTest2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(10);

        Stack<TreeNode> upperStack = getStack(root, 3.7);
        moveUpper(upperStack);
        moveUpper(upperStack);
        moveUpper(upperStack);
        moveUpper(upperStack);
        moveUpper(upperStack);
        moveUpper(upperStack);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        if (k == 0 || root == null) {
            return values;
        }

        Stack<TreeNode> lowerStack = getStack(root, target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);
        // 为了不重复 错开指
        if (target < lowerStack.peek().val) {
            moveLower(lowerStack);
        } else {
            moveUpper(upperStack);
        }

        for (int i = 0; i < k; i++) {
            if (lowerStack.isEmpty() ||
                    !upperStack.isEmpty() && target - lowerStack.peek().val > upperStack.peek().val - target) {
                values.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                values.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }

        return values;
    }

    private Stack<TreeNode> getStack(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);

            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return stack;
    }

    public void moveUpper(Stack<TreeNode> stack) { // move to the next larger element in the ascending (inOrder) order
        TreeNode node = stack.peek(); // here is peek important!!
        if (node.right == null) { //这里代表着最右的node 那么它的下一最大的 一定是一直往它的左上走 直到第一个node 或者 stackEmpty
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
            return;

        }

        // 这里 node.right != null 代表 它有right child --> 更大的 就一直向右边走 因为是 binary search Tree
        // 这个情况是: 3 退到 2， 然后 2 退到了4  因为4.right != 2
        //            然后下一个最大的 就是往右边走 开始存  6, 以及6的往左的所有node  因为这些node才是 inOrder中比4大的数字
        //            假设 6的所有的left child按照顺序是：  6,5 这样
/*
*         4
*      2      6
*    1  3   5  10
*
*
* */
        node = node.right;
        while (node != null) { // 下一个最大的数字 一定是 right child里面的minimum 对吧
            stack.push(node);
            node = node.left;
        }
    }

    public void moveLower(Stack<TreeNode> stack) { // move to the lower smaller element in the descending (inOrder) order
        TreeNode node = stack.peek();
        if (node.left == null) { // 最小的值
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().left == node) {
                node = stack.pop();
            }
            return;
        }

        node = node.left; // 左边不是null 左边有children 那么上一个最小 接近它的值 就是 left children中最大的数字
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

}
