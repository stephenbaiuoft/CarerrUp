package tesla;

public class TeslaSolution {
    public static void main(String[] args)
    {
        PriorityExpiryCache c = new PriorityExpiryCache(5);
        // String key, Object value, int priority, long expire
//        c.Set("A", 1, 5, 100);
//        c.Set("B", 2, 15, 3);
//        c.Set("C", 3, 5, 10);
//        c.Set("D", 4, 1, 15);
//        c.Set("E", 5, 5, 150);

        c.Set("A", 1, 5, 100);
        c.Set("B", 2, 15, 10);
        c.Set("C", 3, 5, 7);
        c.Set("D", 4, 1, 15);
        c.Set("E", 5, 5, 150);

        c.Get("C");

        try {
            // Current time = 0
            c.SetMaxItems(5);
            // Keys in C = ["A", "B", "C", "D", "E"]
            // space for 5 keys, all 5 items are included
            c.showInternalState();

            // Sleep for 5 secs
            java.lang.Thread.sleep(5000);
            // Current time = 5
            c.SetMaxItems(4);
            // Keys in C = ["A", "C", "D", "E"]
            // "B" is removed because it is expired.  e3 < e5
            c.showInternalState();

            c.SetMaxItems(3);
            // Keys in C = ["A", "C", "E"]
            // "D" is removed because it the lowest priority
            // D's expire time is irrelevant.
            c.showInternalState();

            c.SetMaxItems(2);
            // Keys in C = ["C", "E"]
            // "A" is removed because it is least recently used."
            // A's expire time is irrelevant.
            c.showInternalState();

            c.SetMaxItems(1);
            // Keys in C = ["C"]
            // "E" is removed because C is more recently used (due to the Get("C") event).
            c.showInternalState();

            return;
        } catch (Exception ex) {
            System.out.println("Encountered an exception: " + ex);
        }
    }
}
