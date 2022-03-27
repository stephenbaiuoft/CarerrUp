package javamethods;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class CollectionConversion {
    public static void main(String[] args) {
        CollectionConversion c = new CollectionConversion();
        c.asListDemo();
    }

    public void asListDemo() {
        // This method acts as bridge between array-based and collection-based APIs,
        // in combination with Collection.toArray
        String[] strArray = new String[5];
        // Return a List<E>, which can be init by other data structures
        Arrays.asList(strArray).forEach(
                e -> System.out.println(e) // this prints out null
        );

        LinkedList<String> list = new LinkedList<>(Arrays.asList(strArray));

        LinkedList<String> list1 = new LinkedList<>(Arrays.asList(new String[]{"a", "b", "c"}));
        // this should fail as there's null
        // ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(strArray));

        // init array types (fixed)
        int[] input = new int[] {1,2,3};

        String[] arrayResult = null;
        // this method acts as bridge between array-based and collection-based APIs
        // Params:
        // a – the array into which the elements of the list are to be stored,
        // if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
        String[] tmp = list1.toArray(new String[list1.size()]);
        System.out.println(tmp.length);


        LinkedList<Integer> l  = new LinkedList<>();
        l.stream().mapToInt(i->i).toArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.forEach(
                x -> System.out.println(x)
        );
    }
}
