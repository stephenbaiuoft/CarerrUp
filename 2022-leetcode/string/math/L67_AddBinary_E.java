package string.math;

public class L67_AddBinary_E {
    public static void main(String[] args) {
        L67_AddBinary_E p = new L67_AddBinary_E();
        p.addBinary("11", "1");
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        // ensure longer one as a
        int l = a.length()-1;

        int carry = 0;
        int va = 0;
        int vb = 0;
        // store the result
        StringBuilder sb = new StringBuilder();

        for (int i = l, j = b.length() -1 ; i > -1; i--, j--) {
            va =  Character.getNumericValue(a.charAt(i));
            if (j > -1) {
                vb = Character.getNumericValue(b.charAt(j));
            } else {
                vb = 0;
            }

            int sum = va + vb + carry;
            sb.insert(0, sum%2);
            // update carry
            carry = sum/2;
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
