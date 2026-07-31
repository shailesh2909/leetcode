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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int len = 0;

        ListNode temp = head;

        while(temp != null)
        {
            temp = temp.next;
            len++;
        }   

        ListNode prev = dummy;
        
        for(int i = 0; i < len - n; i++)
        {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }
}