package com.company.GraphMatrix;

import java.util.ArrayList;

/**
 * Created by stephen on 1/12/17.
 */

/*
class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}*/

//这个类是自己写的,要不不好找,两个成员变量分别是当前的总和和人数
class SumCount{
    int sum;
    int count;
    public SumCount(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}

public class SolutionMaxSubTreeAvg{
    //两个全局变量用来找最小的平均值,和对应的节点
    private  double resAve = Double.MIN_VALUE;
    private  Node result;
    public  Node getHighAve(Node root){
        if (root == null) return null;
        dfs(root);
        return result;
    }
    //后序遍历递归。
    private SumCount dfs(Node root){
        // 这里必须先把叶子节点刨掉，注意看我的手法，其实没什么。
        if (root.children == null || root.children.size() == 0){
            return new SumCount(root.val, 1);
        }
        //把当前root的材料都准备好
        int curSum = root.val;
        int curCnt = 1;
        //注意了这里开始遍历小朋友了
        for (Node child : root.children) {
            SumCount cSC = dfs(child);
            //每次遍历一个都把sum,count都加上，更新
            curSum += cSC.sum;
            curCnt += cSC.count;
        }
        double curAve = (double) curSum/curCnt;
        //这里看一下最大值要不要更新
        if (resAve < curAve){
            resAve = curAve;
            result = root;
        }

        return new SumCount(curSum,curCnt);
    }
    //这回测试的code行数有点儿多。

    public SolutionMaxSubTreeAvg() {
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

        Node res = getHighAve(root);
        System.out.println(res.val + " " + resAve);
    }
}