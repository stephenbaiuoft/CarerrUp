package Microsoft;
/**
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree?
 Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
     1
    /  \
   2    3
  / \    \
 4   5    7
 After calling your function, the tree should look like:

     1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \    \
 4-> 5 -> 7 -> NULL
 */

public class L117_connectTrees_H {

    class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root; // current node
        TreeLinkNode prev = null; // w.r.t cur: next level, current pointed node
        TreeLinkNode head = null; // w.r.t. cur: next level, head node

        // idea: 1. traverse down to each level
        // 2. iterate through levels, and build connections based on prev...

        while(cur !=null) {

            // at each level
            while(cur!=null) {
                // build its next level connection!
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    }
                    else{
                        head = cur.left;
                    }
                    prev = cur.left;
                }

                if (cur.right != null) {
                    if (prev != null ) {
                        prev.next = cur.right;
                    }
                    else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }

                // traverse through cur.next level to the right
                cur = cur.next;
            }

            // set cur to the starting point of the next level
            cur = head;
            head = null;
            prev = null;
        }


    }
}

