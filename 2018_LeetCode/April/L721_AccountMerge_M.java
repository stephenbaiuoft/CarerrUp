package April;

import java.util.*;

public class L721_AccountMerge_M {
    public L721_AccountMerge_M() {
        List<List<String>> input = new LinkedList<>();
        List<String> a = new LinkedList<>();
        //"John", "johnsmith@mail.com", "john00@mail.com"
        a.add("John");
        a.add("johnsmith@mail.com");
        a.add("john00@mail.com");

        // ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
        List<String> b = new LinkedList<>();
        b.add("John");
        b.add("johnnybravo@mail.com");

        List<String> c = new LinkedList<>();
        c.add("John");
        c.add("johnsmith@mail.com");
        c.add("john_newyork@mail.com");

        List<String> d = new LinkedList<>();
        d.add("Mary");
        d.add("mary@mail.com");

        input.add(a);
        input.add(b);
        input.add(c);
        input.add(d);

        List<List<String>> rez = accountsMerge(input);
    }

    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }

}
