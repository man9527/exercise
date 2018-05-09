package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = sort(strs[i]);
            if (result.get((s))==null) {
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                result.put(s, a);
            } else {
                result.get(s).add(strs[i]);
            }
        }

        List<List<String>> r = new ArrayList<>();
        for(Map.Entry e:result.entrySet()) {
            r.add((List<String>) e.getValue());
        }

        return r;
    }

    private String sort(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}
