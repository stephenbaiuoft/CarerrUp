package Microsoft;

import java.util.*;

/**
 *
 Given an absolute path for a file (Unix-style),
 simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.

 */
public class L71_simplifyPath_M {

    public void test() {
        String str = "/a/./b/../../c/";

        simplifyPath(str);

    }
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {


            Queue<Integer> q = new PriorityQueue<>();

            return "/";
        }

        Stack<String> stack = new Stack<>();
        // good usage of filling HashSet!
        HashSet<String> set = new HashSet<>(Arrays.asList("..", ".", ""));

        String[] pathSet = path.split("/");
        for (String element : pathSet) {
            //
            if ( element.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            // element to add to stack
            else if (!set.contains(element)) {
                stack.push(element);
            }
        }

        String res = "";
        for (String e : stack) {
            // first element first, and keep adding up
            res = "/" + e + res;
        }

        return res.isEmpty() ? "/": res;

    }
}
