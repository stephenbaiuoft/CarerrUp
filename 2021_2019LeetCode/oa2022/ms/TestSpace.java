package oa2022.ms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TestSpace {


    public TestSpace() {
        int a = Integer.MIN_VALUE;



//        int[] ary = {
//                1, 2, 3, 4, 3,4,2,0
//        };
//        int[] ary1 = {
//
//        };
//        int[] ary2 = {
//            0, -1, -2, 0, -1, -2
//        };
//
//        int[] ary3 = {
//                Integer.MAX_VALUE
//        };
//
//        System.out.println(match(ary));
//        System.out.println(match(ary1));
//        System.out.println(match(ary2));
//        System.out.println(match(ary3));

//        leastSubString("aaaa");
//        leastSubString("");
//        leastSubString("cycle");
    }



    public boolean match(int[] ary) {
        if (ary == null || ary.length <= 1) return false;
        HashSet<Integer> set = new HashSet<>();
        int countMatch = 0;

        for  (int num: ary) {
            if (!set.contains(num)) {
                set.add(num);
                // increment this
                countMatch ++;
            } else { // does contain that num
                // decrease that number
                // remove this number, and decrease the count
                set.remove(num);
                countMatch --;
            }
        }


        return countMatch == 0;
    }

    public int leastSubString(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        // all to lower case
        char[] inputAry = input.toLowerCase().toCharArray();
        int count = 0;
        // to store && get the result
        List<String> list = new LinkedList<>();
        // to store the characters
        int[] set = new int[26];
        resetSet(set);
        int lastStartIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            int curCharIndex = inputAry[i] - 'a';
            // found first repetition as we go from left to right
            if (set[curCharIndex] != -1) {
                // we need to start a new substring, and i the repetition index, which should not be included
                list.add(input.substring(set[curCharIndex], i));
                // update lastStartIndex as i would be the earliest
                lastStartIndex = i;

                resetSet(set);
                // set it here
                set[curCharIndex] = i;

                count++;
            } else { // set[curCharIndex] is 0
                // set to be that starting index
                set[curCharIndex] = i;
            }

        }

        list.add(input.substring(lastStartIndex, input.length()));

        for(String str: list) {
            System.out.println("<" + str + ">");
        }

        // the last piece which increase by 1
        return count + 1;

    }


    private void resetSet(int[] ary) {
        for(int i = 0; i < ary.length; i++ ) {
            ary[i] = -1;
        }

    }



}
