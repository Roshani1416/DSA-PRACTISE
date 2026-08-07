# 872. Leaf-Similar Trees

**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/leaf-similar-trees/](https://leetcode.com/problems/leaf-similar-trees/)

## Description

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a **leaf value sequence** _._

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png)

For example, in the given tree above, the leaf value sequence is `(6, 7, 4, 9, 8)`.

Two binary trees are considered _leaf-similar_  if their leaf value sequence is the same.

Return `true` if and only if the two given trees with head nodes `root1` and `root2` are leaf-similar.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/03/leaf-similar-1.jpg)
    
    
    **Input:** root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
    **Output:** true
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/03/leaf-similar-2.jpg)
    
    
    **Input:** root1 = [1,2,3], root2 = [1,3,2]
    **Output:** false
    

 

**Constraints:**

  * The number of nodes in each tree will be in the range `[1, 200]`.
  * Both of the given trees will have values in the range `[0, 200]`.

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getleaves(root1,list1);
        getleaves(root2,list2);

        return list1.equals(list2);
        
    }

    public void getleaves(TreeNode root,List<Integer> list){

        if(root==null){
            return;
        }

        if(root.left==null &&  root.right==null){
            list.add(root.val);
            return;
        }

        getleaves(root.left,list);
        getleaves(root.right,list);
    }
}
```
