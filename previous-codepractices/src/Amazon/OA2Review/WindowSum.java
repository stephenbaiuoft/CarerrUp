package Amazon.OA2Review;
import java.util.*;

public class WindowSum {
    // prints list
    public void showList(List<Integer> A) {
        int i = 0;

        while(i < A.size()) {
            System.out.print(A.get(i) + ",");
            i++;
        }
        System.out.println("Finished Printing");
    }

    public void run(){
        Random r = new Random();

        List<Integer> input = new LinkedList<>();
        int count = 6;
        for(int i = 0; i < count; i++) {
            // adding random integer
            int tmp = r.nextInt(100);
            System.out.println("adding integer: " + tmp);
            input.add(tmp);
        }
        int[] result = new int[20];

        String test = "";
        showList( GetSum(input, 5) );
        System.out.println("\n\n\n*******************\n\n\n");
        showList( GetSumSol(input, 5));

    }

    public List<Integer> GetSum(List<Integer> A, int k) {
        List<Integer> result = new LinkedList<>();

        if(A == null || A.size() == 0 || k <= 0 ) {
            return result;
        }

        int sum = 0;
        for (int i = 0; i < k; i ++){
            // compute the first k elements
            sum += A.get(i);
        }
        result.add(sum);

        //  recompute this way
        for (int i = 1; i <= A.size() - k; i ++) {
            sum -= A.get(i-1);
            sum += A.get(i + k - 1);
            result.add(sum);
        }

        //Queue<Integer>  deque = new ArrayDeque<>();

        return result;


    }

    public List<Integer> GetSumSol(List<Integer> A, int k) {
        ArrayList<Integer> result  = new ArrayList<>();
        if (A == null || A.size() == 0 || k <= 0) return result;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count++;
            if (count >= k) {
                int sum = 0;
                for (int j = i; j >= i - k + 1; j--) {
                    sum += A.get(j);
                }
                result.add(sum);
            }
        }
        return result;
    }
}
