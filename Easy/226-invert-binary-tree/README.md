# 226. Invert Binary Tree

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Breadth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/invert-binary-tree/](https://leetcode.com/problems/invert-binary-tree/)

## Description

Given the `root` of a binary tree, invert the tree, and return _its root_.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)
    
    
    **Input:** root = [4,2,7,1,3,6,9]
    **Output:** [4,7,2,9,6,3,1]
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg)
    
    
    **Input:** root = [2,1,3]
    **Output:** [2,3,1]
    

**Example 3:**
    
    
    **Input:** root = []
    **Output:** []
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[0, 100]`.
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
    public TreeNode invertTree(TreeNode root) {

        if(root==null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left=right;
        root.right=left;

        return root;



       


        
    }

    
}
```
