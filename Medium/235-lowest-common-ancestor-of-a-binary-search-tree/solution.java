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

        if(root==null){
            return null;
        }

        fun(root,p,q);

        return ans;
        
    }

    public void fun(TreeNode root , TreeNode p , TreeNode q){

        if(p==root || q==root){
            ans=root;
            return;
        }

        else if (root.val < p.val && root.val<q.val){
            fun(root.right,p,q);

        }

        else if (root.val > p.val && root.val > q.val){
            fun(root.left,p,q);
        }

        else {
            ans = root;
            return;
        }
    }
}
