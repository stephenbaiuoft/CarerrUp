package com.company.javaClass;

import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by stephenbai on 2016-10-29.
 */
/*
* E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V etc. - 2nd, 3rd, 4th types
* */
/*
* 1. compare base on testing.string, if tie then int
*
* */
/*
*
*       comparator test = new comparator();
        test.run("5\n" +
                "amy 100\n" +
                "david 100\n" +
                "heraldo 50\n" +
                "aakansha 75\n" +
                "aleksa 150");

    }
*
* */

class mycomparator implements Comparator<Player> {
    public int compare(Player p1, Player p2){
        if (p1.score == p2.score){
            return p1.name.compareTo(p2.name);
        }
        return p2.score - p1.score;
    }
}

class mycomparatorv2 implements Comparator<Player> {
    public int compare(Player p1, Player p2){
        if (p1.score == p2.score){
            return p1.name.compareTo(p2.name);
        }
        return p1.score - p2.score;
    }
}

class Player implements Comparable <Player>{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    public int compareTo(Player other){
        // ascending order
        return this.score > other.score? 1: -1;
    }

}

public class comparatorexample {
    public static void run(String input) {
        Scanner scan = new Scanner(input);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        //Checker checker = new comparator();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        System.out.println("before sorting\t");
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
        System.out.println("*******************\n\nAfter sorting\t");
        // Arrays.sort(player);
        mycomparator com = new mycomparator();
        // This is how you sort array of types
        Arrays.sort(player, com);

        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }


        System.out.println("********************\n\nNow reverse the custom comparator");
        Arrays.sort(player, com.reversed());

        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }



        System.out.println("********************\n\n p1.score - p2.score\n");
        System.out.println("by default minComes on Top: minQueue or priorityQueue");
        Arrays.sort(player, new mycomparatorv2());

        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}