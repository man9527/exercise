package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 */
public class MinimumIndexSumTwoLists {

    public static void main(String[] args) {
        String[] s1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] s2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
    }
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        ArrayList<String> answer = new ArrayList<>();
        int sum=Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) && map.get(list2[i])+i <=sum) {
                if (map.get(list2[i])+i <sum) {
                    answer.clear();
                }
                answer.add(list2[i]);
                sum = map.get(list2[i])+i;
            }
        }
        String[] r = new String[answer.size()];
        return answer.toArray(r);
    }
}
