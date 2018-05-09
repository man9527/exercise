package leetcode2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandom {

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.remove(2);
        rs.insert(2);
        rs.insert(1);

        System.out.println(rs.size);

        rs.remove(2);
        System.out.println(rs.size);

        rs.remove(2);
        System.out.println(rs.size);

    }

    static class RandomizedSet {

        ArrayList<Integer> array = new ArrayList<>();
        int size = 0;
        HashMap<Integer, Integer> location = new HashMap<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (location.get(val)==null) {
                array.add(size, val);
                location.put(val, size);
                size += 1;
                return true;
            } else {
                return false;
            }

        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (location.get(val)!=null) {
                int idx = location.get(val);
                int temp = array.get(size-1);
                array.set(idx, temp);
                location.put(temp, idx);
                location.remove(val);
                size -= 1;
                return true;
            } else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random r = new Random();
            int Result = r.nextInt(size);
            return array.get(Result);
        }
    }

}
