package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L636_ExclusiveTimeFunction_M {
    public void test() {
        List <String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int[] rez = exclusiveTime(2, logs);

    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime;
            // assign prevTime as the last timestamp
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else {
                res[stack.pop()]++;
                // update prevTime if the next task is end, then it has to
                // next iteration: Integer.parseInt(parts[2]) - prevTime!
                // and it will enter else{} and res[stack.pop()] ++?
                prevTime++;
            }
        }
        return res;
    }
}
