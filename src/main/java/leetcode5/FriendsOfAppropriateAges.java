package leetcode5;

import java.util.Arrays;
import java.util.Comparator;

public class FriendsOfAppropriateAges {

    public static void main(String[] args) {
        int[] ages = {98,60,24,89,84,51,61,96,108,87,68,29,14,11,13,50,13,104,57,8,57,111,92,87,9,59,65,116,56,39,55,11,21,105,57,36,48,93,20,94,35,68,64,41,37,11,50,47,8,9};
        // int[] ages = {57, 57, 57};
        //int[] ages = {20,30,100,110,120};
        System.out.println(new FriendsOfAppropriateAges().numFriendRequests(ages));
    }

    public int numFriendRequests(int[] ages) {

        int[] newAges = new int[121];
        int answer = 0;
        for (int i = 0; i < ages.length; i++) {
            newAges[ages[i]] = newAges[ages[i]] + 1;
        }

        for (int i = newAges.length-1; i>=1; i--) {
            for (int j = i-1; 0<=j ; j--) {
                if ( j > (0.5 * i + 7)) {
                    answer += newAges[i]*newAges[j];
                }
            }


            if (i>=15) {
                answer += newAges[i] * (newAges[i]-1);
            }
        }


        return answer;
    }

    public int numFriendRequests3(int[] ages) {
        if (ages==null || ages.length==0) {
            return 0;
        }
        Arrays.sort(ages);

        int lastAnswer = 0;
        int lastIndex = 0;
        int answer = 0;

        for (int i = ages.length-1; i>=0 ; i--) {
            int currentAnswer = lastAnswer==0?0:lastAnswer-1;

            for (int j = lastIndex==0?i-1:lastIndex; j>=0 ; j--) {
                if (i==j) continue;
                if ( !(ages[j]<= (0.5*ages[i]+7))) {
                    if (ages[i]==ages[j]) {
                        currentAnswer = currentAnswer+2;
                    } else {
                        currentAnswer++;
                    }
                } else {
                    lastIndex=j;
                    lastAnswer = currentAnswer;
                    break;
                }
            }

            answer += currentAnswer;
        }

        return answer;

    }

    public int numFriendRequests2(int[] ages) {
        if (ages==null || ages.length==0) {
            return 0;
        }
        Arrays.sort(ages);

        int answer = 0;

        for (int i = ages.length-1; i>=0 ; i--) {
            for (int j = i-1; j>=0 ; j--) {
                if ( !(ages[j]<= (0.5*ages[i]+7))) {
                    if (ages[i]==ages[j]) {
                        answer = answer+2;
                    } else {
                        answer++;
                    }

                } else {
                    break;
                }
            }
        }

        return answer;

    }

    public boolean isNotEligible(int b, int a) {
        return (b<=0.5*a+7);
    }

}
