package ch02;

import leecode.MergeTwoSortedLists.*;

import java.util.List;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1==null) {
            return l2;
        }

        if (l2==null) {
            return l1;
        }

        ListNode head=null;
        ListNode current = null;
        int extra = 0;

        while(l1!=null || l2!=null || extra>0) {

            int v = (l1==null?0:l1.val);
            v+= (l2==null?0:l2.val);
            v+=extra;
            extra=0;

            if (v<=9) {
                ListNode vl = new ListNode(v);
                if (head==null) {
                    head = vl;
                } else {
                    current.next=vl;
                }
                current = vl;
            } else {
                ListNode vl = new ListNode(v%10);
                extra=1;

                if (head==null) {
                    head = vl;
                } else {
                    current.next=vl;
                }
                current = vl;
            }

            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }


        return head;
    }
}
