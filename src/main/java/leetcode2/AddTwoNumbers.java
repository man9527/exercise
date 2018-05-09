package leetcode2;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        n1.next=n2;
        n2.next=n3;

        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);

        n4.next=n5;
        n5.next=n6;

        ListNode r = new AddTwoNumbers().addTwoNumbers(n1, n4);

        System.out.println(r);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carryover = 0;

        ListNode head = null;
        ListNode current = null;
        while(l1!=null || l2!=null) {

            int v1 = l1!=null?l1.val:0;
            int v2 = l2!=null?l2.val:0;

            int r = v1+v2+carryover;

            carryover = r/10;

            ListNode n = new ListNode(r%10);
            if (head==null) {
                head = n;
                current = n;
            } else {
                current.next = n;
                current = current.next;
            }

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }

            if (carryover>0) {
                ListNode n = new ListNode(carryover);
                current.next = n;
            }
        return head;

    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
