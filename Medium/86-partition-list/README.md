# 86. Partition List

**Difficulty:** Medium
**Tags:** Linked List, Two Pointers
**Language:** java
**Problem:** [https://leetcode.com/problems/partition-list/](https://leetcode.com/problems/partition-list/)

## Description

Given the `head` of a linked list and a value `x`, partition it such that all nodes **less than** `x` come before nodes **greater than or equal** to `x`.

You should **preserve** the original relative order of the nodes in each of the two partitions.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/04/partition.jpg)
    
    
    **Input:** head = [1,4,3,2,5,2], x = 3
    **Output:** [1,2,2,4,3,5]
    

**Example 2:**
    
    
    **Input:** head = [2,1], x = 2
    **Output:** [1,2]
    

 

**Constraints:**

  * The number of nodes in the list is in the range `[0, 200]`.
  * `-100 <= Node.val <= 100`
  * `-200 <= x <= 200`

## Solution

```java
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
```
