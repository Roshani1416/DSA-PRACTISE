# 98. Validate Binary Search Tree

**Difficulty:** Medium
**Tags:** Tree, Depth-First Search, Binary Search Tree, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/validate-binary-search-tree/](https://leetcode.com/problems/validate-binary-search-tree/)

## Description

Given the `root` of a binary tree, _determine if it is a valid binary search tree (BST)_.

A **valid BST** is defined as follows:

  * The left subtree of a node contains only nodes with keys **strictly less than** the node's key.
  * The right subtree of a node contains only nodes with keys **strictly greater than** the node's key.
  * Both the left and right subtrees must also be binary search trees.



 

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg)
    
    
    **Input:** root = [2,1,3]
    **Output:** true
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg)
    
    
    **Input:** root = [5,1,4,null,null,3,6]
    **Output:** false
    **Explanation:** The root node's value is 5 but its right child's value is 4.
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[1, 104]`.
  * `-231 <= Node.val <= 231 - 1`

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

    TreeNode prevnode = null;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        inorder(root);
        return ans;

    }

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prevnode != null && prevnode.val >= root.val) {

            ans = false;

        }

        prevnode = root;
        inorder(root.right);

    }
}
```
