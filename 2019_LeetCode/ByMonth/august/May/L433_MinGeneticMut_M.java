package ByMonth.august.May;

import java.util.HashSet;
import java.util.LinkedList;

public class L433_MinGeneticMut_M {
    public L433_MinGeneticMut_M() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = new String[] {"AACCGGTA"};

        int c = minMutation(start, end, bank);
    }

    public int minMutation(String start, String end, String[] bank) {
        // bfs solution to check # of steps to convert from start to end
        HashSet<String> bankSet = new HashSet<>();
        for(String s: bank) {
            bankSet.add(s);
        }
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        char[] charSet = new char[]{
                'A', 'C', 'G', 'T'
        };

        // bfs, we need levelCount
        int rezCount= 0;
        int levelCount = 0;
        String cur = null;
        char[] curAry = null;
        queue.offer(start);

        while(!queue.isEmpty()) {
            levelCount = queue.size();
            while(levelCount > 0) {
                levelCount --;
                cur = queue.poll();

                if(cur.equals(end)) {
                    return rezCount;
                }

                curAry = cur.toCharArray();
                for(int i = 0; i < cur.length(); i++) {
                    char old = curAry[i];
                    for(char c: charSet) {
                        if (c != old ) {
                            curAry[i] = c;
                            String tmp = new String(curAry);
                            if(!visited.contains(tmp) && bankSet.contains(tmp)) {
                                visited.add(tmp);
                                queue.add(tmp);
                            }
                        }
                    }
                    // restore
                    curAry[i] = old;
                }
            }

            rezCount++;
        }

        // cannot be reached
        return -1;
    }
}
