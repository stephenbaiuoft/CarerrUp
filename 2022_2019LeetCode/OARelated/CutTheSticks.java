package OARelated;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CutTheSticks {
    public CutTheSticks() {
        int[] arr = new int[] {
                5, 4, 4, 2, 2, 8
        };

        int[] rez = cutTheSticks(arr);
        System.out.println(rez);
    }

    public int[] cutTheSticks(int[] arr) {
        if (arr == null || arr.length < 1) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> (a - b));
        for (int num: arr)  {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] rez = new int[map.size()];
        int n = arr.length;
        int s = map.size();
        for (int i = 0; i < s ; i++) {
            rez[i] = n;
            Map.Entry<Integer, Integer> e = map.pollFirstEntry();
            n -= e.getValue();
        }

        return rez;
    }
}

