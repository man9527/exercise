package ch02;

import leecode.MergeTwoSortedLists.*;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        fast = fast.next;
        if (fast!=null) {
            fast = fast.next;
        } else {
            return false;
        }
        slow = slow.next;

        while(fast!=null && slow!=null) {
            if (fast==slow) {
                return true;
            }

            fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
            } else {
                return false;
            }
            slow = slow.next;
        }

        return false;
    }
}
