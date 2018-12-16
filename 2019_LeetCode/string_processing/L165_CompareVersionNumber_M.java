package string_processing;

public class L165_CompareVersionNumber_M {
    public L165_CompareVersionNumber_M() {
        String v1 = "1.0.1";
        String v2 = "1";
        compareVersion(v1, v2);
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null ) {
            return 0;
        }
        String[] c1 = version1.split("\\.");
        String[] c2 = version2.split("\\.");
        if (c1.length < c2.length) {
            return helper(c2, c1) * -1;
        }
        return helper(c1, c2);
    }

    // assuming c1 >= c2 length wise
    private int helper(String[] c1, String[] c2) {
        int s1 = 0;
        int s2 = 0;
        int i = 0;
        for (i = 0; i < c1.length; i++) {
            int n1 = Integer.parseInt(c1[i]);
            // make n2 0 to compare with
            int n2 = i >= c2.length? 0: Integer.parseInt(c2[i]);

            if ( n1 > n2 ) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            } else {
                continue;
            }
        }

        return 0;
    }
}
