class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for two partitions
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);

        ListNode before = beforeDummy;
        ListNode after = afterDummy;


        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {
                before.next = curr;
                before = before.next;
            } 
            else {
                after.next = curr;
                after = after.next;
            }

            curr = curr.next;
        }


        // Important: terminate second list
        after.next = null;


        // Join both lists
        before.next = afterDummy.next;


        return beforeDummy.next;
    }
}
