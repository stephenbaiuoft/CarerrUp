package testing.string.testing;

import common.helpermethods.Helper;

import java.util.Arrays;
import java.util.LinkedList;

public class stringTest {
    public static void split() {
        String a = "1.2.3";
        String b = "1..2..3...";
        String[] ar = a.split("\\.");
        String[] br = b.split("\\.");

        String c = "1...2..3.";
        String[] cr = c.split("\\.");

        String t = "boo:and:foo";
        String[] tr = t.split(":");
        tr  = t.split("o");

        String t1 = "oobbooo:and:foo   ";
        String[] tr2 = t1.split("o");

        Helper.printList(new LinkedList<>(
                Arrays.asList(a.split("\\."))));

        Helper.printList(new LinkedList<>(
                Arrays.asList(b.split("\\."))));
    }
}
