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
    public ListNode oddEvenList(ListNode head) {

        
        ListNode odd = head ;

        if(odd==null){
            return head; 
        }
    
        ListNode even = odd.next ;
        ListNode dummy = even;
        

        while(even!=null && even.next!=null ){
            ListNode nextodd=even.next;
            ListNode nexteven =nextodd.next;

            odd.next=nextodd;
            even.next = nexteven;
            

            odd=nextodd;
            even=nexteven;

        }

        odd.next=dummy;

        return head;



        
    }
}
