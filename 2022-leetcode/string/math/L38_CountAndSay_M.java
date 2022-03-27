package string.math;

public class L38_CountAndSay_M {
    public String countAndSay(int n) {
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            String s = prev;
            int count = 1;
            // iterate through s from index 1 to
            for (int j = 1; j <= s.length(); j++) {
                if (j == s.length() || (s.charAt(j) != s.charAt(j-1))){
                    // end
                    // or not equal, you can see it's the same case
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count = 1;
                }
                else {
                    count +=1;
                }
            }

            prev = sb.toString();
        }


        return prev;

    }
}
