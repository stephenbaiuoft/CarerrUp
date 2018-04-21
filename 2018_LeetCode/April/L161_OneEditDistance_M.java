package April;

public class L161_OneEditDistance_M {
    // 这个问题是   必须要1 edit away
    // 如果是  ""  vs  ""  也是false

    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null ) return false;
            // make sure s is smaller than t
        else if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        // s is 2 chars smaller than t:   i.e 4+1 < 6
        else if (s.length()+1 < t.length()) return false;

        // 2 cases
        // i.    axc vs avc (1 char edit for both)
        // ii_c0.   ac vs axc  (1 char removal on t)
        // ii_c1.   a vs a ??? nah (Never Mind not valid)
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // substring starting @ i
                //          VS
                // substring t starting @ i+1

                // also the first case
                return s.substring(i).equals(t.substring(i+1))
                        || s.substring(i+1).equals(t.substring(i+1));

            }
        }
        // whether s.length() is 1 char smaller than t?
        return s.length()+1 == t.length();
    }
}
