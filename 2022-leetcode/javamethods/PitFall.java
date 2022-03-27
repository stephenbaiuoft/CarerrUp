package javamethods;

import java.util.*;

public class PitFall {
    // Use Iterator to remove elements while iterating through the map!!!!!!!
    public static List<List<Integer>> compute(List<List<Integer>> input) {
        LinkedList<List<Integer>> answer= new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // build the map
        for (List<Integer> task: input) {
            int id = task.get(0);
            if (map.get(id) == null) {
                map.put(id, new HashSet<>());
            }
            // add rest of dependencies
            for (int i = 1; i < task.size(); i++) {
                HashSet<Integer> set = map.get(id);
                set.add(task.get(i));
            }
        }


        LinkedList<Integer> prev = new LinkedList<>();
        // track of what can be removed per iteration
        LinkedList<Integer> cur = new LinkedList<>();

        while(!map.isEmpty()) {
            // iterate through map
            Iterator ki = map.keySet().iterator();
            while(ki.hasNext()) {
                int key = (Integer) ki.next();
                // remove anything that's in the prev
                HashSet<Integer> dep = map.get(key);
                if (prev.isEmpty()) {
                    if (dep.size() ==0){
                        // remove the entry
                        ki.remove();
                        cur.add(key);
                    }
                } else {
                    // prev contains dependencies one can remove
                    // try all possiblilities
                    for (int d: prev) {
                        // check this may throw ex?
                        dep.remove(d);
                    }
                    // then check if we add this task
                    if (dep.size() == 0) {
                        // remove the entry
                        ki.remove();

                        cur.add(key);
                    }
                }
            }
            // prev may contain values
            answer.add(new LinkedList<>(cur));
            prev = cur;
            cur = new LinkedList<>();
        }
        return answer;
    }

    public static void main(String[] args) {
        LinkedList<List<Integer>> input = new LinkedList<>();
        input.add(Arrays.asList(0));
        input.add(Arrays.asList(1, 0, 2, 3));
        input.add(Arrays.asList(2, 0, 3));
        input.add(Arrays.asList(3, 0));
        input.add(Arrays.asList(4));
        input.add(Arrays.asList(5, 0, 1, 2, 3, 4));
        input.add(Arrays.asList(6, 5));


        List<List<Integer>> answer = compute(input);
        for (int i = 0; i < answer.size(); i++) {
            List<Integer> batch = answer.get(i);
            for (int j = 0; j < batch.size(); j++) {
                System.out.print(batch.get(j) + ", ");
            }

            System.out.println("\n");
        }

    }
}
