package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("aabb"));
    }
    public List<Integer> partitionLabels(String S) {

        List<String> result = partitionLabelsInner(S);

        List<Integer> rr = result.stream().map(String::length).collect(toList());

        return rr;
    }

    public ArrayList<String> partitionLabelsInner(String S) {

        if (S.length()==0) {
            return new ArrayList<>();
        }

        if (S.length()==1) {
            ArrayList<String> ll = new ArrayList<>();
            ll.add(S);
            return ll;
        }

        int mid = S.length()/2;
        ArrayList<String> leftSubResult = partitionLabelsInner(S.substring(0, mid));
        ArrayList<String> rightSubResult = partitionLabelsInner(S.substring(mid));

        for (String leftRightMost:leftSubResult) {
            for (int i = 0; i < leftRightMost.length(); i++) {
                for(String rightLeftMost:rightSubResult) {
                    if (rightLeftMost.indexOf(leftRightMost.charAt(i)) > -1) {
                        leftSubResult.remove(leftSubResult.size() - 1);
                        rightSubResult.add(0, leftRightMost + rightLeftMost);
                        break;
                    }
                }
            }
        }

        leftSubResult.addAll(rightSubResult);

        return leftSubResult;
   }
}
