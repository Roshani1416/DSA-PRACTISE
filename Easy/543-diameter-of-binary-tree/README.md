# 543. Diameter of Binary Tree

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/diameter-of-binary-tree/](https://leetcode.com/problems/diameter-of-binary-tree/)

## Description

Given the `root` of a binary tree, return _the length of the**diameter** of the tree_.

The **diameter** of a binary tree is the **length** of the longest path between any two nodes in a tree. This path may or may not pass through the `root`.

The **length** of a path between two nodes is represented by the number of edges between them.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg)
    
    
    **Input:** root = [1,2,3,4,5]
    **Output:** 3
    **Explanation:** 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    

**Example 2:**
    
    
    **Input:** root = [1,2]
    **Output:** 1
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[1, 104]`.
  * `-100 <= Node.val <= 100`

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

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

         height(root);

         return diameter;



       

    }

    public int height(TreeNode root){

        if(root==null){
            return 0;
        }

        int leftheight=height(root.left);
        int rightheight = height(root.right);

        diameter = Math.max(diameter,leftheight+rightheight);

        return 1 + Math.max(leftheight,rightheight);

    }
}
```
