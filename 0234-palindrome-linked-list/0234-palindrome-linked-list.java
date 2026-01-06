/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseList(ListNode head) {
    
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        
        front.next = head;
        head.next = null;

        return newHead;

    }

    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next == null)
        {
            return true;
        }

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow.next);

        ListNode first = head;
        ListNode sec = newHead;

        while(sec != null)
        {
            if(first.val != sec.val)
            {
                reverseList(newHead);
                return false;
            }

            first = first.next;
            sec = sec.next;
        }

        reverseList(newHead);
        return true;
    }
}