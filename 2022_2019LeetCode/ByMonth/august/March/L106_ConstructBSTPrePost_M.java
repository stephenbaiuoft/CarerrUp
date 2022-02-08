package ByMonth.august.March;

import java.util.HashMap;

public class L106_ConstructBSTPrePost_M {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || inorder.length == 0 ) return null;
        // offset idea
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++ ) {
            // put the value as key and index as the value
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(inorder, postorder, inMap,
                0, inorder.length -1,
                0, postorder.length - 1
        );

        return root;
    }

    private TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> inMap,
                            int inStart, int inEnd, int postStart, int postEnd
    )
    {
        // basecase
        if(inStart > inEnd || postStart > postEnd || inEnd < 0 || postStart < 0) {
            return null;
        }

        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);

        // also the offset
        int inIdx = inMap.get(val);
        int offset = inEnd - inIdx;

        node.right = helper(inorder, postorder, inMap,
                inIdx + 1, inEnd,
                postEnd - offset,  postEnd - 1
        );

        node.left = helper(inorder, postorder, inMap,
                inStart, inIdx - 1,
                postStart,  postEnd - offset - 1
        );
        return node;
    }
}
