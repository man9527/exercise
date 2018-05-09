package ch02;

import leecode.MergeTwoSortedLists.*;

/**
 * https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l1.next = l2;

        new PartitionList().partition(l1, 2);
    }
    public ListNode partition(ListNode head, int x) {

        if (head==null) {
            return head;
        }

        ListNode smaller = null;
        ListNode smallerCurrent = null;

        ListNode larger = null;
        ListNode largerCurrent = null;

        while(head!=null) {

            ListNode newNode = new ListNode(head.val);
            if (head.val<x) {
                if (smaller==null) {
                    smaller = newNode;
                    smallerCurrent = newNode;
                } else {
                    smallerCurrent.next=newNode;
                    smallerCurrent=smallerCurrent.next;
                }
            } else {
                if (larger==null) {
                    larger = newNode;
                    largerCurrent = newNode;
                } else {
                    largerCurrent.next=newNode;
                    largerCurrent=largerCurrent.next;
                }
            }

            head = head.next;
        }

        if (smallerCurrent!=null) {
            smallerCurrent.next = larger;
        } else {
            return larger;
        }

        return smaller;
    }
}
