package Tree;

/*
* 367. Expression Tree Build
中文English
The structure of Expression Tree is a binary Tree to evaluate certain expressions.
All leaves of the Expression Tree have an number string value. All non-leaves of the Expression Tree have an operator string value.

Now, given an expression array, build the expression Tree of this expression, return the root of this expression Tree.

Example
Example 1:

Input:
["2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"]
 Output:
 {[-],[*],[/],[2],[6],[+],[+],#,#,#,#,[23],[7],[1],[2]}

 Explanation:
 The expression Tree will be like

	                 [ - ]
	             /          \
	        [ * ]              [ / ]
	      /     \           /         \
	    [ 2 ]  [ 6 ]      [ + ]        [ + ]
	                     /    \       /      \
	                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .

After building the Tree, you just need to return root node `[-]`.
Example 2:

Input:
 ["10","+","(","3","-","5",")","+","7","*","7","-","2"]
 Output:
 {[-],[+],[2],[+],[*],#,#,[10],[-],[7],[7],#,#,[3],[5]}
*
* */


public class L367_ExpressionTreeBuild {
     class ExpressionTreeNode {
       public String symbol;
       public ExpressionTreeNode left, right;
       public ExpressionTreeNode(String symbol) {
           this.symbol = symbol;
           this.left = this.right = null;
      }
    }

    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        return buildTree(expression, 0, expression.length-1);
    }

    public ExpressionTreeNode buildTree(String[] expression, int l, int r) {
         if (l == r) {
             ExpressionTreeNode node = new ExpressionTreeNode(expression[l]);
             return node;
         }

         int index = -1;
         int index0 = -1, index1 = -1;
         int pCounter = 0;
         while (l < r) {
             for (int i = r; i >=l; i--) {
                 if (expression[i].equals(")")) {
                     pCounter++;
                 }
                 else if (expression[i].equals("(")) {
                     pCounter--;
                 }
                 if (pCounter == 0 ) {// the root --> meaning pCount must be 0
                     if (expression[i].equals("+") || expression[i].equals("-")) {
                         if (index0 == -1) { // set valid + and - position
                             index0=i;
                         }
                     }
                     else if (expression[i].equals("*") || expression[i].equals("/")) {
                         if (index1 == -1) {
                             index1 = i;
                         }
                     }
                 }
             }
             index=index0==-1? index1: index0; // meaning index is * or / 优先 + -

             if (index != -1) {
                 break; // found it and we can exit
             }
             // else we can just keep getting rid of the parenthesis
             l++;
             r--;
         }

         if (index != -1) { // l == r and index is -1
             ExpressionTreeNode node = new ExpressionTreeNode(expression[index]);
             node.left = buildTree(expression, l, index-1);
             node.right = buildTree(expression, index+1, r);
             return node;
         }
         else if (l == r) {
             return new ExpressionTreeNode(expression[l]); // this is the case (10) and l == r and index is -1
         }
         else {
             return null; // (()) and nothing in .... we return null
         }
    }
}
