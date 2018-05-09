package leetcode4;

import java.util.Arrays;
import java.util.HashSet;

public class LinkedListComponents {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);

        n2.next=n3;
        n3.next=n1;
        n1.next=n4;
        n4.next=n5;

        int[] G = {3,4,0,2,1};

        System.out.println(new LinkedListComponents().numComponents(n1, G));
    }

    public int numComponents(ListNode head, int[] G) {
        if (head==null || G==null || G.length==0) {
            return 0;
        }

        HashSet<Integer> gnodes = new HashSet<>();

        for (int i = 0; i < G.length; i++) {
            gnodes.add(G[i]);
        }

        int answer = 0;
        boolean inprogress = false;
        while(head!=null) {
            int v1 = head.val;

            if (gnodes.contains(v1)) {
                inprogress = true;
                gnodes.remove(v1);
            } else if (inprogress) {
                inprogress = false;
                answer++;
            }

            gnodes.remove(v1);
            head = head.next;
        }

        if (inprogress) {
            answer++;
        }
        return answer;

    }

    public int numComponents3(ListNode head, int[] G) {

        if (head==null || G==null || G.length==0) {
            return 0;
        }

        HashSet<String> connect = new HashSet<>();

        while(head.next!=null) {
            int v1 = head.val;
            int v2 = head.next.val;

            connect.add(v1+"-"+v2);
            connect.add(v2+"-"+v1);

            head = head.next;
        }

        int answer = 0;
        boolean inprogress = false;
        for (int i = 0; i < G.length-1; i++) {
            String check = G[i]+ "-" + G[i+1];
            if (connect.contains(check)) {
                inprogress = true;
            } else if (inprogress) {
                inprogress = false;
                answer++;
            } else {
                answer++;
            }
        }

        return answer;
    }

    public int numComponents2(ListNode head, int[] G) {

        if (head==null || G==null || G.length==0) {
            return 0;
        }

        boolean[] cg = new boolean[10000];

        for (int i = 0; i < G.length; i++) {
            cg[G[i]]=true;
        }

        int answer = 0;

        while(head.next!=null) {
            int v1 = head.val;
            int v2 = head.next.val;

            if (cg[v1] && cg[v2]) {
                answer++;
                cg[v1] = false;
                cg[v2] = false;
            }

            head = head.next;
        }

        for (int i = 0; i < G.length; i++) {
            if (cg[G[i]]) {
                answer++;
            }
        }

        return answer;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
