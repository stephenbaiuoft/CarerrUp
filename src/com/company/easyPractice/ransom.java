package com.company.easyPractice;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by stephenbai on 2016-10-22.
 */

/*
*
*        ransom test = new ransom();
         if (ransom.run("12 2\n" +
                 "h ghq g xxy wdnr anjst xxy wdnr h h anjst wdnr\n" +
                 "h ghq")){
             System.out.println("YES");
         }else{
             System.out.println("NO");
         }

* */
public class ransom {
    public static boolean run(String input){
        Scanner in = new Scanner(input);
        int m = in.nextInt();
        int n = in.nextInt();

        if (n > m) return false;
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String tmp = in.next();
            magazine[magazine_i] = tmp;
            // hashing and getting right values
            if (hashtable.containsKey(tmp)){
                hashtable.put(tmp, hashtable.get(tmp) + 1 );
            }else{
                // add 1
                hashtable.put(tmp, 1 );
            }
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
                String want = in.next();

            ransom[ransom_i] = want;
            if (hashtable.containsKey(want)){
                int check = hashtable.get(want) - 1;
                if (check < 0) return false;

                hashtable.put(want, check);

            }else{
                // return false
                return false;
            }

        }

        // all checked, return true
        return true;
    }
}
