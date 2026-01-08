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

    public static ListNode getKNode(ListNode temp, int k)
    {
        k -= 1;

        while(temp != null && k > 0)
        {
            k--;

            temp = temp.next;
        }

        return temp;
        
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null)
        {
            ListNode kNode = getKNode(temp, k);

            if(kNode == null)
            {
                if(prevLast != null)
                {
                    prevLast.next = temp;
                }

                break;
            }

            ListNode nextNode = kNode.next;
            kNode.next = null;

            reverseList(temp);

            if(temp == head)
            {
                head = kNode;
            }
            else
            {
                prevLast.next = kNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
        
    }
}