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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null)
        {
            return null;
        }

        if(list1 == null)
        {
            return list2;
        }

        if(list2 == null)
        {
            return list1;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1 != null && temp2 != null)
        {
            arr.add(temp1.val);
            arr.add(temp2.val);

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null)
        {
            arr.add(temp1.val);

            temp1 = temp1.next;
        }

        while(temp2 != null)
        {
            arr.add(temp2.val);

            temp2 = temp2.next;
        }

        Collections.sort(arr);

        ListNode headTemp = new ListNode(-1);
        ListNode temp = headTemp;

        int i = 0;
        while(i < arr.size())
        {
            ListNode t = new ListNode(arr.get(i));
            System.out.println(t.val);
            temp.next = t;
            temp = temp.next;
            i++;
        }

        return headTemp.next;
    }
}