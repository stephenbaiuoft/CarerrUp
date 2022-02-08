package Amazon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class L380_InsertDelete_M {

    /** Initialize your data structure here. */
    class RandomizedSet {
        private ArrayList<Integer> nums;
        private HashMap<Integer, Integer> hashMap;
        private Random rand = new Random();

        public RandomizedSet() {
            nums = new ArrayList<>();
            hashMap = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (hashMap.containsKey(val) ){
                return false;
            }
            // add: appending to the end of the list
            nums.add(val);
            hashMap.put(val, nums.size() - 1);
            return  true;

        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!hashMap.containsKey(val)) return false;

            int index = hashMap.get(val);

            if ((nums.size() - 1) > index){
                int last = nums.get(nums.size() -1 );
                nums.set(index, last);
                hashMap.put(index, last);
            }
            nums.remove(nums.size() - 1);
            hashMap.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()) );
        }
    }





}





