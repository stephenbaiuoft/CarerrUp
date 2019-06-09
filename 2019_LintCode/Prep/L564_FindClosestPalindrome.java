package Prep;

public class L564_FindClosestPalindrome {
    // "807045053224792883"

    public L564_FindClosestPalindrome() {
        String rez = nearestPalindromic("10");
        System.out.println(rez);

    }

    //"807045053224792883"
    public String mirroring(String s) {
        String x = s.substring(0, (s.length()) / 2);
        return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse().toString();
    }

    public String nearestPalindromic(String n) {
        if (n.equals("1"))
            return "0";

        String a = mirroring(n);
        long diff1 = Long.MAX_VALUE;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
        if (diff1 == 0)
            diff1 = Long.MAX_VALUE;

        // have to handle by character due to very long ??
        StringBuilder s = new StringBuilder(n);
        int i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '0') {
            s.replace(i, i + 1, "9");
            i--;
        }
        if (i == 0 && s.charAt(i) == '1') {
            s.delete(0, 1);
            int mid = (s.length() - 1) / 2;
            s.replace(mid, mid + 1, "9"); // handle case like 10 -> 0, and this changes
                                                    // 0->9
            // Similarly -> 100XX then 99XX
            // and this changes 99XX to 9<9>XX regardless
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) - 1)); // numeric character decrease by 1
        String b = mirroring(s.toString());
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));


        s = new StringBuilder(n);
        i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '9') {
            s.replace(i, i + 1, "0");
            i--;
        }
        if (i < 0) { // as i = -1 in this case
            s.insert(0, "1"); // 99 -> 00 --> 100
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));  // 299 -> 399
        String c = mirroring(s.toString());
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));


        if (diff2 <= diff1 && diff2 <= diff3) // b is the smaller value as compared to case 1,a, due to a flipping larger
                                              // 10987 -> 10901 (case1), 11011 (case 2) so case 2 is preferred here
            return b;
        if (diff1 <= diff3 && diff1 <= diff2) // a is the minimum
            return a;
        else
            return c; // c seems always to be the larger portion
    }
}

/*
*     public String testIncorrect(String n) {
        if (n.equals("1"))
            return "0";

        String a = mirroring(n);
        long diff1 = Long.MAX_VALUE;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
        if (diff1 == 0)
            diff1 = Long.MAX_VALUE;

        // have to handle by character due to very long ??
        Long firstHalf = Long.parseLong(n.substring(0, (n.length() + 1)/2));
        firstHalf -= 1;
        StringBuilder s = new StringBuilder(String.valueOf(firstHalf));

        int count = s.length()-1;
        while (count > 0) {
            s.append(0);
            count--;
        }

        String b = mirroring(s.toString());

        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));


        s = new StringBuilder(n);
        int i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '9') {
            s.replace(i, i + 1, "0");
            i--;
        }
        if (i < 0) {
            s.insert(0, "1");
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
        String c = mirroring(s.toString());
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

        if (diff2 <= diff1 && diff2 <= diff3)
            return b;
        if (diff1 <= diff3 && diff1 <= diff2)
            return a;
        else
            return c;
    }
*
* */