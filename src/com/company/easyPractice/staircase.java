package com.company.easyPractice;

/**
 * Created by stephenbai on 2016-10-24.
 */

/*
        staircase run = new staircase();
        run.draw(6);
 */
public class staircase {
    public static void draw(int n ){
        String first = "";
        String second ="";
        for (int i = 1; i <= n ; i++){
            first = space( n - i );
            second = pound(i);
            System.out.println( first + second );
        }

    }

    public static String space(int n ){
        String result = "";
        for (int i = n ; i > 0 ; i--){
            result = result + " ";
        }
        return result;
    }

    public static String pound(int n ){
        String result = "";
        for (int i = 0; i <n ; i++){
            result = result + "#";
        }
        return result;
    }



}
