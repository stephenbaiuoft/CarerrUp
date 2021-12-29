package tree_traversal;

import common.data.types.Node;

import java.util.Stack;

public class TreeTraversal2021 {
    // Post Traversal
    // V(L), V(R), N
    public void postTraversal(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node cur;

        if (root != null)
            s1.push(root);
        else return;

        while (!s1.isEmpty()) {
            cur = s1.pop();

            // s2.push(cur) first so that it'll be lastly out in s2 at this point
            s2.push(cur);

            // Note it's s1
            // s1 push left first, followed by s1 push right
            // so when it gets into S2 on line 23, the order
            // s1 (left, right) ==> s2 (right, left)
            // when you pop, it'd be left, right, node, which is post order
            if (cur.left !=null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
        }

        while (!s2.isEmpty()) {
            cur = s2.pop();
            System.out.println(cur.val);
        }
    }

    // PreOrder is
    // N, L, R
    public void PreOrder(Node root) {
        Stack<Node> s = new Stack<>();
        Node cur;
        if (root == null) return;
        s.push(root);

        while(!s.isEmpty()) {
            cur = s.pop();
            // Explore the current value
            System.out.println(cur.val);

            // R, L Order so that when you pop in stack s, it'll be L, R order
            if (cur.right!= null) {
                s.push(cur.right);
            }

            if (cur.left != null) {
                s.push(cur.left);
            }
        }

    }


    // L, N, R
    public void InOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        // have cur = root
        Node cur = root;

        // It's OR LOGIC HERE!!!
        while (cur != null || !stack.isEmpty()) {
            // Always Go to the furthermost left
            while (cur != null) {
                // put in onto stack
                stack.push(cur);
                // Let's go LEFT!!!!!
                cur = cur.left;
            }

            // At this point, cur = null for sure

            // Now let's take from stack, and the top should be the furthermost LEFT
            cur = stack.pop();
            // Let's use this one here
            System.out.print(cur.val);

            // Remember, we'd go right 1 step here, so use if
            // Reassign cur to cur.right!!!!!!!!!!!!!!!!!!!!!!!!
            cur = cur.right;

        }

    }
}
