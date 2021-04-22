package problems.leetcode;

public class PalindromeLinkedLlist {
    public static class ListNode {
        int val;
        PalindromeLinkedLlist.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, PalindromeLinkedLlist.ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        PalindromeLinkedLlist.ListNode l4 = new PalindromeLinkedLlist.ListNode(1, null);
        PalindromeLinkedLlist.ListNode l3 = new PalindromeLinkedLlist.ListNode(2, l4);
        PalindromeLinkedLlist.ListNode l2 = new PalindromeLinkedLlist.ListNode(2, l3);
        PalindromeLinkedLlist.ListNode l1 = new PalindromeLinkedLlist.ListNode(1, l2);

        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverseList(slow);
        fast = head;

        while(slow != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }
}
