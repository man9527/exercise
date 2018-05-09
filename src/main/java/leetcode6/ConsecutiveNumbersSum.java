package leetcode6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ConsecutiveNumbersSum {

    public static void main(String[] args) {
        //System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(65442209));
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
    }

    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for(int i = 1, n = N - 1; n >= 0; n -= ++i)
            if ((n % i) == 0) ans++;
        return ans;
    }

    public int consecutiveNumbersSum2(int N) {
        int answer = 0;
        int fast = 0;
        int slow = 0;
        int runningSum = 0;

        while(slow<=N) {
            while(runningSum<N) {
                fast++;
                runningSum+=fast;
            }

            while(runningSum>N && slow<fast) {
                slow++;
                runningSum-=slow;
            }

            if (runningSum==N) {
                answer++;
            }

            fast++;
            runningSum+=fast;
        }

        return answer;
    }



    public int consecutiveNumbersSum3(int N) {

        HashSet<Long> s = new HashSet<>();

        long runningSum = 0;
        int answer = 0;

        for (int i = 0; i <= N; i++) {
            runningSum = runningSum + i;
            s.add(runningSum);

            if (runningSum>=N && s.contains(runningSum - N)) {
                answer++;
            }
        }

        return answer;

    }

}
