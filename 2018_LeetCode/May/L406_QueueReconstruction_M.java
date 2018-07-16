package May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class L406_QueueReconstruction_M {


    public int[][] reconstructQueue(int[][] people) {
        // sort in the highest order first
        // key: the relative position is always consistent
        // so you should insert along with the index
        // note Java allows the array to shift whenever a new element
        // is inserted

        // 0th: height     |   1st: rank
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // first sort by descending order(highest height)
                // if same height, then ascedning order by rank
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };

        // sort the people array
        Arrays.sort(people, c);

        // create an arraylist for insertion
        ArrayList<int[]> l = new ArrayList<>(people.length);

        // 因为relative order是constant 所以可以consistent insert 就可以了

        for (int[] person: people) {
            // 按照 rank asending order来加入列表
            l.add(person[1], person);
        }

        // return the int[][] format
        return l.toArray(new int[people.length][2]);
    }
}
