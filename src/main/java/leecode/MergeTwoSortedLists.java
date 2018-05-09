package leecode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {

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

        ListNode r = new MergeTwoSortedLists().mergeTwoLists(a1, b1);
        System.out.println(r);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null) {
            return null;
        }

        if (l1==null) {
            return l2;
        }

        if (l2==null) {
            return l1;
        }

        ListNode head = null;
        ListNode step = null;

        while (l1!=null && l2!=null) {
            if(l1.val<=l2.val) {
                if (head==null) {
                    head=l1;
                    step=head;
                } else {
                    step.next=l1;
                    step=step.next;
                }

                l1 = l1.next;
            } else {
                if (head==null) {
                    head=l2;
                    step=head;
                } else {
                    step.next=l2;
                    step=step.next;
                }

                l2 = l2.next;
            }

        }

        if (l1!=null) {
            step.next=l1;
        } else if (l2!=null) {
            step.next=l2;
        }

        return head;
    }

    public static class ListNode {
      public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
  }
}
