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

    Queue<TreeNode> queue = new LinkedList<>();

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode presentnode = queue.remove();
            if (presentnode.val == val) {
                return presentnode;
            }

            else {
                if (presentnode.left != null) {
                    queue.add(presentnode.left);
                }
                if (presentnode.right != null) {
                    queue.add(presentnode.right);
                }
            }
        }

        return null;

    }

}
