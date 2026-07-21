# 82. Remove Duplicates from Sorted List II

**Difficulty:** Medium
**Tags:** Linked List, Two Pointers
**Language:** java
**Problem:** [https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

## Description

Given the `head` of a sorted linked list, _delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list_. Return _the linked list**sorted** as well_.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg)
    
    
    **Input:** head = [1,2,3,3,4,4,5]
    **Output:** [1,2,5]
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg)
    
    
    **Input:** head = [1,1,1,2,3]
    **Output:** [2,3]
    

 

**Constraints:**

  * The number of nodes in the list is in the range `[0, 300]`.
  * `-100 <= Node.val <= 100`
  * The list is guaranteed to be **sorted** in ascending order.

## Solution

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

           
            if (curr.next != null && curr.val == curr.next.val) {

                int duplicateValue = curr.val;

                
                while (curr != null && curr.val == duplicateValue) {
                    curr = curr.next;
                }

               
                prev.next = curr;

            } 
            else {
                
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
```
