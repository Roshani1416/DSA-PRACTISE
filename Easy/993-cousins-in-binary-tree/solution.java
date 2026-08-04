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
