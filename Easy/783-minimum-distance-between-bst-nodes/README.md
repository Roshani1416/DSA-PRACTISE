# 783. Minimum Distance Between BST Nodes

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Breadth-First Search, Binary Search Tree, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/minimum-distance-between-bst-nodes/](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)

## Description

Given the `root` of a Binary Search Tree (BST), return _the minimum difference between the values of any two different nodes in the tree_.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg)
    
    
    **Input:** root = [4,2,6,1,3]
    **Output:** 1
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg)
    
    
    **Input:** root = [1,0,48,null,null,12,49]
    **Output:** 1
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[2, 100]`.
  * `0 <= Node.val <= 105`



 

**Note:** This question is the same as 530: <https://leetcode.com/problems/minimum-absolute-difference-in-bst/>

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

    TreeNode prev = null;
    int mindiff =  Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {

        if(root==null){
            return 0;
        }

        inorder(root);

        return mindiff;




        
    }

    public void inorder(TreeNode root){

        if(root==null){
            return;
        }

        inorder(root.left);

        if(prev!=null){
            mindiff=Math.min(mindiff,root.val-prev.val);
        }

        prev = root;

        inorder(root.right);
    }
}
```
