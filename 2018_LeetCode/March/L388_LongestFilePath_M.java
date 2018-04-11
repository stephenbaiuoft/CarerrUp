package March;

import java.util.ArrayDeque;
import java.util.Deque;

public class L388_LongestFilePath_M {
    public void testSpace() {
        String t = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String[]ary  = t.split("\n");
        for(String s:ary) {
            int tmp = s.lastIndexOf("\t");
            System.out.print(tmp);
        }
        String a = "\t\t";
        int lt = a.length();
        System.out.print(lt);

    }


    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;

        // init variables
        // to keep track of each level depth
        Deque<Integer> stack =new ArrayDeque<>();
        // default value
        stack.push(0);
        String[] components = input.split("\n");
        int maxLength = 0;

        for(String dir: components) {
            // root will be -1 (not found) + 1 ==> 0
            // others will be \t\tabc ==> 1 +1 ==>2
            int depth = dir.lastIndexOf("\t") + 1;
            // let root be level 1 --> this offset will simply things
            int level = depth + 1;
            // backtrack --> make sure: initially level =1, and stack.size() == 1
            while(level < stack.size()) {
                stack.poll();
            }
            // level: # of \t for this dir
            // +1: add the default "/" to the file system.
            int curLength = stack.peek() + dir.length() - depth + 1;
            // we know it's a file
            if (dir.contains(".")) {
                // take out the offset 1
                maxLength = Math.max(maxLength, curLength - 1);
            }

            stack.push(curLength);
        }

        return maxLength;
    }
}
