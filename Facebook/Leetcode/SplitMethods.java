package Leetcode;

public class SplitMethods {
    public SplitMethods() {
        // Only Beginning of / will give empty "" to the array
        // The End / case will not
        String s = "/a//b/";
        String s1 = "//";
        String[] rez = s.split("/+");
        String [] rez1 = s1.split("/+");
        System.out.print("a");
    }
}
