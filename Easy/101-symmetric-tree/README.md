# 101. Symmetric Tree

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Breadth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/symmetric-tree/](https://leetcode.com/problems/symmetric-tree/)

## Description

Given the `root` of a binary tree, _check whether it is a mirror of itself_ (i.e., symmetric around its center).

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg)
    
    
    **Input:** root = [1,2,2,3,4,4,3]
    **Output:** true
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg)
    
    
    **Input:** root = [1,2,2,null,3,null,3]
    **Output:** false
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[1, 1000]`.
  * `-100 <= Node.val <= 100`



 

**Follow up:** Could you solve it both recursively and iteratively?

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
    public boolean isSymmetric(TreeNode root) {

        TreeNode root1= root.left;
        TreeNode root2= root.right;

        return symmetry(root1,root2);

        

        
        
    }

    public boolean symmetry( TreeNode root1 , TreeNode root2){

        if(root1==null && root2==null){
            return true;
        }

        if(root1 == null || root2==null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        boolean r1 = symmetry(root1.left,root2.right);
        boolean r2 = symmetry(root1.right,root2.left);

        return r1 && r2;

    }

    
}
```
