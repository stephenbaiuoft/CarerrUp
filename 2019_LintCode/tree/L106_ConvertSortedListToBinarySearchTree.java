package tree;

/*
* 106. Convert Sorted List to Binary Search Tree
中文English
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Example
Example 1:
	Input: array = [1,2,3]
	Output:
		 2
		/ \
		1  3

Example 2:
	Input: [2,3,6,7]
	Output:
		 3
		/ \
	       2   6
		     \
		      7

	Explanation:
	There may be multi answers, and you could return any of them.
* */

import common.data.types.TreeNode;

public class L106_ConvertSortedListToBinarySearchTree {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
          this.val = val;
          this.next = null;
      }
    }
    private int getHeight(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    private ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        int height = getHeight(head);
        this.cur = head;
        return buildTree(height);
    }

    private TreeNode buildTree(int height) {
        if (height == 0) {
            return null;
        }

        TreeNode leftNode = buildTree(height/2);
        TreeNode node = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode rightNode = buildTree(height - height/2 - 1); // 1 is the offSet that you just used
        node.left = leftNode;
        node.right = rightNode;

        // 你最终return的parent的这个node 所以这个recursion的逻辑可以建立起来
        return node;
    }


}
