package Leetcode;

public class L273_IntegerToEnglish_H {
    public L273_IntegerToEnglish_H(){
        String rez = numberToWords(12345);
    }

    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // set for Hundred, Thousand, Million, Billion
    private final int[] base = new int[] {
            10, 100, 1000, 1000000, 1000000000
    };


    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String rez = helper(num).trim();
        return rez;
    }

    public String helper(int num) {
        // Result is Important
        // To Get Rid of Trailing WhiteSpaces!!!!!
        String result = "";
        if (num == 0) return "";
        else if (num < 10) {
            result =  belowTen[num];
        }
        else if (num < 20)
        {
            result = belowTwenty[num-10];
        }
        else if (num < 100) {
            result = belowHundred[num/base[0]] + " " + helper(num%base[0]);
        }
        // hundreds
        else if (num < 1000) {
            result = helper(num/base[1]) + " Hundred "  + helper(num%base[1]);
        }
        // thousands
        else if (num < 1000000) {
            result = helper(num/base[2]) + " Thousand " + helper(num%base[2]) ;
        }
        // millions
        else if (num < 1000000000) {
            result = helper(num/base[3]) + " Million " + helper(num % base[3]) ;
        }
        // billion
        else {
            result = helper(num/base[4]) + " Billion " + helper(num % base[4]);
        }

        return result.trim();
    }
}
