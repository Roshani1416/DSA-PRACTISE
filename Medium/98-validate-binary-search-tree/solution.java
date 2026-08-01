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

    TreeNode prevnode = null;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        inorder(root);
        return ans;

    }

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prevnode != null && prevnode.val >= root.val) {

            ans = false;

        }

        prevnode = root;
        inorder(root.right);

    }
}
