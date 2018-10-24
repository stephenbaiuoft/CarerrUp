package ByMonth.august.June;

import java.lang.reflect.Parameter;

public class GoogleSample {
    public GoogleSample() {
        String rez = solution("r",  1);
    }

    public String solution(String S, int K) {
        if (S.getClass() != String.class) {

        }
        int k = K;
        if ( S == null || S.length() < 1 || S.length() < k) return S;
        // write your code in Java SE 8
        StringBuilder buffer = new StringBuilder();
        StringBuilder rez = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if (S.charAt(i) != '-'){
                char c = S.charAt(i);
                buffer.append(Character.toUpperCase(c));
            }
        }

        int start = 0;
        int len = buffer.length();
        if (len/k != 0) {
            start = buffer.length() - (len/k)*k;
        }

        int count = 0;
        int tmp = buffer.length();
        while(start < tmp){
            if (start > 0){
                buffer.insert(start, "-");
                count ++;
            }

            start = start + count + k;
            // refresh buffer length
            tmp = buffer.length();
        }

        return buffer.toString();

    }
}
