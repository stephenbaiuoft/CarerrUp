package Amazon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 program.insert(10);
 program.remove(10);
 program.insert(10);
 //program.insert(30);
 //program.remove(20);
 System.out.println (program.getRandom());
 *
 */

public class L381_InsertDelete_H {
    // Think of two arrays nows


        private ArrayList<Integer> nums;
        private HashMap<Integer, ArrayList<Integer>> hashMap;
        private Random rand = new Random();

        public L381_InsertDelete_H() {
            nums = new ArrayList<>();
            hashMap = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            // add to the table Regardless

            if (hashMap.containsKey(val) ){
                // update hashMapCount

                nums.add(val);

                ArrayList<Integer> ary = hashMap.get(val);
                // add to ary to keep track of the index in nums
                ary.add(nums.size()-1);
                hashMap.put(val, ary);

                return false;
            }
            // add: appending to the end of the list
            else {

                nums.add(val);

                ArrayList<Integer> ary = new ArrayList<>();
                ary.add(nums.size()-1);
                hashMap.put(val, ary);
                return  true;
            }


        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!hashMap.containsKey(val)) return false;

            // Get ary based on values
            ArrayList<Integer> aryRemove = hashMap.get(val);
            int lastValue = nums.get(nums.size() -1 );
            ArrayList<Integer> aryAdd = hashMap.get(lastValue);
            int numIndex = aryRemove.get(aryRemove.size() -1);
            int numLastIndex = nums.size() - 1;

            // numIndex is NOT the last element in nums
            if (numLastIndex > numIndex){

                nums.set(numIndex, lastValue);
                aryAdd.remove (Integer.valueOf(numLastIndex));
                aryAdd.add(numIndex);

            }

            if (aryRemove.size() == 1){
                hashMap.remove(val);
            } else{
                aryRemove.remove(aryRemove.size() - 1);
            }

            // delete from nums
            nums.remove(nums.size() - 1);



            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()) );
        }


}
