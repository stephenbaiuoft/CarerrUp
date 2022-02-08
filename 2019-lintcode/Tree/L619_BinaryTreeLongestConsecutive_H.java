package Tree;

import java.util.List;

/*

It's follow up problem for Binary Tree Longest Consecutive Sequence II

Given a k-ary Tree, find the length of the longest consecutive sequence path.
The path could be start and end at any node in the Tree

Example
Example 1:

Input:
5<6<7<>,5<>,8<>>,4<3<>,5<>,31<>>>
Output:
5
Explanation:
     5
   /   \
  6     4
 /|\   /|\
7 5 8 3 5 3

return 5, // 3-4-5-6-7
Example 2:

Input:
1<>
Output:
1

*
* */
public class L619_BinaryTreeLongestConsecutive_H {
    public class MultiTreeNode {
          int val;
          List<MultiTreeNode> children;
          MultiTreeNode(int x) { val = x; }
    }

    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return dfsBottomUp(root)[2];
    }

    // 0 for maxLen increasing
    // 1 for maxLen decreasing
    // 2 for maxLen so far
    private int[] dfsBottomUp(MultiTreeNode node) {
        if (node == null) {
            return new int[] {0,0,0};
        }

        int[] nodeRez = new int[] {
                0,0,1
        };
        // update your result set
        for (MultiTreeNode child: node.children) {
            int[] childRez = dfsBottomUp(child);
            if (child.val == node.val + 1) {
                nodeRez[0] = Math.max(nodeRez[0], childRez[0]+1);
            }
            if (child.val == node.val - 1) { // decreasing
                nodeRez[1] = Math.max(nodeRez[1], childRez[1]+1);
            }
            // update the maxLen so far @ each level
            nodeRez[2] = Math.max(nodeRez[2], childRez[2]);
        }

        // whether this current can be connected
        // 4 cases
        // case 0: +1,    only itself --> +1 so CANNOT connect any child
        // case 1: +1 + down,       connecting downside
        // case 2: +1 + up,         connecting upside
        // case 3: +1 + up + down   connecting up + down a great loop!!!!!

        // result ===> all you need to add 1 and nodeRez[0] and nodeRez[1] can be 0 by default
        nodeRez[2] = Math.max(nodeRez[0] + nodeRez[1] + 1, nodeRez[2]);

        return nodeRez;
    }
}
