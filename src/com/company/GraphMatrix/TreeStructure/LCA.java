package com.company.GraphMatrix.TreeStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by stephen on 1/13/17.
 */

// Lowest Common Ancestor

// http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

class Node
{
    int key;
    Node left, right, parent;

    Node(int key)
    {
        this.key = key;
        left = right = parent = null;
    }
}

public class LCA {
    public LCA(){
        // constructs
        //                 1
        //           2            3
        //       4      5     6       7


        Node root  = new Node(1);
        Node r2  = new Node(2);
        Node r3  = new Node(3);
        Node r4  = new Node(4);
        Node r5  = new Node(5);
        Node r6  = new Node(6);
        Node r7  = new Node(7);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        getLCA(root, r5,r4);

    }

    public Node getLCA( Node root ,Node a, Node b){
        ArrayDeque <Node> aPath = new ArrayDeque<Node>();
        ArrayDeque <Node> bPath = new ArrayDeque<Node>();

        // Assuming a && b exists in the Tree
        getPath(root, a.key, aPath);
        getPath(root, b.key, bPath);

        Node LCA = null;
        for ( Node n : aPath){
            if ( bPath.contains(n) ){
                LCA = n;
                break;
            }
        }
        if (LCA!=null){
            System.out.println("LCA value is: " + LCA.key);
        }else{
            // ..something is wrong
            System.out.println("Something is wrong");
            return null;
        }

        return LCA;
    }

    // get the Path from root to the particular node
    // ArrayList to keep track of Node
    public boolean getPath( Node root, int val, Queue mPath ){
        if (root == null) {
            return false;
        }

        if ( root.key == val){
            // do not need to add but sure
            mPath.add(root);
            return true;
        }

        // this node contains the val
        if ( getPath(root.left,  val,mPath ) || getPath(root.right, val, mPath)){
            mPath.add( root);
            return true;
        }

        return false;
    }
}
