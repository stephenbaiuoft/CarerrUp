package Trees;

/**
 * Created by stephenbai on 2016-11-08.
 */

// prints Tree node in corresponding order
public class TreeOrder {
    public void preOrder(Node root){
        if(root!=null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root!=null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.println(root.val);
        }

    }

    public void inOrder(Node root){
        if(root!=null){
            preOrder(root.left);
            System.out.println(root.val);
            preOrder(root.right);
        }
    }


}
