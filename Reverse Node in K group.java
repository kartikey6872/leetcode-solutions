class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1)
            return head;

        ListNode temp = head;

        for(int i = 0; i < k; i++) {
            if(temp == null)
                return head;
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        for(int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // this is line is important this is work as connector
        // 2 → 1    3 → 4 → 5
  //////////   ↑(head after reverse)
  // needs connection

        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
