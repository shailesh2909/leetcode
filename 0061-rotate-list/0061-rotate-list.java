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

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null)
        {
            return null;
        }

        int len = 1;
        
        ListNode last = head;

        while(last.next != null)
        {
            last = last.next;
            len++;
        }

        k = k % len;

        if(k == 0) return head;
        last.next = head;
        ListNode temp = head;

        for(int i = 1; i < len - k; i++)
        {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;

    }
}