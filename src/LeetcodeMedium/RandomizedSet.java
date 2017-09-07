package LeetcodeMedium;

import java.util.*;
/**
 * Created by stephen on 7/13/17.
 */
// L380
public class RandomizedSet {

    /** Initialize your data structure here. */
    // key is index; value is the user val
    private HashMap<Integer, Integer> kValue;
    private HashMap<Integer, Integer> vKey;
    private int index;
    private Random rand;

    public RandomizedSet() {
        kValue = new HashMap<>();
        vKey =  new HashMap<>();
        index = 0;
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!vKey.containsKey(val)){
            vKey.put( val, index);
            kValue.put(index, val);
            index++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(vKey.containsKey(val)){
            int keyIndex = vKey.remove(val);
            kValue.remove(keyIndex);
            return true;
        }
        return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIndex = rand.nextInt(index);
        while(!kValue.containsKey(randIndex)){
            randIndex = rand.nextInt(index);
        }
        return kValue.get(randIndex);
    }

}
