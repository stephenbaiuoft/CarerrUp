package GA;


import java.util.LinkedList;
import java.util.List;

public class Main_GA {
    public static void main(String[] args) {
        List<List<Integer>> l = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        tmp.add(4);
        tmp.add(5);
        tmp.add(6);
        List<Integer> tmp1 = new LinkedList<>();
        tmp1.add(-100);
        tmp1.add(200);
        tmp1.add(300);
        List<Integer> tmp2 = new LinkedList<>();
        tmp2.add(1000);
        tmp2.add(-2000);
        tmp2.add(10);

        l.add(tmp);
        l.add(tmp1);
        l.add(tmp2);

        Q2 p = new Q2();
        p.MinSliceWeight(l);
    }
}