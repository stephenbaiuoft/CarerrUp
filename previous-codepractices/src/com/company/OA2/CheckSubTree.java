package com.company.OA2;

/**
 * Created by stephen on 1/8/17.
 */

class Node{
    Node left ;
    Node right;
    int value ;
}

public class CheckSubTree {


    // the Tree starting on every Node
    public boolean ifIdentical(Node root, Node subtree){
        if (root == null && subtree == null)
            return true;
        if (root ==null || subtree == null){
            return false;
        }

        return ( root.value == subtree.value && ifIdentical(root.left, subtree.left)
        && ifIdentical(root.right, subtree.right) );
    }


    //
    public boolean ifSubTree( Node root, Node T ){

        // leaf null, then no need to check LintMain root
        if ( T == null) return true;
        // root null, then cannot match as ( leaf is null ) already returns True
        if ( root  == null ) return false;

        if (ifIdentical(root, T)) return true;
        return (  ifSubTree(root.left, T) || ifSubTree(root.right, T) );


    }
}
