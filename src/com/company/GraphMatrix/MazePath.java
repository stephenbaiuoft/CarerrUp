package com.company.GraphMatrix;

import java.util.*;

/**
 * Created by stephen on 1/10/17.
 */

// takes mxn adjacency matrix of 0,1
// check if starting at point (0,0), if you can reach a point of value 9.
public class MazePath {
    public MazePath(){
        int[][] matrix = {
                {1,1,1,1},
                {0,1,0,0},
                {1,1,1,0},
                {0,0,0,0}
        };

        System.out.print (  Arrays.deepToString(matrix) + " will be: \n" );
        System.out.print ( checkPath(matrix) );

    }

    public boolean checkPath(int[][] matrix){
        // 1 mean path
        // 0 mean wall cannot proceed

        // Idea use DFS (but 不用check connect back)
        if (matrix ==null || matrix[0].length == 0 ) return false;

        Queue <int[]> mQueue = new LinkedList<>();
        if (matrix[0][0] ==9 ) return true;
        matrix[0][0] = 1;
        mQueue.offer(new int[]{0,0});

        int row = matrix.length;
        int col = matrix[0].length;


        int [] cur ;
        int [] next;

        // left, right, up, down
        int directX[] = {-1,1,0,0};
        int directY[] ={0,0,1,-1};
        while(!mQueue.isEmpty()){
            cur =  mQueue.poll();

            if( matrix[cur[0] ][cur[1] ] == 9){
                return true;
            }
            for(int i = 0; i < 4; i++){
                next = new int[]{
                  cur[0] + directX[i], cur[1] + directY[i]
                };
                if ( (next[0] > -1)&&(next[0] < row)&&
                        ( (next[1] > -1) && (next[1] < col))
                //check if valid position
                        ){
                    if (matrix[next[0]][next[1]] >= 1)
                        // Add if if cur satisfies the condition
                    mQueue.offer(next);
                }

            }

            // mark current one as visited, by saying its now a wall
            matrix[cur[0]][cur[1]] = 0;

        }
        return false;
    }
}
