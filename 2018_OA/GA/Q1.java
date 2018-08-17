package GA;

import java.util.LinkedList;
import java.util.List;

public class Q1 {
    public Q1() {
        String t = "abc";
        char[] buf = t.toCharArray();
        int l = buf.length;
        char c = 'a';
        Character.toUpperCase(c);
        List<Integer> ll = new LinkedList<>();
        for(int i = 0; i <10; i++) {

        }
        List<List<Integer>> Matrix = new LinkedList<>();
        int v = Matrix.get(0).get(0);

    }

    static String pressAForCapsLock(String message) {
        // base case
        if (message == null || message.length() < 1) return message;

        boolean toggle = false;
        StringBuilder sb = new StringBuilder();
        char[] buf = message.toCharArray();
        for (int i = 0; i < message.length(); i++) {
            if (buf[i] == 'A') {
                toggle = !toggle;
            } else {
                // cap
                if (toggle) {
                    sb.append(Character.toUpperCase(buf[i]));
                } else {
                    sb.append(buf[i]);
                }

            }
        }

        return sb.toString();
    }
}
