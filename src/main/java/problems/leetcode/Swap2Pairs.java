package problems.leetcode;
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class Swap2Pairs {
    public static class ListNode {
        int val;
        Swap2Pairs.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, Swap2Pairs.ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        Swap2Pairs.ListNode l4 = new Swap2Pairs.ListNode(40, null);
        Swap2Pairs.ListNode l3 = new Swap2Pairs.ListNode(30, l4);
        Swap2Pairs.ListNode l2 = new Swap2Pairs.ListNode(20, l3);
        Swap2Pairs.ListNode l1 = new Swap2Pairs.ListNode(10, l2);
        Swap2Pairs.ListNode head = swapPairs(l1);
        System.out.println(head.val + " > " + head.next.val + " > " + head.next.next.val + " > " + head.next.next.next.val);
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode curr = temp;
        while(curr.next != null && curr.next.next != null){
            ListNode firstNode = curr.next;
            ListNode secondNode = curr.next.next;
            firstNode.next = secondNode.next;
            curr.next = secondNode;
            curr.next.next = firstNode;
            curr = curr.next.next;
        }
        return temp.next;
    }
}
