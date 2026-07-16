# 23. Merge k Sorted Lists

**Difficulty:** Hard
**Tags:** Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort
**Language:** java
**Problem:** [https://leetcode.com/problems/merge-k-sorted-lists/](https://leetcode.com/problems/merge-k-sorted-lists/)

## Description

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

_Merge all the linked-lists into one sorted linked-list and return it._

 

**Example 1:**
    
    
    **Input:** lists = [[1,4,5],[1,3,4],[2,6]]
    **Output:** [1,1,2,3,4,4,5,6]
    **Explanation:** The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted linked list:
    1->1->2->3->4->4->5->6
    

**Example 2:**
    
    
    **Input:** lists = []
    **Output:** []
    

**Example 3:**
    
    
    **Input:** lists = [[]]
    **Output:** []
    

 

**Constraints:**

  * `k == lists.length`
  * `0 <= k <= 104`
  * `0 <= lists[i].length <= 500`
  * `-104 <= lists[i][j] <= 104`
  * `lists[i]` is sorted in **ascending order**.
  * The sum of `lists[i].length` will not exceed `104`.

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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b)-> a.val-b.val
        );


        for(ListNode node : lists){
            if(node!=null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();

            tail.next=curr;
            tail=tail.next;

            if(curr.next!=null){
                pq.add(curr.next);
            }
        }

        return dummy.next;

        
    }
}
```
