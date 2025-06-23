import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetProblemSwapNodesInPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            return swapRecursive(head);
        }
        public ListNode swapRecursive(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = newHead.next;
            newHead.next = head;
            newHead.next.next = swapRecursive(newHead.next.next);
            return newHead;
        }
    }

    @Test
    public void testMed() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode s =  solution.swapPairs(head);
        while (s != null) {
            System.out.println(s.val);
            s = s.next;
        }
    }

    @Test
    public void testMed2() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode s =  solution.swapPairs(head);
        while (s != null) {
            System.out.println(s.val);
            s = s.next;
        }
    }

    @Test
    public void testMed3() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next = head2;
        head2.next = head3;
        ListNode s =  solution.swapPairs(head);
        while (s != null) {
            System.out.println(s.val);
            s = s.next;
        }
    }

}
