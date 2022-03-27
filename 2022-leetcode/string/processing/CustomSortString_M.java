package string.processing;

public class CustomSortString_M {
    public CustomSortString_M() {
        String s = "cba";
        String t = "abcd";

        String rez = customSortString(s, t);
        System.out.println(rez);
    }

    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null
                || T.length() == 0) {
            // no order is given or T is default
            return T;
        }

        int[] Tmap = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (S.indexOf(c) > -1 ) {
                Tmap[c - 'a'] ++;

            } else {
                sb.append(c);
            }
        }

        for (int i = S.length() - 1; i > -1 ; i--) {
            char c = S.charAt(i);

            while (Tmap[c - 'a'] -- > 0) {
                sb.insert(0, c);
            }
        }

        return sb.toString();
    }
}
