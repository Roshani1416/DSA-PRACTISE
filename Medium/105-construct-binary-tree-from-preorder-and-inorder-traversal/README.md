# 105. Construct Binary Tree from Preorder and Inorder Traversal

**Difficulty:** Medium
**Tags:** Array, Hash Table, Divide and Conquer, Tree, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## Description

Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and `inorder` is the inorder traversal of the same tree, construct and return _the binary tree_.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/tree.jpg)
    
    
    **Input:** preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    **Output:** [3,9,20,null,null,15,7]
    

**Example 2:**
    
    
    **Input:** preorder = [-1], inorder = [-1]
    **Output:** [-1]
    

 

**Constraints:**

  * `1 <= preorder.length <= 3000`
  * `inorder.length == preorder.length`
  * `-3000 <= preorder[i], inorder[i] <= 3000`
  * `preorder` and `inorder` consist of **unique** values.
  * Each value of `inorder` also appears in `preorder`.
  * `preorder` is **guaranteed** to be the preorder traversal of the tree.
  * `inorder` is **guaranteed** to be the inorder traversal of the tree.

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

    int preindex = 0 ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,inorder.length-1);


    }

    public TreeNode build(int[] preorder , int[] inorder ,int inlow , int inhigh ){

        if(inlow>inhigh){
            return  null;
        }

        int rootval = preorder[preindex];
        preindex++;
        TreeNode root = new TreeNode(rootval);

        int index = -1;

        for(int i = inlow ; i<= inhigh ; i++){
            if(inorder[i]==rootval){
                index=i;
                break;
            }
        }

        root.left = build(preorder,inorder,inlow,index-1);

        root.right = build(preorder,inorder,index+1,inhigh);

        return root;

    }
}
```
