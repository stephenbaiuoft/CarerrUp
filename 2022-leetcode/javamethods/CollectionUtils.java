package javamethods;

import java.util.*;
public class CollectionUtils {

    // Collection does binary search!!!
    // https://www.geeksforgeeks.org/collections-binarysearch-java-examples/
    public void demoBinarySearch() {
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);

        // 10 is present at index 3.
        // Note the list or the collection MUST BE SORTED
        int index = Collections.binarySearch(al, 10);
        System.out.println(index);

        // 13 is not present. 13 would have been inserted
        // at position 4. So the function returns (-4-1)
        // which is -5.
        // If not exist, will return (-index - 1)
        index = Collections.binarySearch(al, 13);

        System.out.println(index);

        // So to get the actual index to insert you'd do
        // -(-index-1)-1 = index
        System.out.println(-index-1);

    }

}
