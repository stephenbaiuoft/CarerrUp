package Solutions;

import java.util.HashSet;

public class L36_ValidSudoku_M {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;

        // i: row,  j: col ==> note in the inner loop, switch i & j
        //                  ==> so each time we check (0th row, 0th col + 0th matrix)
        for(int i = 0; i < 9; i ++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> matrixSet = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                // check row
                if(board[i][j] != '.') {
                    if(!rowSet.add(board[i][j])) {
                        return false;
                    }
                }
                // check col
                if(board[j][i] != '.') {
                    if(!colSet.add(board[j][i])) {
                        return false;
                    }
                }

                // check for matrixSet
                int rowOffset = (i /3) * 3;
                int colOffset = (i %3) * 3;
                if(board[rowOffset + j/3][colOffset + j%3]!='.') {
                    if(!matrixSet.add(board[rowOffset + j /3][colOffset + j %3]))
                        return false;
                }

            }
        }

        return true;

    }
/*
Great solution!. Just trying to explain how to think about % and /. These two operators can be helpful for matrix traversal problems.

For a block traversal, it goes the following way.

0,0, 0,1, 0,2; < — 3 Horizontal Steps followed by 1 Vertical step to next level.

1,0, 1,1, 1,2; < — 3 Horizontal Steps followed by 1 Vertical step to next level.

2,0, 2,1, 2,2; < — 3 Horizontal Steps.

And so on…
But, the j iterates from 0 to 9.

But we need to stop after 3 horizontal steps, and go down 1 step vertical.

Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2, and resets back. So this covers horizontal traversal for each block by 3 steps.

Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.

So far, for a given block, you can traverse the whole block using just j.

But because j is just 0 to 9, it will stay only first block. But to increment block, use i. To move horizontally to next block, use % again : ColIndex = 3 * i%3 (Multiply by 3 so that the next block is after 3 columns. Ie 0,0 is start of first block, second block is 0,3 (not 0,1);

Similarly, to move to next block vertically, use / and multiply by 3 as explained above. Hope this helps.
*/

}
