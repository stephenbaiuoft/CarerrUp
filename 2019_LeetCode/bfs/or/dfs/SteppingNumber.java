package bfs.or.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SteppingNumber {
    public SteppingNumber() {

        stepnum(10, 20);
    }

    public void findRoutes(ArrayList<Integer> ans, int a, int b, int start, int curr){

        if(curr <= b){
            if(curr >= a){
                // 从最小的开始！！！ 就可以很简单！
                ans.add(curr);
            }
            if(start != 0){
                findRoutes(ans, a, b, start - 1, curr * 10 + start - 1);
            }
            if(start != 9){
                findRoutes(ans, a, b, start + 1, curr * 10 + start + 1);
            }
        }
    }

    public int[] stepnum(int a, int b) {

        ArrayList<Integer> ans = new ArrayList<>();
        if(a <= 0 && b >= 0){
            ans.add(0);
        }

        for(int i = 1; i <= 9; i++){
            // 从 1xxxxxx 这一层
            // 到 9xxxxxx 这一层 每一个都去过滤一次
            findRoutes(ans, a, b, i, i);
        }

        int[] mdzz = new int[ans.size()];
        for (int zz = 0; zz < mdzz.length; zz++) {
            mdzz[zz] = ans.get(zz);
        }

        Arrays.sort(mdzz);
        return mdzz;
    }

}
