package Trees;

import java.util.ArrayList;

/**
 * Created by stephenbai on 2016-11-08.
 */
public class checkBST {
    public ArrayList<Integer> mAry = new ArrayList<>();

    public boolean check(Node n, int min, int max ){
        if (n == null){
            return true;
        }

        if ( n.val < min || n.val > max){
            return false;
        }

        return check(n.left, min, n.val -1) && check(n.right, n.val +1, max );

    }

    // inOrder left, root, right
    // check for correctness
    public void traverseTree(Node n){
        if (n!=null){
            traverseTree(n.left);
            mAry.add(n.val);
            traverseTree(n.right);
        }
    }

    public boolean convertCheck(){
        for (int i=0; i<mAry.size()-1;i++){
            if (mAry.indexOf(i)>=mAry.indexOf(i+1)){
                return false;
            }
        }
        return true;
    }

    public Node createTree(){
        Node root = new Node(10);
        root.left = new Node(5);

        root.right = new Node(20);
        return root;
    }
}

class Node {
    public  Node(int data){
        this.val = data;
        // default to 1
        this.ht = 1 ;
    }
    int val;
    int ht;
    Node left;
    Node right;

}

