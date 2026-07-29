# 653. Two Sum IV - Input is a BST

**Difficulty:** Easy
**Tags:** Hash Table, Two Pointers, Tree, Depth-First Search, Breadth-First Search, Binary Search Tree, Binary Tree
**Language:** java
**Problem:** [https://leetcode.com/problems/two-sum-iv-input-is-a-bst/](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)

## Description

Given the `root` of a binary search tree and an integer `k`, return `true` _if there exist two elements in the BST such that their sum is equal to_ `k`, _or_ `false` _otherwise_.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/21/sum_tree_1.jpg)
    
    
    **Input:** root = [5,3,6,2,4,null,7], k = 9
    **Output:** true
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/21/sum_tree_2.jpg)
    
    
    **Input:** root = [5,3,6,2,4,null,7], k = 28
    **Output:** false
    

 

**Constraints:**

  * The number of nodes in the tree is in the range `[1, 104]`.
  * `-104 <= Node.val <= 104`
  * `root` is guaranteed to be a **valid** binary search tree.
  * `-105 <= k <= 105`

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

    Stack<TreeNode> asc= new Stack<>();
    Stack<TreeNode> desc = new Stack<>();


    public boolean findTarget(TreeNode root, int k) {

        pushleft(root);
        pushright(root);

        TreeNode small= getnext();
        TreeNode big = getprev();

        while ( small!=null && big!=null && small!=big){

            int sum = small.val + big.val;

            if(sum==k){
                return true;

            }

            if(sum<k){
                small=getnext();
            }

            else{
                big=getprev();
            }
        }

        return false;

        
        
    }

    private void pushleft(TreeNode node){
        while(node!=null){
            asc.push(node);
            node=node.left;
        }
    }

    private void pushright(TreeNode node){
        while(node!=null){
            desc.push(node);
            node=node.right;
        }
    }

    private TreeNode getnext() {

        if (asc.isEmpty()) {
            return null;
        }

        TreeNode small = asc.pop();

        TreeNode rightChild = small.right;

        while (rightChild != null) {
            asc.push(rightChild);
            rightChild = rightChild.left;
        }

        return small;
    }

    // Next largest node
    private TreeNode getprev() {

        if (desc.isEmpty()) {
            return null;
        }

        TreeNode big = desc.pop();

        TreeNode leftChild = big.left;

        while (leftChild != null) {
            desc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big;
    }
}
```
