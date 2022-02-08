package com.company.easyPractice;

// System.out.print(Character.getNumericValue('b'));
public class anagram {
    public static int numberNeeded(String first, String second) {
        int result = 0 ;
// compare max number of matches for first and second
// CountSort
        int firstAry[] = count_String(first);
        int secondAry[] = count_String(second);

        for (int index = 0; index < 26 ; index ++){

            result = result + Math.abs(  firstAry[index] - secondAry[index]);
        }

        return result;

    }

    private static int[] count_String(String input){
        int uniOffset = 10 ;
        int [] letters = new int[26];
        for ( int i = 0; i < input.length(); i ++){

            letters[ Character.getNumericValue( input.charAt(i) ) - uniOffset]
             += 1;

            }

        return letters;
    }

}
