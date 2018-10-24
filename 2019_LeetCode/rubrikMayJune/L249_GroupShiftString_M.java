package rubrikMayJune;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L249_GroupShiftString_M {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list = new LinkedList<>();
        if (strings == null || strings.length < 1) return list;

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strings) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(0);
            char base = s.charAt(0);
            for(int i = 1; i < s.length(); i++) {
                int dif = (s.charAt(i) - base + 26) %26;

                //需要 '，' 因为数字的话 1+2 vs 12 是一样的
                buffer.append(dif);
                buffer.append(',');
            }

            if (map.containsKey(buffer.toString())) {
                map.get(buffer.toString()).add(s);
            } else {
                List<String> l = new LinkedList<>();
                l.add(s);
                map.put(buffer.toString(), l);
            }
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}
