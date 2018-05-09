package leetcode2;

import java.util.Random;

public class CopyListRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head==null) {
            return null;
        }

        RandomListNode walk = head;

        while(walk!=null) {
            RandomListNode clone = new RandomListNode(walk.label);
            clone.next = walk.next;
            walk.next = clone;

            walk = clone.next;
        }

        walk = head;

        while(walk!=null) {
            if (walk.random!=null) {
                walk.next.random = walk.random.next;
            }
            walk = walk.next.next;
        }

        walk = head;
        RandomListNode newHead = head.next;

        while(walk!=null) {
            RandomListNode temp = walk.next.next;
            if (temp!=null) {
                walk.next.next = temp.next;
            }
            walk.next = temp;
            walk = walk.next;
        }

        return newHead;
    }


    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }
}
