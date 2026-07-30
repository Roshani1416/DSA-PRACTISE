# 110. Balanced Binary Tree

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/balanced-binary-tree/](https://leetcode.com/problems/balanced-binary-tree/)

## Description

Given a binary tree, determine if it is **height-balanced**.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg)
    
    
    **Input:** root = [3,9,20,null,null,15,7]
    **Output:** true
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg)
    
    
    **Input:** root = [1,2,2,3,3,null,null,4,4]
    **Output:** false
    

**Example 3:**
    
    
    **Input:** root = []
    **Output:** true
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[0, 5000]`.
  * `-104 <= Node.val <= 104`

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
    public boolean isBalanced(TreeNode root) {

        if(root==null){
            return true;
        }

        int leftheight=height(root.left);
        int rightheight=height(root.right);

        if(Math.abs(leftheight-rightheight)>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
        
    }


    public int height(TreeNode root){

        if(root==null){
            return 0;
        }

        return 1+Math.max(height(root.left),height(root.right));

    }

   

        


    
}
```
