package build.graph.or.tree;

import common.helpermethods.Helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class L582_KillProcess_M {
    public L582_KillProcess_M() {
        List<Integer> pid = new LinkedList<>(Arrays.asList(1, 3, 10, 5));
        List<Integer> ppid = new LinkedList<>(Arrays.asList(3, 0, 5, 3));
        List<Integer> rez = killProcess(pid, ppid, 5);
        Helper.printList(rez);
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // construct map
        HashMap<Integer, LinkedList<Integer>> ppidMap = new HashMap<>();
        // key: parent node, val: child
        int parent = 0;
        int child = 0;
        for (int i = 0; i < ppid.size(); i++) {
            parent = ppid.get(i);
            child = pid.get(i);

            if (!ppidMap.containsKey( parent)) {
                ppidMap.put(parent, new LinkedList<>());
            }
            ppidMap.get(parent).add(child);
        }

        LinkedList<Integer> q = new LinkedList<>();
        List<Integer> rez = new LinkedList<>();

        // base case, kill pid does not exist
        if (!ppidMap.containsKey(kill)) return rez;
        if (pid.contains(kill)) {
            rez.add(kill);
            return rez;
        }


        q.add(kill);
        int nextKill = 0;
        while(!q.isEmpty()) {
            // add collection to q
            nextKill = q.poll();
            rez.add(nextKill);
            // could be a leaft too
            if (ppidMap.containsKey(nextKill)) {
                q.addAll(ppidMap.get(nextKill));
            }
        }

        return rez;
    }
}
