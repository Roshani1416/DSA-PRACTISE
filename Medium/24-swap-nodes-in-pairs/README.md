# 24. Swap Nodes in Pairs

**Difficulty:** Medium
**Tags:** Linked List, Recursion
**Language:** java
**Problem:** [https://leetcode.com/problems/swap-nodes-in-pairs/](https://leetcode.com/problems/swap-nodes-in-pairs/)

## Description

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

**Example 1:**

**Input:** head = [1,2,3,4]

**Output:** [2,1,4,3]

**Explanation:**

![](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

**Example 2:**

**Input:** head = []

**Output:** []

**Example 3:**

**Input:** head = [1]

**Output:** [1]

**Example 4:**

**Input:** head = [1,2,3]

**Output:** [2,1,3]

 

**Constraints:**

  * The number of nodes in the list is in the range `[0, 100]`.
  * `0 <= Node.val <= 100`

## Solution

```java
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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head ;

        ListNode prev = dummy ;

        while(prev.next!=null && prev.next.next!=null){

            ListNode first = prev.next;
            ListNode second = first.next;


            first.next = second.next ;
            second.next = first;
            prev.next = second ;

            prev = first;

        }

        return dummy.next;

        
    }
}
```
