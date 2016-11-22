package com.company.javaClass;

import java.util.Arrays;
import java.util.Comparator;
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
* 1. compare base on string, if tie then int
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
        System.out.println("After sorting\t\n\n");
        Arrays.sort(player);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}