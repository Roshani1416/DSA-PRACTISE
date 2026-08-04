# 993. Cousins in Binary Tree

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Breadth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/cousins-in-binary-tree/](https://leetcode.com/problems/cousins-in-binary-tree/)

## Description

Given the `root` of a binary tree with unique values and the values of two different nodes of the tree `x` and `y`, return `true` _if the nodes corresponding to the values_`x` _and_`y` _in the tree are**cousins** , or _`false` _otherwise._

Two nodes of a binary tree are **cousins** if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth `0`, and children of each depth `k` node are at the depth `k + 1`.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/02/12/q1248-01.png)
    
    
    **Input:** root = [1,2,3,4], x = 4, y = 3
    **Output:** false
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2019/02/12/q1248-02.png)
    
    
    **Input:** root = [1,2,3,null,4,null,5], x = 5, y = 4
    **Output:** true
    

**Example 3:**

![](https://assets.leetcode.com/uploads/2019/02/13/q1248-03.png)
    
    
    **Input:** root = [1,2,3,null,4], x = 2, y = 3
    **Output:** false
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[2, 100]`.
  * `1 <= Node.val <= 100`
  * Each node has a **unique** value.
  * `x != y`
  * `x` and `y` are exist in the tree.

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

    public boolean isCousins(TreeNode root, int x, int y) {

        int depthx = depth(root, x, 0);
        int depthy = depth(root, y, 0);

        TreeNode xparent = findparent(root,x);
        TreeNode yparent = findparent(root,y);

        if(xparent!=yparent && depthx==depthy){
            return true;
        }

        return false;

    }

    public TreeNode findparent(TreeNode root, int target) {

        if (root == null) {
            return null;
        }

        if ((root.left != null && root.left.val == target) ||
                (root.right != null && root.right.val == target)) {
            return root;
        }

        TreeNode left = findparent(root.left, target);

        if (left != null) {
            return left;
        }

        return findparent(root.right, target);

    }

    public int depth(TreeNode root, int target, int depth) {

        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            return depth;
        }

        int left = depth(root.left, target, depth + 1);

        if (left != -1) {
            return left;
        }
        return depth(root.right, target, depth + 1);
    }

}
```
