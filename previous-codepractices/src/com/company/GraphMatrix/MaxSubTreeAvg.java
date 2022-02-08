package com.company.GraphMatrix;

import java.util.ArrayList;

/**
 * Created by stephen on 1/12/17.
 */

//https://segmentfault.com/a/1190000007065158
/*
* 就是给一棵多叉树，表示公司内部的上下级关系。每个节点表示一个员工，
* 节点包含的成员是他工作了几个月(int)，以及一个下属数组(ArrayList<Node>)。
* 目标就是找到一棵子树，满足：这棵子树所有节点的工作月数的平均数是所有子树中最大的。
* 最后返回这棵子树的根节点。这题补充一点，返回的不能是叶子节点(因为叶子节点没有下属)，
* 一定要是一个有子节点的节点。
*
* */

class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}

class NodeInfo{
    // keeps track of nodeSum and nodeCount,
    // for the subtree (node)
    public int nodeSum;
    public int nodeCount;
    public NodeInfo(int sum, int count){
        nodeSum = sum;
        nodeCount = count;
    }
}

public class MaxSubTreeAvg {
    // to keep track of maxNode
    private Node maxNode ;
    private double maxAvg =Double.MIN_VALUE ;

    public MaxSubTreeAvg(){
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        getMaxAvgNode(root);

        System.out.println( "node is " + maxNode.val + "  maxAvg is " + maxAvg );
    }

    public  NodeInfo getMaxAvgNode(Node root){

        // Important to check root.children
        // Since for (Node child: root.children) will not execute if
        // the node contains no child


        if ( root.children == null || root.children.size() == 0)
            return new NodeInfo(root.val, 1);

        NodeInfo sum = new NodeInfo(root.val, 1);
        for (Node child : root.children) {
            NodeInfo nInfo = getMaxAvgNode(child);
            sum.nodeCount += nInfo.nodeCount;
            sum.nodeSum += nInfo.nodeSum;
        }
        double cAvg = (double) sum.nodeSum / sum.nodeCount;
        if (cAvg > maxAvg) {
            maxNode = root;
            maxAvg = cAvg;
        }
        return sum;



    }
}
