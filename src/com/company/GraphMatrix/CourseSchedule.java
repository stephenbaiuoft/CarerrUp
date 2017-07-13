package com.company.GraphMatrix;

import java.util.*;

/**
 * Created by stephen on 1/12/17.
 */

// Leetcode 210
// https://leetcode.com/problems/course-schedule-ii/

// Yeah Own Solution Works!!!!

// csdn: Non-graph but easier solution!
//  http://blog.csdn.net/xudli/article/details/45912519

public class CourseSchedule {
    //1,0],[2,0],[3,1],[3,2]
    public CourseSchedule() {
        int[][] preq = {
                {1,3},
                {2,0},
                {3,1},
                {3,2}
        };

        int[] result = findOrder(4, preq);
        System.out.print( Arrays.toString(result));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses == 0) return new int[]{0};
        // convert edge lists to linked lists
        // stack or queue works anyway
        ArrayList mGraph = new ArrayList<Stack<Integer>>();
        int[] mRes = new int[numCourses];
        int mCount = 0;
        //boolean[] preq = new boolean[numCourses];

        for(int i = 0 ; i < numCourses; i ++){
            mGraph.add(new Stack<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            //preq[prerequisites[i][0]] =  true;
            Stack current = (Stack) mGraph.get(prerequisites[i][1]);
            current.add(prerequisites[i][0]);
        }

        // result to keep track of the order of dfs sequence
        Stack result = new Stack();

        //int[] result = new int[numCourses];
        // visited to keep track of the status of each vertex
        int[] visited = new int[numCourses];

        // now we have linked lists graph presentation
        for (int i = 0; i < numCourses; i++) {
            // false if this index does not have any pre-requisites
            /*
            if(!preq[i]) {
                mRes[mCount] = i;
                mCount++;
            }*/

            if (visited[i] == 0) {
                //false if there exists a cycle
                if (!dfs(mGraph, visited, result, i)) return new int[]{0};
            }
        }


        while (!result.isEmpty()){
            mRes[mCount] = (int) result.pop();
            mCount++;
        }

        return mRes;
    }

    // 0 is unvisited; 1 is being visited; 2 is done visiting
    public boolean dfs(ArrayList mGraph, int[] visited, Stack result, int vertex) {
        // cycle if detecting a grey vertex


        // mark it as grey
        visited[vertex] = 1;
        Stack nearby = (Stack) mGraph.get(vertex);

        while (!nearby.isEmpty()) {
            int nearbyIndex = (int) nearby.pop();
            if (visited[nearbyIndex] == 0) {
                // Only if false?
                if (!dfs(mGraph, visited, result, nearbyIndex))
                {
                    return false;
                }
            }
            else if (visited[nearbyIndex] == 1) {
               // System.out.print("Cycle Detected\n");
                return false;
            }
        }


        // mark this as done visiting
        visited[vertex] = 2;
        // add it to Stack, first in Last out
        result.add(vertex);
        return true;
    }
}