package March;

import java.util.HashMap;

public class L294_FlipGameII_M {
    public L294_FlipGameII_M() {
        String s = "+++++";
        boolean r =canWin(s);
        System.out.print(r);
    }

    public HashMap<String, Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        // variables
        StringBuilder buffer = new StringBuilder(s);

        return helper(buffer);
    }

    public boolean helper(StringBuilder buffer) {
        // check if exists
        if(map.containsKey(buffer.toString())) {
            return map.get(buffer.toString());
        };

        for(int i = 0; i < buffer.length() - 1; i++) {
            // find occurences of "++"
            if (buffer.charAt(i) == '+' && buffer.charAt(i+1) == '+') {
                buffer.replace(i, i+2,"--");
                // if after modification, can't win
                if(!helper(buffer)) {
                    buffer.replace(i, i+2, "++");
                    // u know u can win
                    map.put(buffer.toString(), true);
                    // restore here as well
                    return true;
                }
                // backtrack back and do something else
                buffer.replace(i, i+2, "++");
            }
        }

        map.put(buffer.toString(), false);
        // not found --> return false
        return false;
    }
}
