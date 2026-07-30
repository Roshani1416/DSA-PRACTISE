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
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        sum(root);

        return sum;

    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftnode = root.left;
        TreeNode rightnode = root.right;

        if (leftnode != null && leftnode.left == null && leftnode.right == null) {
            sum = sum + leftnode.val;
        }

        sum(root.left);
        sum(root.right);

        return sum;
    }

}
