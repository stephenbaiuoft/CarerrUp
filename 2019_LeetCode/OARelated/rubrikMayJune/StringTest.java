package OARelated.rubrikMayJune;

public class StringTest {

    public StringTest() {
        String s1 = "abc";
        String s2 = s1;
        String s3 = "abc";

        boolean a = s1 == s3;
        boolean b = s2 == s1;
        boolean c = s3 == "abc";

        boolean d = s1.equals(s3);
        boolean e = s2.equals(s1);
        boolean f = s1.equals("abc");


        System.out.println("program finished");
    }
}
