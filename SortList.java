class Solution {
    public ListNode sortList(ListNode head) {

        if(head==null || head.next == null)
        return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
            ListNode right = slow.next;
            slow.next = null;
            
            ListNode left = sortList(head);
            right = sortList(right);

            return merge(left,right);
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(a!=null && b!=null){
            if(a.val<b.val){
                temp.next = a;
                a = a.next;

            }
            else{
                temp.next = b;
                b = b.next;

            }
            temp = temp.next;

        }
        if(a!=null){
            temp.next = a;

        }
        else{
            temp.next = b;

        }
        return head.next;   
        
    }
}
