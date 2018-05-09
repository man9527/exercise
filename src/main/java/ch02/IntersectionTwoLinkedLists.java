package ch02;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(9);
        ListNode a6 = new ListNode(11);
        ListNode a7 = new ListNode(13);

        a1.next = a2; a2.next = a3; a3.next=a4; a4.next=a5; a5.next=a6; a6.next = a7;

        ListNode b1 = new ListNode(2);
        //ListNode b2 = new ListNode(5);



        System.out.println( getIntersectionNode(a1, b1));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB ==null) {
            return null;
        }

        int countHeadA = 0, countHeadB = 0;

        for(ListNode ln=headA; ln!=null; ln=ln.next) {
            countHeadA++;    
        }

        for(ListNode ln=headB; ln!=null; ln=ln.next) {
            countHeadB++;
        }
        
        if (countHeadA>countHeadB) {
            for (int i = 0; i < countHeadA-countHeadB; i++) {
                headA = headA.next;
            }    
        } else {
            for (int i = 0; i < countHeadB-countHeadA; i++) {
                headB = headB.next;
            }
        }
        
        for(ListNode ha=headA, hb = headB; ha!=null; ha=ha.next, hb=hb.next) {
            if (ha.val==hb.val) {
                return ha;
            }
        }

        return null;

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


