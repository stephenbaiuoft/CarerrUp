package March;

public class L109_ConvertLLToBalancedTree_M {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        return buildBST(head, null);
    }

    // buildBST given head and tail (need tail s.t it will stop<==> due to linkedlist nature)
    private TreeNode buildBST(ListNode head, ListNode tail) {
        if(head == null || head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;
        // 1->2->3
        while(fast !=tail && fast.next !=tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // create node
        TreeNode node = new TreeNode(slow.val);
        node.left = buildBST(head, slow);
        node.right = buildBST(slow.next, tail);

        return node;
    }
}
