package Prep;

import common.helpermethods.Helper;

import java.lang.reflect.Array;
import java.util.*;

public class L332_ReconstructItinerary {
    public L332_ReconstructItinerary() {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(create("JFK", "KUL"));
        tickets.add(create("JFK", "NRT"));
        tickets.add(create("NRT", "JFK"));
        // tickets.add(create("LHR", "SFO"));
        // tickets.add(create("MUC", "LHR"));

        List<String> rez = findItinerary(tickets);
        Helper.printList(rez);
    }

    private List<String> create(String s1, String s2) {
        List<String> l = new ArrayList<>();
        l.add(s1);
        l.add(s2);

        return l;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return new ArrayList<>();

        List<String> result = null;
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> t: tickets){
            if (!map.containsKey(t.get(0))) {
                map.put(t.get(0), new ArrayList<>());
            }
            // it is a pair and we put insert to
            map.get(t.get(0)).add(t.get(1));
        }

        for (Map.Entry<String, List<String>> e: map.entrySet()) {
            // sort alphabetically
            Collections.sort(e.getValue());
        }

        result = dfs("JFK", new ArrayList<>(), map, tickets.size()+1  );

        return result;
    }

    private List<String> dfs(String city,
                     ArrayList<String> visited, HashMap<String, List<String>> map, int totCount) {
        List<String> result = null;
        visited.add(city);
        if (visited.size() == totCount) {
            result = new ArrayList<>(visited);
            return result;
        }

        List<String> connected = map.get(city);
        if (connected == null) {
            visited.remove(visited.size()-1);
            return null;
        }

        for (int index = 0; index < connected.size(); index++) {
            // remove
            String removed = connected.remove(index) ;
            result = dfs(removed, visited, map, totCount);
            // break early
            if (result!= null) {
                return result;
            }

            // add back
            connected.add(index, removed);
        }
        visited.remove(visited.size()-1);
        return null;
    }

}
