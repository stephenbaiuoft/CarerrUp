package string.math;

public class L43_MultiplyStr_M {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] answer = new int[m + n];
        int p1 = 0;
        int p2 = 0;

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                //0, ..., p1,p2 (where p2 > p1)

                p1 = i + j;
                p2 = i + j + 1;
                int carry = answer[p2];
                int compute = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;

                answer[p2] = compute % 10;
                answer[p1] += compute /10;

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int d: answer) {
            // do not add the leading 0
            if (!(sb.length() == 0 && d == 0)) {
                sb.append(d);
            }
        }
        return sb.length() == 0 ? "0": sb.toString();
    }
}
