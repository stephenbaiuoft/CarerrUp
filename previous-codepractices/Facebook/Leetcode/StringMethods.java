package Leetcode;

public class StringMethods {
    // testing.string builder
    public void test_v2() {
        StringBuilder sb = new StringBuilder();
        // int i,
        // char c,
        // String s,
        // Double d,
        // char[] charAry
        // String s

        sb.append("whatever you want");

        // convert back to rez!!!
        String rez = sb.toString();

    }

    public void test() {
        String s = "";

        int index = 0 ;
        s.charAt(index);
        s.contains("test testing.string");


        int beginIndex = 0;
        int endIndex = 10;
        s.substring(beginIndex, endIndex);
        s.substring(beginIndex);

        s.equals("another testing.string in terms of content");

        // change String Cases
        s.toLowerCase();
        s.toUpperCase();

        int tooffset = 0;
        s.startsWith("prefix content", tooffset);

        // compare this to s.indexOf!!!
        int i = s.indexOf("prefix content", tooffset);

    }
}
