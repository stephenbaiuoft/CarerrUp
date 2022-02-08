package Trees;

/**
 * Created by stephenbai on 2016-11-09.
 */

/* // test case 1
AVLTree mTree = new AVLTree();
        mTree.root = mTree.insert(mTree.root, 20);
        mTree.root = mTree.insert(mTree.root, 4);
        // check order
        mTree.postOrder(mTree.root);
        mTree.root = mTree.insert(mTree.root, 15);
        System.out.println("**check order**");
        mTree.postOrder(mTree.root);*/


// test case 2
//AVLTree mTree = new AVLTree();
//
//        mTree.root = mTree.insert(mTree.root, 3);
//        mTree.root = mTree.insert(mTree.root, 2);
//        mTree.root = mTree.insert(mTree.root, 4);
//        mTree.root = mTree.insert(mTree.root, 5);
//        mTree.root = mTree.insert(mTree.root, 6);
//        //mTree.root = mTree.insert(mTree.root, 6);
//        mTree.treeBalance(mTree.root);
//        System.out.println("*******");
//        mTree.postOrder(mTree.root);

public class AVLTree {
    public AVLNode root;

    public void treeBalance(AVLNode node){
        if (node!=null) {
            System.out.print( node.data+" ("+
                    getBalance(node)+")\t");

            treeBalance(node.left);
            treeBalance(node.right);
        }
    }
    // prints order & height of this AVL Tree
    public void postOrder(AVLNode node){
        if (node!=null) {
            System.out.println("val: " + node.data + " h: " + node.height);
            postOrder(node.left);
            postOrder(node.right);

        }
    }

    // prints order & height of this AVL Tree
    public void preOrder(AVLNode node){
        if (node!=null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println("val: " + node.data + " h: " + node.height);

        }
    }

    public int getHeight(AVLNode n){
        if (n!=null) return n.height;
        return 0;
    }


    // inserting a value onto the Tree
    public AVLNode insert(AVLNode node, int val){
        // base case
        if (node == null){
            return (new AVLNode(val));
        }

            // important this is recurssion so only yourself!!!
            if (val <= node.data){
                node.left = insert( node.left, val);
            }else{
                node.right = insert(node.right, val);
            }

        // updates the height, given it's always +1 because of the subtree
        node.height = 1 + max(getHeight(node.left),getHeight(node.right) );
        int balance = getBalance(node);

        // 4 cases LL, LR, RL, RR substructures
        if( (balance > 1) && ( val < node.left.data  )){
            // LL, do right rotation
            return rightRotate(node);
        }
        if ((balance > 1)&& (val > node.left.data)){
            // LR, since L: balance >1; R: val > node.left.data
            // so its node.left as node.left needs to point to leftRotate(node.left)
            // ... lower part is a RR substructure
           node.left = leftRotate(node.left);
            return rightRotate(node);
        }
         if((balance < -1) &&(val < node.right.data)){
            // balance < -1 so R, then val < node.right.data, so L
            // case is RL and we should modify  node.right( node here think of z
            // in this particular context anyway
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
         if((balance < -1)&&( val> node.right.data)){
            // RR so simple leftRotation
            return leftRotate(node);
        }

        // or balanced so simply return node
        return node;
    }


    // zNode means its left & right node differs by 2 ( if insert 1 node per time)
    // z, y, x refers grandparent(x), parent(x), x lowest height of all
    public AVLNode leftRotate(AVLNode zNode){
        AVLNode y = zNode.right;
        AVLNode yLeftSubTree = y.left;
        zNode.right = yLeftSubTree;
        y.left = zNode;

        // order matters!!! zNode then y
        //update height for y and zNode
        zNode.height = max(getHeight(zNode.left),getHeight(zNode.right) ) + 1;
        y.height=  max( getHeight(y.left), getHeight(y.right)) + 1;


        return y ;

    }

    public AVLNode rightRotate(AVLNode zNode){
        AVLNode y = zNode.left;
        AVLNode yRightSubTree = y.right;
        zNode.left = yRightSubTree;
        y.right = zNode;

        zNode.height = max(getHeight(zNode.left), getHeight(zNode.right)) +1;
        y.height = max(getHeight(y.left),getHeight(y.right)) +1;
        return y;
    }

    public int max(int left, int right){
        return (left > right)? left:right;
    }

    // returns difference between leftsubtree and right subtree
    public int getBalance(AVLNode node){
        if (node ==null) {return -1;}

        return ( getHeight(node.left) - getHeight(node.right));
    }
}

class AVLNode {
    public  AVLNode(int data){
        this.data = data;
        //has to be 1 as otherwise, u cannot distinguish between a node V.S NULL ( meaning no node )

        this.height = 0;
    }
    int data;
    int height;
    AVLNode left;
    AVLNode right;

}
