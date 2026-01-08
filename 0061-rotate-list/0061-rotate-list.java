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
            return head;
        }

        int len = 1;
        ListNode last = head;
        ListNode temp = head;

        while(last.next != null)
        {
            last = last.next;
            len++;
        }



        k = k % len;

        if(k % len == 0)
        {
            return head;
        }

        System.out.print(last.val);
        last.next = head;

        for(int i = 0; i < len - k - 1; i++)
        {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;

    }
}