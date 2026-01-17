class Solution {
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && list.get(i) > list.get(stk.peek())) {
                res[stk.pop()] = list.get(i);
            }
            stk.push(i);
        }

        return res;
    }
}
