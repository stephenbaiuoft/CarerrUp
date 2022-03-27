package javamethods;

import java.util.LinkedList;
import java.util.List;

public class StringMethods {
    public static void main(String[] args) {
        StringMethods p = new StringMethods();
        // p.sbDemo();
        p.stringJoinDemo();
        p.stringcomp();
    }

    public void stringcomp() {
        String a = "abc";
        String b = "abc";
        System.out.println("a == b? --> false!!!! " +  a==b);

        System.out.println("a.equals(b)? " + a.equals(b));


    }
    public void stringJoinDemo() {
        // int[] nums = new int[]{1,2,3}; -> does not work
        List<String> list = new LinkedList<>();
        // Any iterable!
        String answer = String.join("", list);
        System.out.println(answer);
    }


    public void sbDemo() {
        // sb for non-synchronous
        // add anything with insert to the front
        StringBuilder sb = new StringBuilder();
        sb.insert(0, 123);
        sb.insert(0, 'c');
        sb.insert(0, "abcd");
        sb.insert(0, 2.0);
        // 2.0abcdc123
        System.out.println(sb);
        // or append to the end
        // 2.0abcdc123added to the rightmost
        sb.append("added to the rightmost");
        System.out.println(sb);

        // no good way to remove any methods
    }
}
