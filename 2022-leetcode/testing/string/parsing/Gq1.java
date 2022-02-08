package testing.string.parsing;

import java.util.*;

public class Gq1 {
    public Gq1() {

        List<String> list = genData();

        processEmails(list);
    }

    public List<List<String>> processEmails(List<String> list) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> rez = new LinkedList<>();

        for(String s: list) {
            map.getOrDefault(s, new LinkedList<>());

            String processed = processEmail(s);
            if (map.containsKey(processed)) {
                map.get(processed).add(s);
            } else {
                List<String> l = new LinkedList<>();
                l.add(s);
                map.put(processed, l);
            }
        }

        for (Map.Entry<String, List<String>> e: map.entrySet()) {
            rez.add(e.getValue());
        }

        return rez;
    }

    private String processEmail(String s) {
        if (s == null) return "";
        String[] components = s.split("@");
        if (components.length != 2) return "";

        String first = components[0];
        String second = components[1];

        first = first.replaceAll("(.)\\.", "$1");
        first = first.replaceAll("\\+.*", "");
        return first + "@" + second;
    }

    private List<String> genData() {
        List<String> data = new LinkedList<>(Arrays.asList(
                "a.b@example.com",
                "...a.b@example.com",
                "...a.b.c++++a++++++b++++++@hotmail.com"));

        return data;
    }
}
