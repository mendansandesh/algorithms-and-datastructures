package problems.leetcode;

/**
 * @author sandesh.mendan on 28/08/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/reverse-linked-list/
// TimeComplexity:  O(N)
// SpaceComplexity: O(1)
public class ReverseLinkedList {
   public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static void main(String[] args) {
       ListNode l4 = new ListNode(40, null);
       ListNode l3 = new ListNode(30, l4);
       ListNode l2 = new ListNode(20, l3);
       ListNode l1 = new ListNode(10, l2);
       ListNode rev = reverseList(l1);
       System.out.println(rev.val + "> " + rev.next.val + "> " + rev.next.next.val + "> " + rev.next.next.next.val);
    }

    public static ListNode reverseList(ListNode head) {
       ListNode curr = head;
       ListNode next;
       ListNode prev = null;
       while (curr != null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
    }
}
