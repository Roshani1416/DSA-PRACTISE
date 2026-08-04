# 144. Binary Tree Preorder Traversal

**Difficulty:** Easy
**Tags:** Stack, Tree, Depth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/binary-tree-preorder-traversal/](https://leetcode.com/problems/binary-tree-preorder-traversal/)

## Description

Given the `root` of a binary tree, return _the preorder traversal of its nodes ' values_.

 

**Example 1:**

**Input:** root = [1,null,2,3]

**Output:** [1,2,3]

**Explanation:**

![](https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png)

**Example 2:**

**Input:** root = [1,2,3,4,5,null,8,null,null,6,7,9]

**Output:** [1,2,4,5,6,7,3,8,9]

**Explanation:**

![](https://assets.leetcode.com/uploads/2024/08/29/tree_2.png)

**Example 3:**

**Input:** root = []

**Output:** []

**Example 4:**

**Input:** root = [1]

**Output:** [1]

 

**Constraints:**

  * The number of nodes in the tree is in the range `[0, 100]`.
  * `-100 <= Node.val <= 100`



 

**Follow up:** Recursive solution is trivial, could you do it iteratively?

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
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        
        list.add(root.val);
        preorderTraversal(root.left);
        
        preorderTraversal(root.right);

        return list;
        
        
    }
}
```
