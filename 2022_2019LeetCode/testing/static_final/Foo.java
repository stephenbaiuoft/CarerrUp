package testing.static_final;

public class Foo {
    public static void modify() {
        // cannot instantiate this class if private constructor
        //Constant a = new Constant();

        // cannot modify, this is not allowed!
        // Constant.VALUE1 = "my modified value";
    }

}
