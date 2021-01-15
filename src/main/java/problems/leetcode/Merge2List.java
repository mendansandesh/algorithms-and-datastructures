package problems.leetcode;


/**
 * @author sandesh.mendan on 07/01/21
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/merge-two-sorted-lists/
// Level: Easy
// TimeComplexity: O(M + N)
// SpaceComplexity: O(M + N)
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Merge2List {
    public static void main(String[] a){
        ListNode l1 = new ListNode(-9, new ListNode(3, null));
        ListNode l2 = new ListNode(5, new ListNode(7, null));
        ListNode aa = mergeTwoLists(l1, l2);
        while (aa != null){
            System.out.println(aa.val);
            aa = aa.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode result = new ListNode();
        ListNode startl1 = l1;
        ListNode startl2 = l2;
        ListNode startl3 = result;

        while(startl1 != null && startl2 != null){
            if(startl1.val < startl2.val) {
                startl3.val = startl1.val;
                startl1 = startl1.next;
            }
            else {
                startl3.val = startl2.val;
                startl2 = startl2.next;
            }
            startl3.next = new ListNode();
            startl3 = startl3.next;
        }
        while(startl1 != null){
            startl3.val = startl1.val;
            startl1 = startl1.next;
            if(startl1 != null){
                startl3.next = new ListNode();
                startl3 = startl3.next;
            }else
                startl3 = null;
        }
        while(startl2 != null){
            startl3.val = startl2.val;
            startl2 = startl2.next;
            if(startl2 != null){
                startl3.next = new ListNode();
                startl3 = startl3.next;
            }else
                startl3 = null;
        }
        return result;
    }
}
