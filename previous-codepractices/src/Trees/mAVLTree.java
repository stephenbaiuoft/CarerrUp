package Trees;

/**
 * Created by stephenbai on 2016-11-09.
 */

//class Node {
//    public  Node(int data){
//        this.data = data;
//        // default to 1
//        this.height = 1 ;
//    }
//    int data;
//    int height;
//    Node left;
//    Node right;}

public class mAVLTree {
    AVLNode root;

    // my memorization of insert!!
    static Node insert(Node node,int val)
    {
        if (node == null){
            return new Node(val);
        }

        if ( val <= node.val){
            insert(node.left, val);
        }else{
            insert(node.right,val);
        }

        updateHeight(node);
        int balance = getBalance(node);
        if ((balance > 1)&&(val < node.left.val)){
            //LL do rightRotation
            return rightRotate(node);
        }
        if((balance>1)&&(val > node.left.val)){
            //LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if ((balance < -1)&&(val<node.right.val)){
            //RL
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        if ((balance < -1 )&&(val > node.right.val)){
            //RR
            return leftRotate(node);
        }

        return node;
    }

    static int getBalance(Node node){
        return (getHeight(node.left)
                - getHeight(node.right));
    }
    // remember x,y,z
    static Node leftRotate(Node z){
        Node y = z.right;
        Node yLeftSubTree = y.left;

        z.right = yLeftSubTree;
        y.left = z;
        //always update z then y cause y is higher!!
        updateHeight(z);
        updateHeight(y);
        return y;
    }


    static Node rightRotate(Node z){
        Node y = z.left;
        Node yRightSubTree = y.right;

        z.left = yRightSubTree;
        y.right = z;
        updateHeight(z);
        updateHeight(y);
        return y;
    }

    static void updateHeight(Node node){
        node.ht = max(getHeight(node.left),
                getHeight(node.right)) + 1;
    }

    static int getHeight(Node node ){
        if (node ==null) return 0;
        return node.ht;
    }

    static int max(int left, int right){
        return left > right? left: right;
    }
}
