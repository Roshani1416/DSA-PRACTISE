# 236. Lowest Common Ancestor of a Binary Tree

**Difficulty:** Medium
**Tags:** Tree, Depth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## Description

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): "The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**)."

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
    
    
    **Input:** root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    **Output:** 3
    **Explanation:** The LCA of nodes 5 and 1 is 3.
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
    
    
    **Input:** root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    **Output:** 5
    **Explanation:** The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
    

**Example 3:**
    
    
    **Input:** root = [1,2], p = 1, q = 2
    **Output:** 1
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[2, 105]`.
  * `-109 <= Node.val <= 109`
  * All `Node.val` are **unique**.
  * `p != q`
  * `p` and `q` will exist in the tree.

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        
        fun(root,p,q);

        return ans ;

        
    }

    public int fun(TreeNode node , TreeNode p , TreeNode q){

        if(node==null){
            return 0;
        }

        int left = fun(node.left,p,q);
        int right = fun(node.right,p,q);

        int self = 0;
        if(node==p || node == q){
            self=1;
        }

        int total = left + right + self;

        if(total==2 && ans == null){
            ans = node;
        }

        return total;
    }


}
```
