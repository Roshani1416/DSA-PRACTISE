# 230. Kth Smallest Element in a BST

**Difficulty:** Medium
**Tags:** Tree, Depth-First Search, Binary Search Tree, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/kth-smallest-element-in-a-bst/](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

## Description

Given the `root` of a binary search tree, and an integer `k`, return _the_ `kth` _smallest value (**1-indexed**) of all the values of the nodes in the tree_.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg)
    
    
    **Input:** root = [3,1,4,null,2], k = 1
    **Output:** 1
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg)
    
    
    **Input:** root = [5,3,6,2,4,null,null,1], k = 3
    **Output:** 3
    

 

**Constraints:**

  * The number of nodes in the tree is `n`.
  * `1 <= k <= n <= 104`
  * `0 <= Node.val <= 104`



 

**Follow up:** If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int count = 0;
    int ans =0;
    public int kthSmallest(TreeNode root, int k) {

        if(root==null){
            return 0;
        }

        return inorder(root,k);




        
    }

    public int inorder(TreeNode root,int k){

        if(root==null){
            return 0;
        }

        inorder(root.left,k);
        count++;
        if(count==k){
            ans= root.val;
        }

        inorder(root.right,k);

        return ans;

    }
}
```
